package excelP;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ExtendRepDemo {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    ExtentReports extentReports;
    ExtentTest testStep;

    @BeforeMethod
    public void beforeTest() throws Exception {
        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        extentReports = new ExtentReports(System.getProperty("user.dir") + "\\target\\Test-output\\report.html", true);

        Map<String, String> map = new HashMap<>();
        map.put("Host Name", "Demo Insta Extent reports");
        map.put("Env", "Prod");
        map.put("tester", "praveenkumar");

        extentReports.addSystemInfo(map);
        extentReports.loadConfig(new File(projectPath + "\\extent-config.xml"));

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);


    }


    @Test
    public void test1() {
        testStep = extentReports.startTest("Extend report test name");
        testStep.log(LogStatus.INFO, "Launching url");
        driver.get("https://instagram.com/");
        testStep.log(LogStatus.INFO, "Launched url");
        driver.findElement(By.name("username")).sendKeys("PraveenG");
        testStep.log(LogStatus.PASS, "Entering user name");
        driver.findElement(By.name("password")).sendKeys("password");
        testStep.log(LogStatus.FAIL, "Entering password");
    }

    @AfterMethod
    public void afterTest() {
        extentReports.endTest(testStep);
        extentReports.flush();
        extentReports.close();
        driver.close();
    }

}

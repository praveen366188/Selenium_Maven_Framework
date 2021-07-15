package sc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import utility.ExcelUtilityFile;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ExcelDemoTestNg {
    WebDriver driver;
    String project_Path = System.getProperty("user.dir");
    ExcelUtilityFile excelUtilityFile;

    @BeforeTest
    public void beforeTest() {
//        System.setProperty("webdriver.chrome.driver", project_Path + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
//        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
//        driver.manage().window().maximize();
//        driver.get("https://instagram.com/");
        excelUtilityFile = new ExcelUtilityFile(project_Path + "\\src\\main\\resources\\testData\\td.xlsx");
    }


    @DataProvider
    public Object[][] readDataFromExcel() throws Exception {

        int rowC = excelUtilityFile.rowCount("Sheet1");
        int colc = excelUtilityFile.columnCount("Sheet1", 0);
        Object[][] objects = new Object[rowC][colc];
        for (int i = 1; i <= rowC+1; i++) {
            for (int j = 0; j < colc; j++) {
                String s=excelUtilityFile.getCellData("Sheet1", i - 1, j);

                objects[i - 1][j] = s;
            }

        }


        return objects;
    }


    @Test(dataProvider = "readDataFromExcel")
    public void test_one(String s1,String s2,String s3,String s4,String s5) throws InterruptedException {
        System.out.println("-->"+s1+"|"+s2+"|"+s3+"|"+s4+"|"+s5);
    }

    @AfterClass
    public void AfterClass() {
//        driver.close();
//        driver.quit();

    }
}

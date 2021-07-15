package sc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver;
    public static Properties properties;
    final String PROJECT_PATH = System.getProperty("user.dir");

    public BaseTest() {
        properties = new Properties();
        try {
            FileInputStream io = new FileInputStream(PROJECT_PATH + "\\src\\main\\resources\\conf\\Conf.properties");
            properties.load(io);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }


    public void initialize() {
        String url = properties.getProperty("url");
        String browser = properties.getProperty("browser");

        switch (browser) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", PROJECT_PATH + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver", PROJECT_PATH + "\\src\\main\\resources\\Drivers\\geckodriver.exe");
                driver = new ChromeDriver();
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", PROJECT_PATH + "\\src\\main\\resources\\Drivers\\msedgedriver.exe");
                driver = new ChromeDriver();
                break;
        }
        driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(url);


    }


}

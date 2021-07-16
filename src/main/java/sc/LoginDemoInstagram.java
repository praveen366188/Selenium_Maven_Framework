package sc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class LoginDemoInstagram {

    WebDriver driver;
    String project_path = System.getProperty("user.dir");
    Properties properties;

    public LoginDemoInstagram() throws Exception {
        FileInputStream io = new FileInputStream(project_path + "\\src\\main\\resources\\conf\\Conf.properties");
        properties = new Properties();
        properties.load(io);
        System.setProperty("webdriver.chrome.driver", project_path + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        String URL = properties.getProperty("url");
        driver.get(URL);
     PageFactory.initElements(driver, this);

    }

    @FindBy(name = "username")
    WebElement userName;
    @FindBy(xpath = "//input[@name='username']/preceding-sibling::span")
    WebElement userNamePlaceHolder;
    @FindBy(xpath = "//input[@name='password']/preceding-sibling::span")
    WebElement passwordPlaceHolder;
    @FindBy(xpath = "//h1[text()='Instagram']")
    WebElement instagramTitle;
    @FindBy(name = "password")
    WebElement password;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;

    @FindBy(xpath = "//div[text()='or']")
    WebElement orFieldInLoginPage;
    @FindBy(xpath = "//span[text()='Log in with Facebook']")
    WebElement loginWithFbInLoginPage;
    @FindBy(xpath = "//a[text()='Forgot password?']")
    WebElement forgotPwdLinkInLoginPage;
    @FindBy(xpath = "//span[text()='Sign up']")
    WebElement signUpInLoginPage;
    @FindBy(xpath = "//span[text()='Sign up']/../..")
    WebElement signupTextInLoginPage;

    public void login() {
        String user_Name_Instagram = properties.getProperty("username");
        String password_Instagram = properties.getProperty("password");
        Assert.assertEquals(userNamePlaceHolder.getText().trim(), "Phone number, username, or email");
        Assert.assertEquals(passwordPlaceHolder.getText().trim(), "Password");
        Assert.assertTrue(instagramTitle.isDisplayed());

        Assert.assertTrue(orFieldInLoginPage.isDisplayed());
        Assert.assertTrue(loginWithFbInLoginPage.isDisplayed());
        Assert.assertTrue(forgotPwdLinkInLoginPage.isDisplayed());
        Assert.assertTrue(signUpInLoginPage.isDisplayed());
        Assert.assertTrue(signupTextInLoginPage.isDisplayed());
        Assert.assertEquals(driver.findElements(By.xpath("//img")).size(), 7);
        Assert.assertEquals(driver.findElements(By.xpath("//footer[@role='contentinfo']//a/div")).size(), 10);


        userName.sendKeys(user_Name_Instagram);
        password.sendKeys(password_Instagram);
        loginBtn.click();
        driver.close();


    }


}

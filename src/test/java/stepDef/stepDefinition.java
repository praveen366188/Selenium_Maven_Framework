package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sc.BaseTest;
import utility.ScreenShotUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class stepDefinition {
    WebDriver driver;
    public stepDefinition(){
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        PageFactory.initElements(driver,this);
    }
    @Given("Launching the browser and navigate to the Naukri website")
    public void launching_the_browser_and_navigate_to_the_naukri_website() {


        driver.get("https://www.naukri.com/nlogin/login");
    }

    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginBtn;

    @Then("Click login button")
    public void click_login_button() {
        loginBtn.click();


    }

    @FindBy(xpath = "//div[@title='Praveenkumar Sannasi Elangovan']")
    WebElement titleVerification;


    @FindBy(xpath = "//span[text()='Resume Headline']/following-sibling::span[@class='edit icon']")
    WebElement resumeUpdateIcon;
    @FindBy(id = "resumeHeadlineTxt")
    WebElement resumeHeadlineTxt;
    @FindBy(xpath = "//button[text()='Save' and contains(@class,'blue-btn')]")
    WebElement saveInResumeHeadlineModal;

    @Then("We are updating the Resume Headline and verify")
    public void we_are_updating_the_resume_headline_and_verify() throws ParseException, InterruptedException {
        ScreenShotUtility.takeScreenShot(driver);
        titleVerification.click();
        resumeUpdateIcon.click();
        String resumeHeadlineTxtString = resumeHeadlineTxt.getText();
        System.out.println(resumeHeadlineTxtString);
        SimpleDateFormat sdf
                = new SimpleDateFormat(
                "dd-MM-yyyy");
        Date d1 = sdf.parse("22-08-2018");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDateTime now = LocalDateTime.now();


        Date d2 = sdf.parse(dtf.format(now));
        System.out.println(d1);
        System.out.println(d2);
        long difference_In_Time
                = d2.getTime() - d1.getTime();
        long difference_In_Years
                = (difference_In_Time
                / (1000l * 60 * 60 * 24 * 365));

        long difference_In_Days
                = (difference_In_Time
                / (1000 * 60 * 60 * 24))
                % 365;
        long difference_In_Months = difference_In_Days / 30;
        String UpdateStringForResumeHeadlineTxt = "Having " + difference_In_Years + " years " + difference_In_Months + " months" + " of experience in Testing software application. Experience in testing the Bank web applications, Having good experience in selenium with java, Cucumber, Karate API automation, Working in agile methodology.";
        System.out.println(UpdateStringForResumeHeadlineTxt);
        resumeHeadlineTxt.clear();
        resumeHeadlineTxt.sendKeys(UpdateStringForResumeHeadlineTxt);
        Thread.sleep(1500);
        saveInResumeHeadlineModal.click();

        Assert.assertTrue(driver.findElement(By.xpath("//div[contains(text(),'" + UpdateStringForResumeHeadlineTxt + "') and  not(contains(@class,'hidden'))]")).isDisplayed());
    }

    @FindBy(id = "usernameField")
    WebElement userName;

    @Then("Enter {string} in the username field")
    public void enterInTheUsernameField(String arg0) {
        System.out.println(userName);
        userName.sendKeys(arg0);
    }

    @FindBy(id = "passwordField")
    WebElement password;

    @And("Enter {string} in the password field")
    public void enterInThePasswordField(String arg0) {
        password.sendKeys(arg0);


    }

    @Then("We verifying the home page of the naukri profile {string}")
    public void we_verifying_the_home_page_of_the_naukri_profile(String string) {
        Assert.assertTrue(driver.findElement(By.xpath("//div[@title='" + string + "']")).isDisplayed());
    }

    @Given("We Logout from the naukri application")
    public void naukriLogout() {
        driver.close();

    }

}

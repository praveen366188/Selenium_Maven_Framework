package sc;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPg{

    public LoginPg(WebDriver driver){

        PageFactory.initElements(driver,this);
    }

    @FindBy(name = "username")
    WebElement uName;
    @FindBy(name = "password")
    WebElement pwd;
    @FindBy(xpath = "//button[@type='submit']")
    WebElement loginBtn;


    public void login(){
        uName.sendKeys(BaseTest.properties.getProperty("username"));
        pwd.sendKeys(BaseTest.properties.getProperty("password"));
        loginBtn.click();

    }


}

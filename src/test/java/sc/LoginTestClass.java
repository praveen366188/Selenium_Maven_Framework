package sc;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTestClass extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {

        initialize();

    }

    @Test
    public void loginTest() {

        LoginPg loginPg = new LoginPg(driver);
        loginPg.login();


    }


    @AfterMethod
    public void afterMethod() {

        driver.quit();

    }

}

package sc;

import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class LoginTest {


    LoginDemoInstagram login;


    public LoginTest() throws Exception {

        login=new LoginDemoInstagram();


    }

    @Test
    public void loginTestPositiveFlow(){

        login.login();

    }


}

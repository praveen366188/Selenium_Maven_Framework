package utility;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import sc.BaseTest;

import java.io.File;
import java.io.IOException;

public class ScreenShotUtility extends BaseTest {
    public static void takeScreenShot(WebDriver driver){

        try {
            File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(src,new File("C:\\Users\\91812\\IdeaProjects\\Selenium_Maven\\Cucumber\\Cucumber_Demo\\src\\test\\java\\screenshot.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package excelP;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;
import java.io.FileInputStream;
import java.util.concurrent.TimeUnit;

public class ExcelDemo1 {

    WebDriver driver;
    String projectPath = System.getProperty("user.dir");

    FileInputStream io;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;


    @DataProvider
    public Object[][] data() throws Exception {


        io = new FileInputStream(projectPath + "\\src\\main\\resources\\testData\\td.xlsx");
        wb = new XSSFWorkbook(io);
        sheet = wb.getSheet("Sheet1");
        int rowCount = sheet.getLastRowNum();
        row = sheet.getRow(0);
        int columnCount = row.getLastCellNum();

        Object[][] objects = new Object[rowCount][columnCount];

        for (int i = 1; i <= rowCount; i++) {
            row = sheet.getRow(i);
            for (int j = 0; j < columnCount; j++) {

                cell = row.getCell(j);
                String s = cell.getStringCellValue();
                objects[i - 1][j] = s;

            }


        }

        return objects;
    }

    @BeforeMethod
    public void beforeTest() throws Exception {

        System.setProperty("webdriver.chrome.driver", projectPath + "\\src\\main\\resources\\Drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://instagram.com/");


    }

    @Test(dataProvider = "data")
    public void test1(String s1, String s2, String s3, String s4, String s5) {
        System.out.println("Inside Test");

        System.out.println(s1 + "|" + s2 + "|" + s3 + "|" + s4 + "|" + s5);


    }

    @AfterMethod
    public void afterTest() {

        driver.close();

    }


}

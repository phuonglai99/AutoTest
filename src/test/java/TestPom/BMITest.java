package TestPom;

import Pom.BMIPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class BMITest {
    WebDriver driver;
    BMIPage bmiPage;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
        bmiPage = new BMIPage(driver);
    }
    @DataProvider(name = "test-data-invalid")
    public Object[][] dataInvalid(){
        return new Object[][]{{"1","Male","120","20","Please provide an age between 2 and 120."},
                {"3","Female","0","20","Please provide positive height value."},
                {"2","Male","120","-20","Please provide positive weight value."},
                {"121","Male","-120","0","Please provide an age between 2 and 120.\n" +
                        "Please provide positive height value.\n" +
                        "Please provide positive weight value."}};
    }
    public Object[][] dataValid(){
        return new Object[][]{{"2","","","","",""},
                {},
                {}};
    }

    @Test(dataProvider = "test-data-invalid")
    public void invalidData(String age, String gender, String height, String weight, String expectedResult){
        bmiPage.clickOnTabMetric();
        bmiPage.clickOnClearButton();
        bmiPage.fillData(age,gender,height,weight);
        bmiPage.clickOnCalulateButton();
        Assert.assertEquals(bmiPage.getErrorMsg(),expectedResult);
    }
    @Test
    public void validData(String age, String gender, String height, String weight, String expectedResult){
        bmiPage.clickOnTabMetric();
        bmiPage.clickOnClearButton();
        bmiPage.fillData(age,gender,height,weight);
        bmiPage.clickOnCalulateButton();
        Assert.assertEquals(bmiPage.getResults(),expectedResult);
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}

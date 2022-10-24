package TestPom;

import Pom.SelectOptionPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SelectOptionTest {
    WebDriver driver;
    SelectOptionPage selection;
    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    @BeforeMethod
    void initSelectOptionPage(){
        selection = new SelectOptionPage(driver);
        selection.open();
    }
    @Test
    void checkChooseOption(){
        selection.clickInOption(1);
        Assert.assertEquals(selection.valueOfOption(),"Option 1");
    }

    @AfterClass
    void quit(){
        driver.quit();
    }
}

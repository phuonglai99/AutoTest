package TestPom;

import Pom.CheckboxPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckboxTest {
    static WebDriver driver;
    CheckboxPage checkboxPage;



    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    void initCheckBoxpage() {
        this.checkboxPage = new CheckboxPage(driver);
        this.checkboxPage.open();
    }

    @Test
    void checxInCheckbox1() {
        this.checkboxPage.clickInCheckbox(1);
        Assert.assertTrue(this.checkboxPage.isSelected(1));
    }

    @Test
    void checxInCheckbox2() {
        this.checkboxPage.clickInCheckbox(2);
        Assert.assertTrue(this.checkboxPage.isSelected(2));
    }

    @AfterClass
    void quit() {
        driver.quit();
    }
}

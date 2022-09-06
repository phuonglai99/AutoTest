package TestPom;

import Pom.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    static WebDriver driver;
    LoginPage loginPage;
    static String targetUrl = "https://the-internet.herokuapp.com/login";



    @BeforeClass
    void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(targetUrl);
    }

    @BeforeMethod
    void initLoginPage() {
        this.loginPage = new LoginPage(driver);
        this.loginPage.open();
    }

    @Test
    void withValidAccount() {
        this.loginPage.fillAccount("tomsmith", "SuperSecretPassword!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/secure");
    }

    @Test
    void withInvalidAccount() {
        this.loginPage.fillAccount("tomsmith", "SuperSecretPassword");
        Assert.assertEquals(driver.getCurrentUrl(), "https://the-internet.herokuapp.com/login");
    }

    @AfterClass
    void close() {
        driver.quit();
    }
}

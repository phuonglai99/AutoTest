package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private By username = By.id("username");
    private By password = By.id("password");
    private By submit = By.tagName("button");
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void open() {
        this.driver.get("https://the-internet.herokuapp.com/login");
    }

    public void fillAccount(String user, String pass) {
        this.driver.findElement(this.username).sendKeys(new CharSequence[]{user});
        this.driver.findElement(this.password).sendKeys(new CharSequence[]{pass});
        this.driver.findElement(this.submit).click();
    }
}

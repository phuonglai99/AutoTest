package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HyperLinkPage {
    private WebDriver driver;

    public HyperLinkPage(WebDriver driver) {
        this.driver = driver;
    }

    public void clikOnLink(String link) {
        this.driver.findElement(By.linkText(link));
    }

}

package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectOptionPage {
    private WebDriver driver;
    private By dropdownLoca = By.id("dropdown");

    public SelectOptionPage(WebDriver webDriver) {
        this.driver = webDriver;
    }

    public void clickInOption(int index) {
        Select dropdown = new Select(this.driver.findElement(this.dropdownLoca));
        dropdown.selectByIndex(index);
    }

    public String valueOfOption() {
        Select dropdown = new Select(this.driver.findElement(this.dropdownLoca));
        WebElement firstOption = dropdown.getFirstSelectedOption();
        String ret = firstOption.getText();
        return ret;
    }
}

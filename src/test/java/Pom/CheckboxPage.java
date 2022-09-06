package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class CheckboxPage {

        private By checkbox = By.xpath("//form[@id='checkboxes']/input");
        private WebDriver driver;

        public CheckboxPage(WebDriver driver) {
            this.driver = driver;
        }

        public void clickInCheckbox(int index) {
            List<WebElement> checkboxs = this.driver.findElements(this.checkbox);
            if (!((WebElement)checkboxs.get(index - 1)).isSelected()) {
                ((WebElement)checkboxs.get(index - 1)).click();
            }

        }

        public boolean isSelected(int index) {
            List<WebElement> checkboxs = this.driver.findElements(this.checkbox);
            System.out.println(((WebElement)checkboxs.get(index - 1)).getText());
            return ((WebElement)checkboxs.get(index - 1)).isSelected();
        }

        public void open() {
            this.driver.get("https://the-internet.herokuapp.com/checkboxes");
        }

}

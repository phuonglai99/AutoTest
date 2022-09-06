package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class Dropdown {
    WebDriver driver;

    @BeforeClass
    void setup() {
        WebDriverManager.chromedriver().setup();
        this.driver = new ChromeDriver();
        this.driver.get("https://the-internet.herokuapp.com/dropdown");
    }

    @Test
    void getAllOptions() {
        Select dropdown = new Select(this.driver.findElement(By.id("dropdown")));
        String getAllOptions = "";
        List<WebElement> options = dropdown.getOptions();

        WebElement op;
        for(Iterator var4 = options.iterator(); var4.hasNext(); getAllOptions = getAllOptions + "\n" + op.getText()) {
            op = (WebElement)var4.next();
        }

        System.out.println(getAllOptions);
    }

    @Test
    void checkSelectOption() {
        Select dropdown = new Select(this.driver.findElement(By.id("dropdown")));
        dropdown.selectByIndex(1);
        String select = dropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(select, "Option 1");
    }

    @AfterClass
    void quit() {
        this.driver.quit();
    }
}

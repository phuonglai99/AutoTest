package Elements;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.Iterator;
import java.util.List;

public class GetQA {
    @Test
    public void getText() {
        String s = "";
        By question = By.xpath("//div[@id='box']");
        By answer = By.xpath("//div[@id='correctans1']");
        By clickToSeeAnswer = By.tagName("a");
        By select = By.tagName("select");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://istqb.patshala.com/questions/questions.php?tn=20");
        Select dropdown = new Select(driver.findElement(select));
        dropdown.selectByIndex(3);
        List<WebElement> listQA = driver.findElements(question);

        WebElement qa;
        for(Iterator var9 = listQA.iterator(); var9.hasNext(); s = s + qa.getText() + "\n") {
            qa = (WebElement)var9.next();
            qa.findElement(clickToSeeAnswer).click();
        }

        System.out.println(s);
        driver.close();
    }
}

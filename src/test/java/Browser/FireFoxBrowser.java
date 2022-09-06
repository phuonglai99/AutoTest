package Browser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FireFoxBrowser {
    public static void main(String[] args) {
        WebDriverManager.firefoxdriver().setup();
        new FirefoxDriver();
    }
}

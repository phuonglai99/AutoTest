package Pom;

<<<<<<< HEAD
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BMIPage {
    //https://www.calculator.net/bmi-calculator.html
    private By metricUnits = By.id("menuon");
    private By clearButton = By.className("clearbtn");
    private By ageTextArea = By.id("cage");
    private By genderMale = By.cssSelector("[for='csex1']");
    private By genderFemale = By.cssSelector("[for='csex2']");
    private By heightTextArea = By.id("cheightmeter");
    private By weightTextArea = By.id("ckg");
    private By calulateButton = By.cssSelector("[value='Calculate']");
    private By result = By.xpath("//div[@class='bigtext']");
    private By textErrormsg = By.className("rightresult");
    private WebDriver driver;

    public BMIPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickOnTabMetric(){
        driver.findElement(metricUnits).click();
    }
    public void clickOnClearButton(){
        driver.findElement(clearButton).click();
    }
    public void clickOnCalulateButton(){
        driver.findElement(calulateButton).click();
    }
    public void fillData(String age, String gender, String height, String weight){
        driver.findElement(ageTextArea).sendKeys(age);
        if(gender=="Male") driver.findElement(genderMale).click();
        else driver.findElement(genderFemale).click();
        driver.findElement(heightTextArea).sendKeys(height);
        driver.findElement(weightTextArea).sendKeys(weight);
    }

    public String getResults(){
        return driver.findElement(result).getText();
    }
    public String getErrorMsg(){
        return driver.findElement(textErrormsg).getText();
    }
=======
public class BMIPage {
>>>>>>> 876375782bda4c72b9f53af915ee83c35155a73b
}

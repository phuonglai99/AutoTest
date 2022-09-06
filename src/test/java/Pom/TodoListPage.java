package Pom;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TodoListPage {
    private WebDriver driver;
    private By newNameTask = By.cssSelector("input[class='new-todo']");
    private By listTaskAvailable = By.xpath("//ul[@class='todo-list']/li");
    private By numberTaskAvailable = By.xpath("//span/strong");
    private By areaLabelText = By.tagName("label");
    private By areaEditText = By.className("edit");
    private By footerDisplay = By.className("footer");
    private By iconDelete = By.className("destroy");
    private By checkBoxDone = By.cssSelector("input[class='toggle']");
    private By buttonClear = By.cssSelector("button[class='clear-completed']");

    public TodoListPage(WebDriver driver) {
        this.driver = driver;
    }

    public void insertNewTask(String nameTask) {
        this.driver.findElement(this.newNameTask).sendKeys(new CharSequence[]{nameTask});
    }

    public List<WebElement> getAllTask() {
        return this.driver.findElements(this.listTaskAvailable);
    }

    public String getTodoCount() {
        return this.driver.findElement(this.numberTaskAvailable).getText();
    }

    public WebElement getElementByIndex(int index) {
        List<WebElement> showTasks = this.driver.findElements(this.listTaskAvailable);
        WebElement targetElement = (WebElement)showTasks.get(index - 1);
        return targetElement;
    }

    public String getContentTaskByindex(int index) {
        WebElement target = this.getElementByIndex(index);
        return target.getText();
    }

    public void enableToEdit(WebElement editTask) {
        Actions act = new Actions(this.driver);
        act.doubleClick(editTask.findElement(this.areaLabelText)).perform();
    }

    public void editNameTask(String newName, WebElement editTask) {
        editTask.findElement(this.areaEditText).sendKeys(new CharSequence[]{Keys.chord(new CharSequence[]{Keys.CONTROL, "a", Keys.DELETE}), newName, "\n"});
    }

    public TodoListPage editTask(String newName, int index) {
        WebElement target = this.getElementByIndex(index);
        this.enableToEdit(target);
        this.editNameTask(newName, target);
        return new TodoListPage (this.driver);
    }

    public List<String> getAllNameOfTask(List<WebElement> showTask) {
        List<String> allNameTask = new ArrayList();
        Iterator var3 = showTask.iterator();

        while(var3.hasNext()) {
            WebElement getText = (WebElement)var3.next();
            allNameTask.add(getText.findElement(this.areaLabelText).getText());
        }

        return allNameTask;
    }

    public String getAttributeValue(WebElement element, String attribute) {
        return element.getAttribute(attribute);
    }

    public String getAttributeOfFooter(String attribute) {
        return this.driver.findElement(this.footerDisplay).getAttribute(attribute);
    }

    public String getAttribiteOfButtonClear(String attribute) {
        return this.driver.findElement(this.buttonClear).getAttribute(attribute);
    }

    public void hoverOnDeleteTask(WebElement element) {
        Actions act = new Actions(this.driver);
        act.moveToElement(element.findElement(this.areaLabelText)).perform();
    }

    public void clickDelete() {
        this.driver.findElement(this.iconDelete).click();
    }

    public void deleteTask(int index) throws InterruptedException {
        WebElement target = this.getElementByIndex(index);
        Thread.sleep(500L);
        this.hoverOnDeleteTask(target);
        this.clickDelete();
    }

    public void clickDone(WebElement element) {
        element.findElement(this.checkBoxDone).click();
    }

    public void markDone(int index) {
        WebElement target = this.getElementByIndex(index);
        this.clickDone(target);
    }
}

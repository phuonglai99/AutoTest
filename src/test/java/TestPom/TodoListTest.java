package TestPom;

import Pom.TodoListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class TodoListTest {
    static WebDriver driver;
    public TodoListPage obj1;
    public static String targetUrl = "https://todomvc.com/examples/vanillajs/";


    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(targetUrl);
    }

    @BeforeMethod
    public void addTask() {
        obj1 = new TodoListPage(driver);
        obj1.insertNewTask("task1\n");
        obj1.insertNewTask("task2\n");
    }

    @Test(
            priority = 1
    )
    public void checkDoneMark() {
        int index = 2;
        String todoCountBefore = obj1.getTodoCount();
        if (todoCountBefore.equalsIgnoreCase("")) {
            System.out.println("no task available to edit");
        } else {
            obj1.markDone(index);
            obj1.markDone(1);
            String todoCountAfter = obj1.getTodoCount();
            String checkbox = obj1.getAttributeValue(obj1.getElementByIndex(index), "class");
            List<String> taskName = obj1.getAllNameOfTask(obj1.getAllTask());
            List<String> expectedName = new ArrayList();
            expectedName.add("task1");
            expectedName.add("task2");
            Assert.assertEquals(todoCountAfter, "0");
            Assert.assertEquals(checkbox, "completed");
            Assert.assertEquals(taskName, expectedName);
        }

    }

    @Test(
            priority = 2
    )
    public void checkEditTask() {
        String name = "new2";
        int index = 1;
        String todoCountBefore = obj1.getTodoCount();
        if (todoCountBefore.equalsIgnoreCase("")) {
            System.out.println("no task available to edit");
        } else {
            obj1.editTask(name, index);
            String todoCountAfer = obj1.getTodoCount();
            String newtask = obj1.getContentTaskByindex(index);
            Assert.assertEquals(todoCountBefore, todoCountAfer);
            Assert.assertEquals(newtask, name);
        }

    }

    @Test(
            priority = 3
    )
    public void checkDeleteTask() throws InterruptedException {
        int index = 1;
        String todoCountBefore = obj1.getTodoCount();
        if (todoCountBefore.equalsIgnoreCase("")) {
            System.out.println("no task available to edit");
        } else {
            obj1.deleteTask(index);
        }

    }
}

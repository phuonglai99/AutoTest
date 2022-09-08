package TestPom;


import POJO.BMI;
import POJO.bmiData;
import Pom.BMIPage;
import com.poiji.bind.Poiji;
import com.poiji.option.PoijiOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BMITest {
    WebDriver driver;
    BMIPage bmiPage;
    List<BMI> res;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void open(){
        driver.get("https://www.calculator.net/bmi-calculator.html");
        bmiPage = new BMIPage(driver);
    }
    @DataProvider(name = "test-data-invalid")
    public Object[][] dataInvalid() throws Exception {
        Object[][] ret= new Object[][]{ {new bmiData("1","Male","120","20","Please provide an age between 2 and 120.")},
                                        {new bmiData("3","Female","0","20","Please provide positive height value.")},
                                        {new bmiData("2","Male","120","-20","Please provide positive weight value.")},
                                        {new bmiData("121","Male","-120","0","Please provide an age between 2 and 120.\n" +
                                                                "Please provide positive height value.\n" +
                                                                "Please provide positive weight value.")}
                       };
        System.out.println(readExcel());
        System.out.println(ret[1][0]);
        return ret;
    }
    @DataProvider (name = "test-data-valid")
    public Object[][] readExcel() throws Exception {
        PoijiOptions options = PoijiOptions.PoijiOptionsBuilder.settings()
                .caseInsensitive(false)
                .ignoreWhitespaces(true)
                .build();

        File file = new File("datatest/dataForBMI.xlsx");

        List<BMI> res = Poiji.fromExcel(file, BMI.class, options);
        int row = res.size();
        Object[][] arr = new Object[row][1];
            for (int i = 0; i < row; i++) {
                arr[i][0] = res.get(i);
            }
        System.out.println(arr[0][0]);
        return arr;
    }

    @Test(dataProvider ="test-data-valid")
    public void validData(BMI bmi){
            System.out.println(bmi);
            bmiPage.clickOnTabMetric();
            bmiPage.clickOnClearButton();
            bmiPage.fillData(bmi.getAge(),bmi.getGender(),bmi.getHeight(),bmi.getWeight());
            bmiPage.clickOnCalulateButton();
            Assert.assertEquals(bmiPage.getErrorMsg(),bmi.getExpectedResults() );

    }
    @Test(dataProvider ="test-data-invalid")
    public void invalidData(bmiData bmi){
        bmiPage.clickOnTabMetric();
        bmiPage.clickOnClearButton();
        bmiPage.fillData(bmi.getAge(),bmi.getGender(),bmi.getHeight(),bmi.getWeight());
        bmiPage.clickOnCalulateButton();
        Assert.assertEquals(bmiPage.getErrorMsg(),bmi.getExpectedResults() );

    }
    @AfterClass
    public void close(){
        driver.close();
    }

}

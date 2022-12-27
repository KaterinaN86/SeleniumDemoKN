package assignmentTestSuite;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.manager.SeleniumManager;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;

import java.sql.SQLOutput;
import java.time.Duration;

public class TestCase6 extends BaseTestCase{
    //method overrides method in BaseTesCase class. Driver for Edge Browser is used and wait driver is set to 3 seconds
    @BeforeTest
    void setup() {
        Reporter.log("Setting the path to edge driver");
        //System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
        Reporter.log("Initializing baseUrl variable which defines tested url");
        baseUrl = "https://www.saucedemo.com/";
        Reporter.log("Instantiating edge driver");
        driver = new FirefoxDriver();
        Reporter.log("Instantiating wait driver and defining explicit wait duration of 5 seconds");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        showDriverPath();
    }

    public void showDriverPath(){
        System.out.println(SeleniumManager.getInstance().getDriverPath("geckodriver"));
    }
}

package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

/**
 *
 */
public class TestCase4 extends TestCase2 {

    String performanceGlitchUsername = "performance_glitch_user";

    @BeforeTest
    void setup() {
        Reporter.log("Setting the path to chrome driver");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        Reporter.log("Initializing baseUrl variable which defines tested url");
        baseUrl = "https://www.saucedemo.com/";
        Reporter.log("Instantiating chrome driver");
        driver = new ChromeDriver();
        Reporter.log("Instantiating wait driver and defining explicit wait duration of 5 seconds");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        //setting zip code text to en empty string to test negative scenario
        zipCode = "";
    }

    @Test(priority = 1)
    void inputUsername() {
        Reporter.log("Wait until login wrapper element is visible.");
        System.out.println("Logging in with locked-out user username");
        //explicit wait for login for to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_wrapper-inner']")));
        Reporter.log("Filling in username text input element");
        WebElement usernameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
        System.out.println("********Setting username*******");
        usernameEl.sendKeys(performanceGlitchUsername);
    }

    @Test(priority = 13)
    void verifyEmptyZipCode() {
        Reporter.log("Verify ZIP/Postal code is empty.");
        System.out.println("Check if text input in ZIP/Postal code element is empty string");
        WebElement zipPostalEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("postalCode")));
        Assert.assertEquals(zipPostalEl.getText(), zipCode);
    }
}

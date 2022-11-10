package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * Variables for driver, URL to be tested wait driver, soft assert object are created.
 * Variables for username and password are created and initialized.
 * Declared of setup method called before the fist test is executed.
 * * Setup method initializes driver, baseUrl and wait variables.
 * Declared open test method that uses the driver to open specified web browser.
 * Declared inputUsername test method that sends input data to username text input element in login form.
 * Declared inputPassword test method that sends input data to password text input element in login form.
 * Declared login test method that submits entered data.
 * Declared terminateBrowser test method executed after all tests in the class are finished. This method uses the driver to close open browser.
 */

public class BaseTestCase {

    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;

    //creating softAssert object
    SoftAssert softAssert = new SoftAssert();

    public String username = "standard_user";
    public String password = "secret_sauce";


    //creates WebDriver instance
    @BeforeTest
    void setup() {
        Reporter.log("Setting the path to chrome driver");
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        Reporter.log("Initializing baseUrl variable which defines tested url");
        baseUrl = "https://www.saucedemo.com/";
        Reporter.log("Instantiating chrome driver");
        driver = new ChromeDriver();
        Reporter.log("Instantiating wait driver and defining explicit wait duration of 5 seconds");
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Opens browser
    @Test(priority = 0)
    void open() {
        Reporter.log("Launching web browser and opening url defined by baseUrl variable");
        System.out.println("Launching web browser");
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    void inputUsername() {
        Reporter.log("Wait until login wrapper element is visible.");
        System.out.println("Logging in");
        //explicit wait for login for to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_wrapper-inner']")));
        Reporter.log("Filling in username text input element");
        WebElement usernameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
        System.out.println("********Setting username*******");
        usernameEl.sendKeys(username);
    }

    @Test(dependsOnMethods = {"inputUsername"}, priority = 1)
    void inputPassword() {
        Reporter.log("Filling in password text input element");
        WebElement passwordEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='password']")));
        System.out.println("********Setting password*******");
        passwordEl.sendKeys(password);
    }

    @Test(dependsOnMethods = {"inputUsername", "inputPassword"}, priority = 1)
    void login() {
        Reporter.log("Log in using login button");
        System.out.println("Click login button");
        //click login button
        WebElement loginBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        loginBtn.submit();
    }

    //close browser after tests are completed
    @AfterTest
    public void terminateBrowser() {
        Reporter.log("Close browser after tests are completed");
        System.out.println("Closing browser...");
        driver.quit();
    }
}

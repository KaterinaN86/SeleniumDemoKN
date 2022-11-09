package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class BaseTestCase {

    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;

    //creating softAssert object
    SoftAssert softAssert = new SoftAssert();


    //creates WebDriver instance
    @BeforeTest
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        baseUrl = "https://www.saucedemo.com/";
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Opens browser
    @Test(priority = 0)
    void open() {
        System.out.println("Launching Chrome browser");
        driver.get(baseUrl);
    }

    @Test(priority = 1)
    void login() {
        System.out.println("Logging in");

        //explicit wait for login for to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_wrapper-inner']")));

        WebElement username = driver.findElement(By.xpath("//input[@id='user-name']"));
        System.out.println("********Setting username*******");
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        System.out.println("********Setting password*******");
        password.sendKeys("secret_sauce");
        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        System.out.println("Click login button");
        //click login button
        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.submit();
    }

    //close browser after tests are completed
    @AfterTest
    public void terminateBrowser() {
        System.out.println("Closing browser...");
        driver.quit();
    }
}

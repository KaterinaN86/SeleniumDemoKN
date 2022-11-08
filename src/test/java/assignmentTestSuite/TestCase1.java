package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Create setup method that will run first and instantiate the web driver and wait driver
 * 2. Open browser
 * 3. Login
 * 4. Verify elements are present on products page:
 * - "PRODUCTS" header
 * - shopping cart
 * - burger menu in the upper left corner
 * - Twitter, Facebook, Linkedin links
 * - Logout
 * 5. Close browser
 */

public class TestCase1 {

    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;


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
        System.out.println("Setting username");
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//input[@id='password']"));
        System.out.println("Setting password");
        password.sendKeys("secret_sauce");

        wait.until(ExpectedConditions.elementToBeClickable(By.id("login-button")));

        //click login button
        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.submit();
    }

    @Test(priority = 2)
    void verifyProductsElements() {

        //creating softAssert object
        SoftAssert softAssert = new SoftAssert();

        //using explicit wait until all elements in header are loaded
        WebElement headerContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_container")));
        //if assertion fails the following code will not be executed
        Assert.assertTrue(headerContainer.isDisplayed());

        System.out.println("*********Checking for header element********");
        boolean headerPresent = driver.findElement(By.className("title")).isDisplayed();
        softAssert.assertEquals(headerPresent, true);
        System.out.println("*********Checking for shopping cart element********");
        boolean shoppingCartPresent = driver.findElement(By.cssSelector("a.shopping_cart_link")).isDisplayed();
        softAssert.assertEquals(shoppingCartPresent, true);
        System.out.println("*********Checking for burger menu btn element********");
        WebElement burgerMenuBtn = driver.findElement(By.cssSelector("button#react-burger-menu-btn"));
        softAssert.assertEquals(burgerMenuBtn.isDisplayed(), true);

        System.out.println("*********Checking for social media links");

        //using explicit wait to make sure elements are visible in social container element
        WebElement social = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("social")));
        Assert.assertTrue(social.isDisplayed());
        //if hard assert fails this part will never execute
        System.out.println("*********Checking for twitter link");
        softAssert.assertEquals(driver.findElement(By.xpath("//li[@class='social_twitter']")).isDisplayed(), true);
        System.out.println("*********Checking for facebook link");
        softAssert.assertEquals(driver.findElement(By.xpath("//li[@class='social_facebook']")).isDisplayed(), true);
        System.out.println("*********Checking for linkedin link");
        softAssert.assertEquals(driver.findElement(By.xpath("//li[@class='social_linkedin']")).isDisplayed(), true);

        System.out.println("*********Checking for logout sidebar link");
        burgerMenuBtn.click();
        WebElement logoutEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        Assert.assertTrue(logoutEl.isDisplayed());

    }

    //close browser after tests are completed
    @AfterTest
    public void terminateBrowser() {
        driver.quit();
    }
}

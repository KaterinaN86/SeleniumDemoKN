package assignmentTestSuite;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 1. Create setup method that will run first and instantiate the web driver
 * 2. Open browser
 * 3. Close browser
 */

public class TestCase1 {

    public WebDriver driver;
    public String baseUrl;

    //creates WebDriver instance
    @Test(priority = 1)
    void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    //Opens browser
    @Test(priority = 2)
    void open() {

        driver.get("https://www.selenium.dev/selenium/web/web-form.html");

        String title = driver.getTitle();
        assertEquals("Web form", title);


    }

    @AfterTest
    public void terminateBrowser() {

        driver.quit();
    }
}

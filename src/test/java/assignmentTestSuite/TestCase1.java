package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Inherits all methods from BaseTestCase class, which means prior to execution of test methods in this class standard user has been logged in.
 * Declared test methods that verify following elements are present on products page:
 * - verifyProductsHeader test method verifies header element with text "Products" is present.
 * - verifyProductsShoppingCart test method verifies shopping cart element is present.
 * - verifyMenuBtn test method verifies burger menu element is present in the upper left corner.
 * - verifyTwitterMediaLink, verifyFacebookMediaLink and verifyLinkedinMediaLink test methods verify Twitter, Facebook and
     LinkedIn links are present correspondingly.
 * - verifyLogoutLink test method clicks on menu element in upper left corner and verifies logout link is present in menu.
 */

public class TestCase1 extends BaseTestCase {

    //creating field variable for burgerMenu element which will be used in multiple methods
    WebElement burgerMenuBtn;

    @Test(priority = 2)
    void verifyProductsHeader() {
        Reporter.log("Verify header element with text PRODUCTS is present on products home page.");
        System.out.println("*********Checking for header element********");
        boolean headerPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='header_secondary_container']/span[text()='Products']"))).isDisplayed();
        Assert.assertEquals(headerPresent, true);
    }

    @Test(priority = 3)
    void verifyProductsShoppingCart() {
        Reporter.log("Verify shopping cart element is present on products home page.");
        System.out.println("*********Checking for shopping cart element********");
        boolean shoppingCartPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.shopping_cart_link"))).isDisplayed();
        Assert.assertEquals(shoppingCartPresent, true);
    }

    @Test(priority = 4)
    void verifyMenuBtn() {
        Reporter.log("Verify burger menu element is present on upper left corner of products home page.");
        System.out.println("*********Checking for burger menu btn element********");
        //xPath locator selects the button with specified id and is positioned in the upper left corner of the page
        burgerMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='react-burger-menu-btn' and contains(@style,'left: 0px; top: 0px;')]")));
        Assert.assertEquals(burgerMenuBtn.isDisplayed(), true);
    }

    @Test(priority = 5)
    void verifyTwitterMediaLink() {
        Reporter.log("Verify twitter link is present on products home page.");
        System.out.println("*********Checking for twitter link*************");
        Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='social']/li[1]/a[@href='https://twitter.com/saucelabs']"))).isDisplayed(), true);
    }

    @Test(priority = 6)
    void verifyFacebookMediaLink() {
        Reporter.log("Verify facebook link is present on products home page.");
        System.out.println("*********Checking for facebook link***************");
        Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='social']/li[2]/a[@href='https://www.facebook.com/saucelabs']"))).isDisplayed(), true);
    }

    @Test(priority = 7)
    void verifyLinkedinMediaLink() {
        Reporter.log("Verify linkedin link is present on products home page.");
        System.out.println("*********Checking for linkedin link************");
        Assert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='social']/li[3]/a[@href='https://www.linkedin.com/company/sauce-labs/']"))).isDisplayed(), true);
    }

    @Test(priority = 8)
    void verifyLogoutLink() {
        burgerMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#react-burger-menu-btn")));
        Reporter.log("Click on menu element on upper left corner of products home page.");
        System.out.println("*********Checking for logout sidebar link");
        burgerMenuBtn.click();
        Reporter.log("Verify logout link is present in menu");
        WebElement logoutEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        Assert.assertTrue(logoutEl.isDisplayed());
    }

}

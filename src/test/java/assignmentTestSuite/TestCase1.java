package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Verify following elements are present on products page:
 * - "PRODUCTS" header
 * - shopping cart
 * - burger menu in the upper left corner
 * - Twitter, Facebook, Linkedin links
 * - Logout link in menu
 */

public class TestCase1 extends BaseTestCase {

    WebElement burgerMenuBtn;

    @Test(priority = 2)
    void verifyProductsHeader() {
        Reporter.log("Verify header element with text PRODUCTS is present on products home page.");
        System.out.println("*********Checking for header element********");
        boolean headerPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("title"))).isDisplayed();
        softAssert.assertEquals(headerPresent, true);
    }

    @Test(priority = 3)
    void verifyProductsShoppingCart() {
        Reporter.log("Verify shopping cart element is present on products home page.");
        System.out.println("*********Checking for shopping cart element********");
        boolean shoppingCartPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.shopping_cart_link"))).isDisplayed();
        softAssert.assertEquals(shoppingCartPresent, true);
    }

    @Test(priority = 4)
    void verifyMenuBtn() {
        Reporter.log("Verify burger menu element is present on upper left corner of products home page.");
        System.out.println("*********Checking for burger menu btn element********");
        //xPath locator selects the button with specified id and is positioned in the upper left corner of the page
        burgerMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@id='react-burger-menu-btn' and contains(@style,'left: 0px; top: 0px;')]")));
        softAssert.assertEquals(burgerMenuBtn.isDisplayed(), true);
    }

    @Test(priority = 5)
    void verifyTwitterMediaLink() {
        Reporter.log("Verify twitter link is present on products home page.");
        System.out.println("*********Checking for twitter link*************");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_twitter']"))).isDisplayed(), true);
    }

    @Test(priority = 6)
    void verifyFacebookMediaLink() {
        Reporter.log("Verify facebook link is present on products home page.");
        System.out.println("*********Checking for facebook link***************");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_facebook']"))).isDisplayed(), true);
    }

    @Test(priority = 7)
    void verifyLinkedinMediaLink() {
        Reporter.log("Verify linkedin link is present on products home page.");
        System.out.println("*********Checking for linkedin link************");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_linkedin']"))).isDisplayed(), true);
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

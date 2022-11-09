package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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
        // using explicit wait until all elements in header are loaded
        WebElement headerContainer = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_container")));
        Assert.assertTrue(headerContainer.isDisplayed());
        System.out.println("*********Checking for header element********");
        boolean headerPresent = driver.findElement(By.className("title")).isDisplayed();
        softAssert.assertEquals(headerPresent, true);
    }

    @Test(priority = 3)
    void verifyProductsShoppingCart() {
        System.out.println("*********Checking for shopping cart element********");
        boolean shoppingCartPresent = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.shopping_cart_link"))).isDisplayed();
        softAssert.assertEquals(shoppingCartPresent, true);
    }

    @Test(priority = 4)
    void verifyMenuBtn() {
        System.out.println("*********Checking for burger menu btn element********");
        burgerMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#react-burger-menu-btn")));
        softAssert.assertEquals(burgerMenuBtn.isDisplayed(), true);
    }

    @Test(priority = 5)
    void verifyTwitterMediaLink() {
        System.out.println("*********Checking for twitter link");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_twitter']"))).isDisplayed(), true);
    }

    @Test(priority = 6)
    void verifyFacebookMediaLink() {
        System.out.println("*********Checking for facebook link");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_facebook']"))).isDisplayed(), true);
    }

    @Test(priority = 7)
    void verifyLinkedinMediaLink() {
        System.out.println("*********Checking for linkedin link");
        softAssert.assertEquals(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[@class='social_linkedin']"))).isDisplayed(), true);
    }

    @Test(priority = 8)
    void verifyLogoutLink() {
        burgerMenuBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button#react-burger-menu-btn")));
        System.out.println("*********Checking for logout sidebar link");
        burgerMenuBtn.click();
        WebElement logoutEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("logout_sidebar_link")));
        Assert.assertTrue(logoutEl.isDisplayed());
    }

}

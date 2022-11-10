package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestCase5 extends TestCase2 {

    String problemUsername = "problem_user";

    @Test(priority = 1)
    void inputUsername() {
        Reporter.log("Wait until login wrapper element is visible.");
        System.out.println("Logging in with locked-out user username");
        //explicit wait for login for to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_wrapper-inner']")));
        Reporter.log("Filling in username text input element");
        WebElement usernameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
        System.out.println("********Setting username*******");
        usernameEl.sendKeys(problemUsername);
    }

    @Test(priority = 3)
    void verifySauceLabsBackpackTitle() {
        title = "Sauce Labs Fleece Jacket";
        Reporter.log("Verify product title on inventory item page for backpack item is set to title for fleece jacket item");
        System.out.println("******Verifying title for backpack item is set to title for fleece jacket*******");
        WebElement titleEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[1]")));
        Assert.assertEquals(titleEl.getText(), title);
    }

    @Test(priority = 4)
    void verifySauceLabsBackpackDescription() {
        description = "It's not every day that you come across a midweight quarter-zip fleece jacket capable of handling everything from a relaxing day outdoors to a busy day at the office.";
        Reporter.log("Verify product description on inventory item page for backpack item is set to description for fleece jacket item");
        System.out.println("******Verifying description for backpack is set to description for fleece jacket*******");
        WebElement descriptionEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[2]")));
        Assert.assertEquals(descriptionEl.getText(), description);
    }

    @Test(priority = 5)
    void verifySauceLabsBackpackPrice() {
        price = "$49.99";
        Reporter.log("Verify product price on inventory item page for backpack item is set to price for fleece jacket item");
        System.out.println("******Verifying price for backpack item is set to fleet jacket item price*******");
        WebElement priceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[3]")));
        Assert.assertEquals(priceEl.getText(), price);
    }

    @Test(priority = 6)
    void addProductToCart() {
        Reporter.log("Verify add to cart button on inventory item details page for backpack item is not displayed.");
        System.out.println("Product not added to cart by using \"add to cart\" button on inventory item details page ");
        boolean addToCartBtn = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("add-to-cart-sauce-labs-backpack")));
        Assert.assertEquals(addToCartBtn, true);
    }

    @Test(enabled = false, priority = 15)
    void finishOrder() {

    }

    @Test(enabled = false, priority = 15)
    void verifyThankYou() {

    }

}

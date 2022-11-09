package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * 1. Create setup method that will run first and instantiate the web driver and wait driver
 * 2. Open Edge Browser
 * 3. Login
 * 4. Click on Sauce Labs Backpack product and verify title, description and price
 */

public class TestCase2 extends BaseTestCase {

    //expected title
    String title = "Sauce Labs Backpack";
    //expected description
    String description = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    String price = "$29.99";
    String firstName = "Katerina";
    String lastName = "Naumova";
    String zipCode = "7000";

    @Test(priority = 2)
    void clickSauceLabsBackpack(){
        WebElement backpackEl = wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//a[contains(@id,'item_4')]"))));
        backpackEl.click();
        System.out.println("Clicked on Sauce Labs Backpack product");
        //waiting for container to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc_container")));
    }

    @Test(priority = 2)
    void verifySauceLabsBackpackTitle() {



        System.out.println("******Verifying title*******");
        WebElement titleEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[1]")));
        softAssert.assertEquals(titleEl.getText(), title);
        System.out.println("******Verifying description*******");
        WebElement descriptionEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[2]")));
        softAssert.assertEquals(descriptionEl.getText(), description);
        System.out.println("******Verifying price*******");
        WebElement priceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[3]")));
        softAssert.assertEquals(priceEl.getText(), price);

        System.out.println("Click button add to cart");
        WebElement addToCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("add-to-cart-sauce-labs-backpack")));
        addToCartBtn.click();

    }

    @Test(priority = 3)
    void backToProducts() {
        System.out.println("Click back to products button");
        WebElement backToProductsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
        backToProductsBtn.click();
    }

    @Test(priority = 4)
    void addFleeceJacketToCart() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        System.out.println("Adding fleece jacket product to cart");
        WebElement addFleeceJacketBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-fleece-jacket")));
        addFleeceJacketBtn.click();
    }

    @Test(priority = 5)
    void openShoppingCartPage() {
        System.out.println("Opening shopping cart page");
        WebElement shoppingCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='shopping_cart_link']")));
        shoppingCartBtn.click();
    }

    @Test(priority = 6)
    void checkoutOrder() {
        System.out.println("Checking out order");
        WebElement checkOutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkOutBtn.click();
    }

    @Test(priority = 7)
    void fillCheckoutForm() {



        System.out.println("Entering data in checkout form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_info_container")));
        System.out.println("***********Filling in first name text input");
        WebElement firstNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[1]//input")));
        firstNameEl.sendKeys(firstName);
        System.out.println("***********Filling in last name text input");
        WebElement lastNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[2]//input")));
        lastNameEl.sendKeys(lastName);
        System.out.println("***********Filling in ZIP/Postal code text input");
        WebElement zipCodeEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[3]//input")));
        zipCodeEl.sendKeys(zipCode);
        System.out.println("Click continue button");
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueBtn.submit();
        System.out.println("List of products in cart displayed");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_summary_container")));
        System.out.println("Click finish button");
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("finish")));
        finishBtn.click();
    }

    @Test(priority = 8)
    void verifyThankYou() {
        String thankYouMsg = "THANK YOU FOR YOUR ORDER";
        System.out.println("Checkout completed");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_complete_container")));
        System.out.println("*********Verifying thank you message");
        WebElement thankYouEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='complete-header']")));
        Assert.assertEquals(thankYouEl.getText(), thankYouMsg);

    }

}

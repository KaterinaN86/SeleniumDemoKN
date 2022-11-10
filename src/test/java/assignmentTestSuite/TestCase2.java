package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.Random;

/**
 * Variables for inventory item details are initialized (title, description and price).
 * Variables for input data required in check-out form are initialized (first name, last name, ZIP code).
 * Variable for thank you message when finishing order is declared.
 * Overridden setup method, Edge browser used for this test case.
 * Declared clickSauceLabsBackpack test method that opens backpack item details page.
 * Declared verifySauceLabsBackpackTitle, verifySauceLabsBackpackDescription and verifySauceLabsBackpackPrice test methods that verify corresponding data.
 * Declared addProductToCart test method that adds backpack item to cart by using "add to cart" button on inventory item details page.
 * Declared backToProducts test methods that uses "back to products" button on inventory item details page to navigate back to products home page.
 * Declared addFleeceJacketToCart test method that adds fleece jacket item to cart by using corresponding "add to cart" button on products home page.
 * Declared openShoppingCartPage test method that opens shopping cart page by using shopping cart link icon.
 * Declared checkoutOrder test method that opens check out form by using "checkout" button on shopping cart details page.
 * Declared fillFirstName, fillLastName and fillZipPostalCode test methods that fill in corresponding text input elements in checkout form. Specified values for previously defined variables are used.
 * Declared continueToCheckOut test method that uses "continue" button to open step two of check out process.
 * Declared finishOrder test method to finalize checkout process by using "finish" button.
 * Declared verifyThankYou test method that verifies specified thank you message is displayed and checkout procces is completed.
 */


public class TestCase2 extends BaseTestCase {

    String title = "Sauce Labs Backpack";
    String description = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
    String price = "$29.99";
    String firstName = "Katerina";
    String lastName = "Naumova";
    String zipCode = "7000";
    String thankYouMsg = "THANK YOU FOR YOUR ORDER";

    //method overrides method in BaseTesCase class. Driver for Edge Browser is used and wait driver is set to 3 seconds
    @BeforeTest
    void setup() {
        Reporter.log("Setting the path to edge driver");
        System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
        Reporter.log("Initializing baseUrl variable which defines tested url");
        baseUrl = "https://www.saucedemo.com/";
        Reporter.log("Instantiating edge driver");
        driver = new EdgeDriver();
        Reporter.log("Instantiating wait driver and defining explicit wait duration of 5 seconds");
        wait = new WebDriverWait(driver, Duration.ofSeconds(3));
    }

    @Test(priority = 2)
    void clickSauceLabsBackpack() {
        Reporter.log("Click on Sauce Labs Backpack product link to open inventory item details page");
        //List of link elements that lead to the details page for backpack item
        List<WebElement> backpackElements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[contains(@id,'item_4')]")));
        Random random = new Random();
        // generate random number from 0 to 1
        int number = random.nextInt(2);
        //an element from the list is randomly picked
        WebElement el = backpackElements.get(number);
        //if the element has no text than the image was clicked
        if ((el.getText() == "")) {
            System.out.println("Clicked on Sauce Labs Backpack product image");
        } else {
            System.out.println("Clicked on Sauce Labs Backpack product title");
        }
        el.click();
        //waiting for container to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc_container")));
    }

    @Test(priority = 3)
    void verifySauceLabsBackpackTitle() {
        Reporter.log("Verify product title on inventory item page is set to specified text");
        System.out.println("******Verifying title*******");
        WebElement titleEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[1]")));
        Assert.assertEquals(titleEl.getText(), title);
    }

    @Test(priority = 4)
    void verifySauceLabsBackpackDescription() {
        Reporter.log("Verify product description on inventory item page is set to specified text.");
        System.out.println("******Verifying description*******");
        WebElement descriptionEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[2]")));
        Assert.assertEquals(descriptionEl.getText(), description);
    }

    @Test(priority = 5)
    void verifySauceLabsBackpackPrice() {
        Reporter.log("Verify product price on inventory item page is set to specified value.");
        System.out.println("******Verifying price*******");
        WebElement priceEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']//div[3]")));
        Assert.assertEquals(priceEl.getText(), price);
    }

    @Test(priority = 6)
    void addProductToCart() {
        Reporter.log("Add product backpack to cart by using \"add to cart\" button on inventory item details page.");
        System.out.println("Click button \"add to cart\" for backpack item on inventory item details page");
        WebElement addToCartBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='inventory_details_desc_container']/button")));
        addToCartBtn.click();
    }

    @Test(priority = 7)
    void backToProducts() {
        Reporter.log("Go back to products home page by using \"back to products\" button.");
        System.out.println("Click back to products button on inventory item details page");
        WebElement backToProductsBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("back-to-products")));
        backToProductsBtn.click();
    }

    @Test(priority = 8)
    void addFleeceJacketToCart() {
        Reporter.log("Add fleece jacket product to cart by using \"add to cart\" button from products home page.");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        System.out.println("Adding fleece jacket product to cart");
        WebElement addFleeceJacketBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@name='add-to-cart-sauce-labs-fleece-jacket']")));
        addFleeceJacketBtn.click();
    }

    @Test(priority = 9)
    void openShoppingCartPage() {
        Reporter.log("Open shopping cart page by using button with shopping cart icon.");
        System.out.println("Opening shopping cart page");
        WebElement shoppingCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='shopping_cart_link']")));
        shoppingCartBtn.click();
    }

    @Test(priority = 10)
    void checkoutOrder() {
        Reporter.log("Open check out form by using \"check out\" button.");
        System.out.println("Checking out order");
        WebElement checkOutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkOutBtn.click();
    }

    @Test(priority = 11)
    void fillFirstName() {
        Reporter.log("Fill in text input element for first name with specified value.");
        System.out.println("Entering data in checkout form");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("checkout_info_container")));
        System.out.println("***********Filling in first name text input***************");
        WebElement firstNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[1]//input")));
        firstNameEl.sendKeys(firstName);
    }

    @Test(priority = 12)
    void fillLastName() {
        Reporter.log("Fill in text input element for last name with specified value.");
        System.out.println("***********Filling in last name text input**************");
        WebElement lastNameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[2]//input")));
        lastNameEl.sendKeys(lastName);
    }

    @Test(priority = 13)
    void fillZipPostalCode() {
        Reporter.log("Fill in text input element for ZIP/Postal code with specified value.");
        System.out.println("***********Filling in ZIP/Postal code text input**************");
        WebElement zipCodeEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout_info']//div[3]//input")));
        zipCodeEl.sendKeys(zipCode);
    }

    @Test(priority = 14)
    void continueToCheckOut() {
        Reporter.log("Use button \"continue\".");
        System.out.println("Click continue button");
        WebElement continueBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        continueBtn.submit();
    }

    @Test(priority = 15)
    void finishOrder() {
        Reporter.log("Use button \"finish\" after list of products in cart is displayed (step two of checkout).");
        System.out.println("List of products in cart displayed (final step of checkout)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("checkout_summary_container")));
        System.out.println("Click finish button");
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("finish")));
        finishBtn.click();
    }

    @Test(priority = 16)
    void verifyThankYou() {
        Reporter.log("Verify thank you message is displayed and text is equal to specified value.");
        System.out.println("Checkout completed");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_complete_container")));
        System.out.println("*********Verifying thank you message*************");
        WebElement thankYouEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='complete-header']")));
        Assert.assertEquals(thankYouEl.getText(), thankYouMsg);
    }
}

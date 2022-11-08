package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

/**
 * 1. Create setup method that will run first and instantiate the web driver and wait driver
 * 2. Open Edge Browser
 * 3. Login
 * 4. Click on Sauce Labs Backpack product and verify title, description and price
 */

public class TestCase2 {


    public WebDriver driver;
    public String baseUrl;
    public WebDriverWait wait;

    @BeforeTest
    void setup() {
        System.setProperty("webdriver.edge.driver", "src\\test\\resources\\msedgedriver.exe");
        baseUrl = "https://www.saucedemo.com/";
        driver = new EdgeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    //Opens browser
    @Test(priority = 0)
    void open() {
        System.out.println("Launching Edge browser");
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
    void verifySauceLabsBackpack() {

        //creating softAssert object
        SoftAssert softAssert = new SoftAssert();
        //expected title
        String title = "Sauce Labs Backpack";
        //expected description
        String description = "carry.allTheThings() with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";
        String price = "$29.99";

        //check inventory container is displayed
        WebElement inventoryList = wait.until(ExpectedConditions.visibilityOfElementLocated((By.className("inventory_list"))));
        Assert.assertTrue(inventoryList.isDisplayed());

        WebElement backpackEl = wait.until(ExpectedConditions.visibilityOfElementLocated((By.id("item_4_img_link"))));
        backpackEl.click();
        System.out.println("Clicked on Sauce Labs Backpack product");

        //waiting for container to load

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("inventory_details_desc_container")));

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
    void addFleeceJacketToCart(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("inventory_container")));
        System.out.println("Adding fleece jacket product to cart");
        WebElement addFleeceJacketBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("add-to-cart-sauce-labs-fleece-jacket")));
        addFleeceJacketBtn.click();
    }

    @Test(priority = 5)
    void openShoppingCartPage(){
        System.out.println("Opening shopping cart page");
        WebElement shoppingCartBtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='shopping_cart_link']")));
        shoppingCartBtn.click();
    }

    @Test(priority = 6)
    void checkoutOrder(){
        System.out.println("Checking out order");
        WebElement checkOutBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("checkout")));
        checkOutBtn.click();
    }

    @Test(priority = 7)
    void fillCheckoutForm(){

        String firstName = "Katerina";
        String lastName = "Naumova";
        String zipCode = "7000";

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
        System.out.println("Clicking finish button");
        WebElement finishBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("continue")));
        finishBtn.submit();

    }

    @Test(priority = 8)
    void verifyThankYou(){
        String thankYouMsg = "THANK YOU FOR YOUR ORDER";
        System.out.println("Checkout completed");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("checkout_complete_container")));
        System.out.println("*********Verifying thank you message");
        WebElement thankYouEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h2[@class='complete-header']")));
        Assert.assertEquals(thankYouEl.getText(),thankYouMsg);

    }

    //close browser after tests are completed
    @AfterTest
    public void terminateBrowser() {
        driver.quit();
    }


}

package assignmentTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;
/**
 * Test login with locked-out user
 * inputUsername method is overridden and username for locked out user is used.
 * Declared verifyLockedOutErrorMsg test method that verifies corresponding error message.
 * Declared verifyErrorIconIsVisible that verifies all error icons are visible, using soft asserts.
 */
public class TestCase3 extends BaseTestCase {
    String lockedOutUsername = "locked_out_user";
    String lockedOutMsg = "Epic sadface: Sorry, this user has been locked out.";

    @Test(priority = 1)
    void inputUsername() {
        Reporter.log("Wait until login wrapper element is visible.");
        System.out.println("Logging in with locked-out user username");
        //explicit wait for login for to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='login_wrapper-inner']")));
        Reporter.log("Filling in username text input element");
        WebElement usernameEl = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@id='user-name']")));
        System.out.println("********Setting username*******");
        usernameEl.sendKeys(lockedOutUsername);
    }

    @Test(priority = 2)
    void verifyLockedOutErrorMsg() {
        Reporter.log("Verifying error message corresponding to locked-out user login has appeared.");
        System.out.println("*************Checking locked-out user error message");
        WebElement lockedOutMsgEl = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@data-test='error']")));
        Assert.assertEquals(lockedOutMsgEl.getText(), lockedOutMsg);
    }

    @Test(priority = 3)
    void verifyErrorIconIsVisible() {
        Reporter.log("Verify error icons are displayed in login form");
        softAssert = new SoftAssert();
        System.out.println("********Checking all error icons are displayed*************");
        //Selecting all error icon elements
        List<WebElement> errorIconElements = (List<WebElement>) wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("error_icon")));
        for (WebElement el : errorIconElements) {
            softAssert.assertEquals(el.isDisplayed(), true);
        }
    }
}

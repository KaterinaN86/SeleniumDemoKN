package testSuiteDemo;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 * Open browser
 * login
 * close
 */

public class FirstTestCase {

    @Test(priority = 1)
    void setup(){
        System.out.println("This is setup test");
    }

    @Test(priority = 2)
    void login(){
        System.out.println("This is login test");
    }

    @Test(priority = 3)
    void teardown(){
        System.out.println("Closing browser test");
    }

//Soft asserts
//    String title = driver.getTitle();
//    SoftAssert softAssert = new SoftAssert();
//        System.out.println("*** test case two started ***");
//        softAssert.assertEquals(title, "Hello", "First soft assert failed");
//        System.out.println("hard assert success....");
//        softAssert.assertTrue(title.equals("Swag Labs"), "Second soft assert failed");
//        softAssert.assertTrue("Welcome".equals("welcomeeee"), "Third soft assert failed");
//        System.out.println("*** test case two executed successfully ***");
//        softAssert.assertAll();
}

package testSuiteDemo;

import org.testng.annotations.Test;

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
}

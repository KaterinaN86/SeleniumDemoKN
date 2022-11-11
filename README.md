# SeleniumDemoKN
Testing [https://www.saucedemo.com/](https://www.saucedemo.com/) with Selenium and TestNG using Java
==========================================================

## Going through different scenarios by calling methods in following classes:

- **/src/test/java/assignmentTestSuite/BaseTestCase**
- **/src/test/java/assignmentTestSuite/TestCase1**
- **/src/test/java/assignmentTestSuite/TestCase2**
- **/src/test/java/assignmentTestSuite/TestCase3**
- **/src/test/java/assignmentTestSuite/TestCase4**
- **/src/test/java/assignmentTestSuite/TestCase5**

## Description of methods in BaseTestCase class

 - Variables for **driver**, **URL** to be tested, **wait driver** and **soft assert** object are created.
 - Variables for **username** and **password** are created and initialized.
 - Declared of **setup** method called before the fist test is executed.
 - **Setup** method initializes **driver**, **baseUrl** and **wait** variables.
 - Declared **open** test method that uses the driver to open specified web browser.
 - Declared **inputUsername** test method that sends input data to username text input element in login form.
 - Declared **inputPassword** test method that sends input data to password text input element in login form.
 - Declared **login** test method that submits entered data.
 - Declared **terminateBrowser** test method executed after all tests in the class are finished. This method uses the driver to close open browser.

## Description of methods in TestCase1 class

- Inherits all methods from **BaseTestCase** class, which means prior to execution of test methods in this class standard user has been logged in.
- Declared test methods that verify following elements are present on products page:

  -  **verifyProductsHeader** test method verifies header element with text "Products" is present.
  - **verifyProductsShoppingCart** test method verifies shopping cart element is present.
  - **verifyMenuBtn** test method verifies burger menu element is present in the upper left corner.
  - **verifyTwitterMediaLink**, **verifyFacebookMediaLink** and **verifyLinkedinMediaLink** test methods verify Twitter, Facebook and LinkedIn links are present correspondingly.
  - **verifyLogoutLink** test method clicks on menu element in upper left corner and verifies logout link is present in menu.

## Description of methods in TestCase2 class

- Variables for inventory item details are initialized (**title**, **description** and **price**).
- Variables for input data required in check-out form are initialized (**first name**, **last name**, **ZIP code**).
- Variable for **thank you message** when finishing order is declared.
- Overridden **setup** method, **Edge** browser used for this test case.
- Declared **clickSauceLabsBackpack** test method that opens backpack item details page.
- Declared **verifySauceLabsBackpackTitle**, **verifySauceLabsBackpackDescription** and **verifySauceLabsBackpackPrice** test methods that verify corresponding data.
- Declared **addProductToCart** test method that adds backpack item to cart by using "add to cart" button on inventory item details page.
- Declared **backToProducts** test methods that uses "back to products" button on inventory item details page to navigate back to products home page.
- Declared **addFleeceJacketToCart** test method that adds fleece jacket item to cart by using corresponding "add to cart" button on products home page.
- Declared **openShoppingCartPage** test method that opens shopping cart page by using shopping cart link icon.
- Declared **checkoutOrder** test method that opens check out form by using "checkout" button on shopping cart details page.
- Declared **fillFirstName**, **fillLastName** and **fillZipPostalCode** test methods that fill in corresponding text input elements in checkout form. Specified values for previously defined variables are used.
- Declared **continueToCheckOut** test method that uses "continue" button to open step two of check out process.
- Declared **finishOrder** test method to finalize checkout process by using "finish" button.
- Declared **verifyThankYou** test method that verifies specified thank you message is displayed and checkout process is completed.

## Description of methods in TestCase3 class

### Test login with locked-out user
- **inputUsername** method is overridden and username for locked out user is used.
- Declared **verifyLockedOutErrorMsg** test method that verifies corresponding error message is displayed.
- Declared **verifyErrorIconIsVisible** that verifies all error icons are visible, using soft asserts.

## Description of methods in TestCase4 class

### Testing with **performance-glitch user** and adding negative scenario

- Test method **inputUsername** is overridden and text input for username is set to performanceGlitchUsername variable.
- Same actions are performed as in TestCase2.
- **zipCode** value is set to **empty string**.
- Declared **verifyEmptyZipCode** test method that verifies zip code value is empty string.
- Declared **verifyZipErrorMsg** test method that verifies specified error message is displayed.
- Declared **verifyCheckoutPageNotOpen** test method that verifies page with next step of checkout is not displayed when "continue" button is clicked.
- Disabled **finishOrder** and **verifyThankYou** test methods to avoid failed tests because actions in methods can not be performed.

## Description of methods in TestCase5 class

### Testing with problem user and adding negative scenario

- Test method **inputUsername** is overridden and text input for username is set to problemUsername variable.
- Same actions are performed as in TestCase2 class.
- Test methods **verifySauceLabsBackpackTitle**, **verifySauceLabsBackpackDescription** and **verifySauceLabsBackpackPrice** are overridden to verify that data for **fleece jacket item** is shown instead.
- Test method **addProductToCart** is overridden to verify button "add to cart" for backpack item on details page is not visible.
- Disabled **finishOrder** and **verifyThankYou** test methods to avoid failed tests because actions in methods can not be performed.

**Notes:**

- HTMl report for test case that was executed last is generated in **/test-output/emailable-report.html** file.

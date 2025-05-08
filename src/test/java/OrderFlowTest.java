import Pages.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import DriverManger.DriverManger;
import utilities.Global;
public class OrderFlowTest extends BaseTest {

    HomePage homePage;
    SignupPage signupPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;


    @BeforeMethod
    public void init() {
        homePage = new HomePage(DriverManger.getDriver());
        signupPage = new SignupPage();
    }

    @Test
    public void orderPlacementFlow() throws InterruptedException {

            WebDriver driver = DriverManger.getDriver();


            // Step 1: Navigate to Signup/Login page
            homePage.goToSignupLogin();

            // Step 2: Fill signup form and create account
            signupPage.enterName("Mina")
                    .enterEmail(Global.getEmail())
                    .clickOnSignUpBtn()
                    .clickOnTitleBtn()
                    .enterPassword(Global.getPassword())
                    .SelectDateBirthDate("10", "March", "2020")
                    .ClickOnNewsletter()
                    .ClickOnSpecialOffer()
                    .enterFirstName("Mina")
                    .enterLastName("Kamel")
                    .enterAddress("Address")
                    .selectCountry("Canada")
                    .enterState("state")
                    .enterCity("city")
                    .enterZipCode("12345")
                    .enterMobileNumber("01000000000")
                    .clickCreate_Account();

            // Step 3: Navigate to products page
            productsPage = homePage.goToProductsPage();

            // Step 4: Add product to cart
            cartPage = productsPage.addProductToCart();

            // Step 5: Proceed to checkout
            checkoutPage = cartPage.proceedToCheckout();

            // Step 6: Click place order
            checkoutPage.clickPlaceOrder();

            // Step 7: Enter payment details and Logout
            checkoutPage.enterPaymentDetails();

    }
}
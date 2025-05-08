import DriverManger.DriverManger;
import Pages.HomePage;
import Pages.SignupPage;
import org.testng.annotations.*;
import utilities.CommonAssertion;
import utilities.ExtentReportManager.ExtentReportListener;
import utilities.Global;

@Listeners(ExtentReportListener.class)
public class SignupTest extends BaseTest {
    HomePage homePage;
    SignupPage signup;

    @BeforeMethod
    public void init() {
        homePage = new HomePage(DriverManger.getDriver());
        signup = new SignupPage();
    }

    @Test
    public void signup() throws InterruptedException {
        String email = "rofida" + System.currentTimeMillis() + "@mail.com";
        String password = "123456";

        Global.setEmail(email);
        Global.setPassword(password);
        Global.setName("Rofida");
        Global.setMobileNumber("010");


        homePage.goToSignupLogin();
        signup.enterName(Global.getName())
                .enterEmail(Global.getEmail())
                .clickOnSignUpBtn()
                .clickOnTitleBtn()
                .enterPassword(Global.getPassword())
                .SelectDateBirthDate("10", "March", "2002")
                .ClickOnNewsletter()
                .ClickOnSpecialOffer()
                .enterFirstName("Rofida")
                .enterLastName("Araby")
                .enterAddress("address")
                .selectCountry("Canada")
                .enterState("state")
                .enterCity("city")
                .enterZipCode("code")
                .enterMobileNumber(Global.getMobileNumber())
                .clickCreate_Account();

        // Assertions
        CommonAssertion.assertPageTitle(DriverManger.getDriver(), "Automation Exercise - Account Created");
        CommonAssertion.assertTextEquals(signup.getAccountCreatedMessage(), "ACCOUNT CREATED!");
    }}

import Pages.HomePage;
import Pages.LoginPage;
import DriverManger.DriverManger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.ExtentReportManager.ExtentReportListener;
import utilities.Global;
@Listeners(ExtentReportListener.class)
public class TestLogin extends BaseTest {

    HomePage homePage;
    LoginPage loginPage;

    @BeforeMethod
    public void init(){
        homePage = new HomePage(DriverManger.getDriver());

        loginPage = new LoginPage();
    }

    @Test
    public void loginTest(){
        homePage.goToSignupLogin();
        loginPage.login(Global.getEmail(),Global.getPassword());
    }

}
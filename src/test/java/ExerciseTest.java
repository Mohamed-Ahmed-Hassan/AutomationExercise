import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.time.Duration;


public class ExerciseTest {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void loginAndVerify() {
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();

        WebElement Email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        Email.sendKeys("waadmahmou01@gmail.com");

        WebElement Password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.sendKeys("123456");

        WebElement LoginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        LoginBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement UserNAme = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(), 'Logged in as')]")));
        //Bonus Task :)

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(UserNAme.isDisplayed(), "your user name 'Waad Mahmoud' is not showing");
        softAssert.assertTrue(UserNAme.getText().contains("Waad Mahmoud"), "your username is not as expected !");
        //i tried a wrong username and it failed successfully resulting a failed yellow test  :)
        softAssert.assertAll();
    }

    @AfterMethod
    public void closeBrowser() {
        driver.quit();
    }
    }

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class ExerciseTest {

    public WebDriver driver;
    @BeforeMethod
        public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        // global waits
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        }

        @Test
        public void signup() throws InterruptedException {
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();

            WebElement nameField = driver.findElement(By.name("name"));
            nameField.sendKeys("rofid06605999321@");

            WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            email.sendKeys("Ro00097097491234@atos.net");

            WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
            signupBtn.click();

            // static and we need to be dynamic
            WebElement Title = driver.findElement(By.xpath("//input[@id='id_gender1' or @value='Mr']"));
            Title.click();
            WebElement Password = driver.findElement(By.id("password"));
            Password.sendKeys("123456789");

            WebElement DaysDropdown = driver.findElement(By.xpath("//select[@data-qa='days']"));
            Select Days= new Select(DaysDropdown);
            Days.selectByValue("22");

            WebElement MonthDropdown = driver.findElement(By.id("months"));
            Select Month= new Select(MonthDropdown);
            Month.selectByVisibleText("March");

            WebElement YearsDropdown = driver.findElement(By.id("years"));
            Select Years= new Select(YearsDropdown);
            Years.selectByIndex(2);
            WebElement newsletter= driver.findElement(By.id("newsletter"));
            newsletter.click();
            WebElement optin= driver.findElement(By.id("optin"));
            optin.click();

            WebElement First_name = driver.findElement(By.id("first_name"));
            First_name.sendKeys("rofida");
            WebElement last_name= driver.findElement(By.id("last_name"));
            last_name.sendKeys("Araby");
            WebElement Address = driver.findElement(By.id("address1"));
            Address.sendKeys("street");

            WebElement countryDropdown = driver.findElement(By.id("country"));
            Select country= new Select(countryDropdown);
            country.selectByIndex(2);

            WebElement state= driver.findElement(By.id("state"));
            state.sendKeys("A");
            WebElement city= driver.findElement(By.id("city"));
            city.sendKeys("city");
            WebElement zipcode= driver.findElement(By.id("zipcode"));
            zipcode.sendKeys("020");
            WebElement mobile_number= driver.findElement(By.id("mobile_number"));
            mobile_number.sendKeys("010");
            WebElement Create_Account= driver.findElement(By.xpath("//button[text()='Create Account']"));
            Create_Account.click();
             Thread.sleep(1000);

             // Hard Assertion.
            String AcualMassage = driver.findElement(By.xpath("//h2[@data-qa='account-created']")).getText();
            String ExpectedMassage ="ACCOUNT CREATED!";
            Assert.assertEquals(AcualMassage,ExpectedMassage,"account not created successfully");
            String ExpectedURL ="https://www.automationexercise.com/account_created";
            Assert.assertEquals( driver.getCurrentUrl(),ExpectedURL,"account not created successfully");
            // soft assertion
            SoftAssert softAssert= new SoftAssert();
            softAssert.assertEquals(AcualMassage ,ExpectedMassage,"fail");
            System.out.print("pass/fail");

            // Implicit Wait --> driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        }

        @Test
        public void login() {
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();
            WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            email.sendKeys("moRo@atos.net");
            WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
            password.sendKeys("123456789");
            WebElement loginbtn = driver.findElement(By.xpath("//button[text()='Login']"));
            loginbtn.click();
        }
        @AfterMethod
        public void closeBrowser(){
        driver.quit();
        }



}

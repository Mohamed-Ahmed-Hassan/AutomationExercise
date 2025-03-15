import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExerciseTest {

    public WebDriver driver;
    @BeforeMethod
        public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        }

      @Test
//      public void signup(){
//         WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
//            signupLoginBtn.click();
//
//            WebElement nameField = driver.findElement(By.name("name"));
//            nameField.sendKeys("Mohamed");
//
//            WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
//            email.sendKeys("hassan@atos.net");
//
//            WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
//            signupBtn.click();
//        }

        public void login(){ //menna
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();

            WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            email.sendKeys("mennaelnadyy@gmail.com");

            WebElement passField = driver.findElement(By.name("password"));
            passField.sendKeys("menna1234");

            WebElement loginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
            loginBtn.click();

            WebElement loggedInMessage = driver.findElement(By.xpath("//li[normalize-space()='Logged in as menna']"));
            String actualMessage = loggedInMessage.getText();
            String expectedMessage = "Logged in as menna";

            Assert.assertEquals(actualMessage, expectedMessage, "Login message did not match!");


        }


        @AfterMethod
        public void closeBrowser(){
        driver.quit();
        }



}

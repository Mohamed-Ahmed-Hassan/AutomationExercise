import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
        public void Login(){
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();


            WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
            email.sendKeys("ola.mohamed@atos.net");


            WebElement Password = driver.findElement(By.name("password"));
            Password.sendKeys("olamohamed@1234");


            WebElement loginBtn = driver.findElement(By.xpath("//button[text()='login']"));
            loginBtn.click();

// Assert that the username is displayed after login
            if (usernameElement.getText().equals("Your Username")) {  // Replace with the expected username
                System.out.println("Test Passed: User logged in successfully and username is displayed.");
            } else {
                System.out.println("Test Failed: Username did not appear after login."); // I found this on internet
            }


        }

        @AfterMethod


        public void closeBrowser(){
        driver.quit();
        }



}

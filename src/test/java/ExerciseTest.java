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

       /* @Test
        public void signup(){
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();

            WebElement nameField = driver.findElement(By.name("name"));
            nameField.sendKeys("Mohamed");

            WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            email.sendKeys("hassan@atos.net");

            WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
            signupBtn.click();
        }*/
    @Test
        public void login(){
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        email.sendKeys("noraa8119@gmail.com");
        WebElement password = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        password.sendKeys("123456789");

        WebElement loginbtn=driver.findElement(By.xpath("//button[text()='Login']"));
        loginbtn.click();

        }


       // @AfterMethod
        //public void closeBrowser(){
        //driver.quit();
        //}



}

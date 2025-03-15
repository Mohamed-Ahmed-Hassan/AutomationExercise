import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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
        public void signup(){
            WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
            signupLoginBtn.click();

            WebElement nameField = driver.findElement(By.name("name"));
            nameField.sendKeys("Mohamed");

            WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
            email.sendKeys("hassan@atos.net");

            WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
            signupBtn.click();
        }

    //By Mina Kamel

    @Test
    public void Login() {
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailField.sendKeys("minakamel@gmail.com");

        WebElement passwordField = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordField.sendKeys("123456789");

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBtn.click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Logged in as')]")));
        String actualText = loggedIn.getText().trim();


        Assert.assertEquals(actualText, "Logged in as Mina Kamel", "Login failed...." + actualText);


    }



    @AfterMethod
        public void closeBrowser(){
        driver.quit();
        }



}

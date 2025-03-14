import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login
{
    WebDriver driver;
    @BeforeMethod
    public void setup() {

        // Initialize WebDriver
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.automationexercise.com");
    }
    @Test
    public void Login() {
        driver.findElement(By.linkText("Signup / Login")).click();
        WebElement emailInput = driver.findElement(By.name("email"));
        emailInput.sendKeys("sohilaibrahim16@yahoo.com");
        WebElement passwordInput = driver.findElement(By.name("password"));
        passwordInput.sendKeys("123456");
        WebElement loginButton = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        loginButton.click();

        WebElement loggedInText = driver.findElement(By.xpath("//b"));
        String actualText = loggedInText.getText();
        System.out.println("Captured text: " + actualText);
        Assert.assertEquals(actualText, "sohila", "Login verification failed!");
    }

    @AfterMethod
    public void close() {
        driver.close();
    }
}

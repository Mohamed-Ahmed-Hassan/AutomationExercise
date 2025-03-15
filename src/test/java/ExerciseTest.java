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
    public void Login()  {
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();

        WebElement Email = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        Email.sendKeys("waadmahmou01@gmail.com");

        WebElement Password =driver.findElement(By.xpath("//input[@placeholder='Password']"));
        Password.sendKeys("123456");
        WebElement LoginBtn = driver.findElement(By.xpath("//button[@data-qa='login-button']"));
        LoginBtn.click();


    }
    @Test
    public void VerifyLogin(){
        WebElement WelcomeText=driver.findElement(By.xpath("a[contains(text(), ' Logged in as Waad Mahmoud')]"));
        if(WelcomeText.isDisplayed()){
            System.out.println("Displayed");
        }//changekjhvbjklkjhb
    }


    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }



}

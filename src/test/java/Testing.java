import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Testing{

public static void main(String[] args){
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("https://www.automationexercise.com");
    driver.manage().window().maximize();
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
    Assert.assertEquals(actualText, "Sohila", "Login verification failed!");

    System.out.println("Captured text: " + actualText);

}
}

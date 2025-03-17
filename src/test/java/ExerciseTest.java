import com.github.javafaker.Faker;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class ExerciseTest {

    public WebDriver driver;
    Faker faker = new Faker();
    String randomEmail;
    String randomPassword;



    @BeforeMethod
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.automationexercise.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));


    }


    @Test(priority = 1)
    public void signup() {
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();
        WebElement nameField = driver.findElement(By.name("name"));
        nameField.sendKeys("Minaaa");

        //Fake Email
        randomEmail = faker.internet().emailAddress();
        // Fake Password

        randomPassword = faker.internet().password(10,15,true,true,true);
        WebElement email = driver.findElement(By.xpath("//input[@data-qa='signup-email']"));
        email.sendKeys(randomEmail);
        WebElement signupBtn = driver.findElement(By.xpath("//button[text()='Signup']"));
        signupBtn.click();
        WebElement Title = driver.findElement(By.xpath("//input[@id='id_gender1' or @value='Mr']"));
        Title.click();
        WebElement Password = driver.findElement(By.id("password"));
        Password.sendKeys(randomPassword);
        WebElement DaysDropdown = driver.findElement(By.xpath("//select[@data-qa='days']"));
        Select Days = new Select(DaysDropdown);
        Days.selectByValue("22");
        WebElement MonthDropdown = driver.findElement(By.id("months"));
        Select Month = new Select(MonthDropdown);
        Month.selectByVisibleText("March");
        WebElement YearsDropdown = driver.findElement(By.id("years"));
        Select Years = new Select(YearsDropdown);
        Years.selectByIndex(2);
        WebElement newsletter = driver.findElement(By.id("newsletter"));
        newsletter.click();
        WebElement optin = driver.findElement(By.id("optin"));
        optin.click();
        WebElement First_name = driver.findElement(By.id("first_name"));
        First_name.sendKeys("Mina");
        WebElement last_name = driver.findElement(By.id("last_name"));
        last_name.sendKeys("Kamel");
        WebElement Address = driver.findElement(By.id("address1"));
        Address.sendKeys("street");
        WebElement countryDropdown = driver.findElement(By.id("country"));
        Select country = new Select(countryDropdown);
        country.selectByIndex(2);
        WebElement state = driver.findElement(By.id("state"));
        state.sendKeys("A");
        WebElement city = driver.findElement(By.id("city"));
        city.sendKeys("city");
        WebElement zipcode = driver.findElement(By.id("zipcode"));
        zipcode.sendKeys("020");
        WebElement mobile_number = driver.findElement(By.id("mobile_number"));
        mobile_number.sendKeys("0100000000");
        WebElement Create_Account = driver.findElement(By.xpath("//button[text()='Create Account']"));
        Create_Account.click();
    }

    //By Mina Kamel

    @Test (priority = 2, dependsOnMethods = "signup")
    public void Login() {
        WebElement signupLoginBtn = driver.findElement(By.linkText("Signup / Login"));
        signupLoginBtn.click();

        WebElement emailField = driver.findElement(By.xpath("//input[@data-qa='login-email']"));
        emailField.sendKeys(randomEmail);

        WebElement passwordField = driver.findElement(By.xpath("//input[@data-qa='login-password']"));
        passwordField.sendKeys(randomPassword);

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()='Login']"));
        loginBtn.click();

/*
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loggedIn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Logged in as')]")));
        String actualText = loggedIn.getText().trim();


        Assert.assertEquals(actualText, "Logged in as Mina Kamel", "Login failed...." + actualText);
*/

    }



    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }


}

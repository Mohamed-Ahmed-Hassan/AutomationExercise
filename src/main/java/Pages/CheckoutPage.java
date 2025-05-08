package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }



    // Click Place Order button
    public void clickPlaceOrder() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));


        // Locate the Place Order button


        driver.findElement(By.xpath("//div[@id='ordermsg']//textarea")).sendKeys("Thank you for Shopping.");
        driver.findElement(By.linkText("Place Order")).click();
        System.out.println(" Enter description in comment text area and click 'Place Order'");
    }



    // Enter payment details (example implementation)
    public void enterPaymentDetails() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Example fields for payment
        By nameOnCard = By.name("name_on_card");
        By cardNumber = By.name("card_number");
        By cvc = By.name("cvc");
        By expiryMonth = By.name("expiry_month");
        By expiryYear = By.name("expiry_year");
        By payButton = By.id("submit");

        driver.findElement(nameOnCard).sendKeys("Mina Kamel");
        driver.findElement(cardNumber).sendKeys("4111111111111111");
        driver.findElement(cvc).sendKeys("123");
        driver.findElement(expiryMonth).sendKeys("12/30");
        driver.findElement(expiryYear).sendKeys("2030");

        // Click Pay and Confirm Order
        driver.findElement(payButton).click();

       // ORDER PLACED PAGE

        Assert.assertEquals(driver.findElement(By.xpath("//section[@id='form']//h2/b")).getText(), "ORDER PLACED!");
        Assert.assertTrue(driver.findElement(By.xpath("//section[@id='form']//h2/b")).isDisplayed());
        driver.findElement(By.linkText("Continue")).click();

        // Logout
       driver.findElement(By.linkText("Logout")).click();



    }


}
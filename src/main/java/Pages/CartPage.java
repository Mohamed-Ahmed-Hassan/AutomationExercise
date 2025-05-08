package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CartPage {
    WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Go to cart page
    public void goToCartPage() {
        By cartPage = By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
        driver.findElement(cartPage).click();
    }

    // Check if product is in cart
    public boolean isProductInCart(String productName) {
        By productInCart = By.xpath("//td[@class='cart_description']//a[contains(text(), '" + productName + "')]");
        return driver.findElements(productInCart).size() > 0;
    }

    // Proceed to checkout
    public CheckoutPage proceedToCheckout() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the Proceed to Checkout button
        driver.findElement(By.linkText("Proceed To Checkout")).click();
        System.out.println(" Click Proceed To Checkout");


        return new CheckoutPage(driver);
    }
}
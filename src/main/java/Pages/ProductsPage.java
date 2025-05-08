package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductsPage {
    WebDriver driver;

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    // Add Product To Cart
    public CartPage addProductToCart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Locate the product container
        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Blue Top']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
        driver.findElement(By.xpath("//div[@class='overlay-content']/p[text()='Blue Top']//following-sibling::a[contains(@class,'add-to-cart')]")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();

        new Actions(driver).moveToElement(driver.findElement(By.xpath("//div[contains(@class,'productinfo')]/p[text()='Men Tshirt']/following-sibling::a[contains(@class,'add-to-cart')]"))).build().perform();
        driver.findElement(By.xpath("//div[@class='overlay-content']/p[text()='Men Tshirt']//following-sibling::a[contains(@class,'add-to-cart')]")).click();
        System.out.println("4. Add products to cart");
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]")))).click();
        driver.findElement(By.partialLinkText("Cart")).click();
        System.out.println("5. Click 'Cart' button");
						/*
        // Scroll to the product
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({block: 'center'});", productElement);

        // Perform hover action to make Add to Cart button visible
        Actions actions = new Actions(driver);
        actions.moveToElement(productElement).build().perform();

        // Click Add to Cart button using JavaScript
        By addToCartButton = By.xpath("//a[@data-product-id='1']");
        WebElement addToCart = wait.until(ExpectedConditions.presenceOfElementLocated(addToCartButton));
        js.executeScript("arguments[0].click();", addToCart);

        // Click Continue Shopping
        By continueShopping = By.xpath("//*[@id='cartModal']/div/div/div[3]/button");
        wait.until(ExpectedConditions.elementToBeClickable(continueShopping)).click();

        // Navigate to Cart Page
        By cartPageLink = By.xpath("//*[@id='header']/div/div/div/div[2]/div/ul/li[3]/a");
        wait.until(ExpectedConditions.elementToBeClickable(cartPageLink)).click();
*/
        return new CartPage(driver);
    }
}
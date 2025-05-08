package Pages;

import DriverManger.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class HomePage {
    WebDriver driver;

    By signupLogin = By.linkText("Signup / Login");

    public HomePage(WebDriver driver) {
        this.driver = DriverManger.getDriver();
    }

    public void goToSignupLogin() {
        ElementHelper.click(driver, signupLogin);
    }
    public ProductsPage goToProductsPage() {
        ElementHelper.click(driver, By.xpath("//a[@href='/products']"));
        return new ProductsPage(driver);
    }

}
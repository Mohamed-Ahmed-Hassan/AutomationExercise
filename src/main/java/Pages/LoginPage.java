package Pages;

import DriverManger.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;

public class LoginPage {
    WebDriver driver;

    By emailInput = By.name("email");
    By passwordInput = By.name("password");
    By loginButton = By.xpath("//button[contains(text(),'Login')]");

    public LoginPage() {
        this.driver = DriverManger.getDriver();
    }

    public void login(String email, String password) {
        ElementHelper.sendKeys(driver, emailInput, email);
        ElementHelper.sendKeys(driver, passwordInput, password);
        ElementHelper.click(driver, loginButton);
    }
}
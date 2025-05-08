package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class ElementHelper {

    public static void click(WebDriver driver, By locator) {
        driver.findElement(locator).click();
    }

    public static void sendKeys(WebDriver driver, By locator, String text) {
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(text);
    }

    public static void selectByVisibleText(WebDriver driver, By locator, String text) {
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    public static void selectByValue(WebDriver driver, By locator, String value) {
        Select select = new Select(driver.findElement(locator));
        select.selectByValue(value);
    }

    public static void selectByIndex(WebDriver driver, By locator, int index) {
        Select select = new Select(driver.findElement(locator));
        select.selectByIndex(index);
    }


    // Scroll down
    public static void scrollDown(WebDriver driver, int pixels) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0," + pixels + ")");
    }
}
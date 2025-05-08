package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

   BasePage(WebDriver driver){
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    protected void waitForVisibility(By locator){
       wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForElementToBeClickable(By locator){
       wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    protected void click(By locator){
       waitForElementToBeClickable(locator);
       driver.findElement(locator).click();
    }

    protected void sendKeys(By locator, String text){
       waitForVisibility(locator);
       driver.findElement(locator).clear();
       driver.findElement(locator).sendKeys(text);

    }
    protected  void selectByVisibleText(By locator, String text){
//        WebElement element = driver.findElement(locator);
//        Select select = new Select(element);
        Select select = new Select(driver.findElement(locator));
        select.selectByVisibleText(text);
    }

    protected void selectByValue(By locator, String value){
       Select select = new Select(driver.findElement(locator));
       select.selectByValue(value);
    }

    protected void selectByIndex(By locator , int index){
       Select select = new Select(driver.findElement(locator));
       select.selectByIndex(index);
    }


}

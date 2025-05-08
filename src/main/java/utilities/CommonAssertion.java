package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CommonAssertion {
    public static void assertPageTitle(WebDriver driver, String expectedTitle) {
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Page title does not match. Expected: " + expectedTitle + " but found: " + actualTitle);
    }
    public static void assertTextEquals(String actualText, String expectedText) {
        Assert.assertEquals(actualText, expectedText, "Text does not match. Expected: " + expectedText + " but found: " + actualText);
    }
    public static void assertElementPresent(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "The element is not displayed: " + locator);
    }

    public static void assertElementVisible(WebDriver driver, By locator) {
        WebElement element = driver.findElement(locator);
        Assert.assertTrue(element.isDisplayed(), "The element is not visible: " + locator);
    }

    public static void assertTextEquals(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertEquals(actualText, expectedText, "Text does not match. Expected: " + expectedText + " but found: " + actualText);
    }

    public static void assertTextNotEquals(WebDriver driver, By locator, String expectedText) {
        WebElement element = driver.findElement(locator);
        String actualText = element.getText();
        Assert.assertNotEquals(actualText, expectedText, "Text should not match. Found: " + actualText);
    }

    public static void assertAttributeEquals(WebDriver driver, By locator, String attribute, String expectedValue) {
        WebElement element = driver.findElement(locator);
        String actualValue = element.getAttribute(attribute);
        Assert.assertEquals(actualValue, expectedValue, "Attribute value does not match. Expected: " + expectedValue + " but found: " + actualValue);
    }

    public static void assertElementNotPresent(WebDriver driver, By locator) {
        boolean isElementPresent = driver.findElements(locator).size() > 0;
        Assert.assertFalse(isElementPresent, "Element should not be present: " + locator);
    }

    public static void assertPageContainsText(WebDriver driver, String expectedText) {
        String bodyText = driver.getPageSource();
        Assert.assertTrue(bodyText.contains(expectedText), "Page source does not contain the expected text: " + expectedText);
    }

    public static void assertInputValue(WebDriver driver, By locator, String expectedValue) {
        WebElement element = driver.findElement(locator);
        String actualValue = element.getAttribute("value");
        Assert.assertEquals(actualValue, expectedValue, "Input value does not match. Expected: " + expectedValue + " but found: " + actualValue);
    }
}


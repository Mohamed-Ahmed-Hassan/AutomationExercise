package DriverManger;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.LoadProperties;
import java.time.Duration;




public class DriverManger {
    static WebDriver driver;
    // Get browser-url from properties file
    static String Browser = LoadProperties.Browser;
    static String driverUrl = LoadProperties.driverUrl;

    public static void driverSetup() {
        if (driver == null) {

        if (Browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        } else if (Browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (Browser.equalsIgnoreCase("remote")) {

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().deleteAllCookies();
        driver.get(driverUrl);
        System.out.println("Initializing WebDriver...");
    }}
    static public WebDriver getDriver() {
        if (driver == null) {
            driverSetup();  // Initialize the WebDriver if not already initialized
        }
        return driver;
    }

    static public void closeDriver() {
        if (driver != null) {
            System.out.println("Closing WebDriver...");
            driver.quit();
            driver = null;  // Set driver to null after quitting to indicate it's no longer available
        }

}}

package Pages;

import DriverManger.DriverManger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.ElementHelper;
import utilities.Global;
import utilities.RandomSource;

public class SignupPage {
    WebDriver driver;
    private final By nameField = By.name("name");
    private final By email = By.xpath("(//input[@name='email'])[2]");
    private final By signupBtn = By.xpath("//button[text()='Signup']");
    private final By Title = By.id("id_gender1");
    private final By Password = By.id("password");
    private final By DaysDropdown = By.id("days");
    private final By MonthDropdown = By.id("months");
    private final By YearsDropdown = By.id("years");
    private final By newsletter = By.id("newsletter");
    private final By optin = By.id("optin");
    private final By First_name = By.id("first_name");
    private final By last_name = By.id("last_name");
    private final By Address = By.id("address1");
    private final By countryDropdown = By.id("country");
    private final By state = By.id("state");
    private final By city = By.id("city");
    private final By zipcode = By.id("zipcode");
    private final By mobile_number = By.id("mobile_number");
    private final By Create_Account = By.xpath("//button[text()='Create Account']");

    private final By accountCreatedMessage = By.xpath("//h2[@data-qa='account-created']");

    public SignupPage() {
        this.driver = DriverManger.getDriver();;
    }
    public SignupPage enterName(String name) {
        ElementHelper.sendKeys(driver, nameField, name);
        return this;
    }

    public SignupPage enterEmail(String email) {
        String Email = RandomSource.generateRandomEmail();
        ElementHelper.sendKeys(driver, this.email, Email);
        Global.setEmail(Email);
        return this;
    }

    public SignupPage enterPassword(String password) {
        String pass = RandomSource.generateRandomPassword(10);
        ElementHelper.sendKeys(driver, Password, pass);
        Global.setPassword(pass);
        return this;
    }

    public SignupPage enterFirstName(String firstName) {
        ElementHelper.sendKeys(driver, First_name, firstName);
        return this;
    }

    public SignupPage enterLastName(String lastName) {
        ElementHelper.sendKeys(driver, last_name, lastName);
        return this;
    }

    public SignupPage enterAddress(String address) {
        ElementHelper.sendKeys(driver, Address, address);
        return this;
    }

    public SignupPage enterState(String State) {
        ElementHelper.sendKeys(driver, state, State);
        return this;
    }

    public SignupPage enterZipCode(String Code) {
        ElementHelper.sendKeys(driver, zipcode, Code);
        return this;
    }

    public SignupPage enterCity(String City) {
        ElementHelper.sendKeys(driver, city, City);
        return this;
    }

    public SignupPage enterMobileNumber(String Phone) throws InterruptedException {
        ElementHelper.sendKeys(driver, mobile_number, Phone);
        return this;
    }

    public SignupPage clickOnSignUpBtn() {
        ElementHelper.click(driver, signupBtn);
        return this;
    }

    public SignupPage clickOnTitleBtn() {
        ElementHelper.click(driver, Title);
        return this;
    }

    public SignupPage ClickOnNewsletter() {
        ElementHelper.click(driver, newsletter);
        return this;
    }

    public SignupPage ClickOnSpecialOffer() {
        ElementHelper.click(driver, optin);
        return this;
    }

    public SignupPage selectCountry(String country) {
        ElementHelper.selectByVisibleText(driver, countryDropdown, country);
        return this;
    }

    public SignupPage SelectDateBirthDate(String day, String month, String year) {
        ElementHelper.selectByVisibleText(driver, DaysDropdown, day);
        ElementHelper.selectByVisibleText(driver, MonthDropdown, month);
        ElementHelper.selectByVisibleText(driver, YearsDropdown, year);
        return this;
    }

    public SignupPage clickCreate_Account() {
        ElementHelper.click(driver, Create_Account);
        return this;
    }
    public String getAccountCreatedMessage() {
        return driver.findElement(accountCreatedMessage).getText();
    }

    public String getCurrentPageUrl() {
        return driver.getCurrentUrl();
    }

}


//   public void registerUser(String name,String Email, String password ){
//        //click(signupLoginBtn);
//        ElementHelper.sendKeys(nameField,name);
//        ElementHelper.sendKeys(email,Email);
//        ElementHelper.click(signupBtn);
//        ElementHelper.click(Title);
//        ElementHelper.sendKeys(Password,password);
//        ElementHelper.selectByValue(DaysDropdown,"20");
//        ElementHelper.selectByVisibleText(MonthDropdown,"March");
//        ElementHelper.selectByIndex(YearsDropdown,3);
//        ElementHelper.click(newsletter);
//        ElementHelper.click(optin);
//        ElementHelper.sendKeys(First_name,"rofida");
//        ElementHelper.sendKeys(last_name,"Araby");
//        ElementHelper.sendKeys(Address,"Egypt");
//        ElementHelper.selectByIndex(countryDropdown,2);
//        ElementHelper.sendKeys(state,"A");
//        ElementHelper.sendKeys(city,"Egypt");
//        ElementHelper.sendKeys(zipcode,"555");
//        ElementHelper.sendKeys(mobile_number,"010");
//        ElementHelper.click(Create_Account);
//    }}

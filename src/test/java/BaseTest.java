

import org.testng.annotations.*;
import DriverManger.DriverManger;

public class BaseTest {

    @BeforeMethod
    public void initialization() {
        DriverManger.driverSetup();
    }

 /*   @AfterMethod
    public void closeBrowser() {
        DriverManger.closeDriver();
    }*/
}

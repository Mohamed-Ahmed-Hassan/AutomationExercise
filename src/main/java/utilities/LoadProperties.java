package utilities;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class LoadProperties {
    public static Properties environmentSetup = loadProperties("src\\test\\java\\properties\\environmentConfigration.properties");
    public static String Browser = environmentSetup.getProperty("Browser");
    public static String driverUrl = environmentSetup.getProperty("PageURL");
    public static Properties loadProperties(String path) {
        Properties pro = new Properties();
        try {
            FileInputStream stream = new FileInputStream(path);
            pro.load(stream);
            stream.close();
        } catch (IOException e) {
            System.out.println("Error Occurred: " + e.getMessage());
        }
        return pro;
    }
}

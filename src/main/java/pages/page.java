package pages;

import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class page {
    protected final WebDriver driver;

    InputStream input;
    Properties prop;

    public page(WebDriver driver) throws IOException {
        this.driver = driver;
        //prop file
        input = new FileInputStream("src\\main\\java\\properties\\config.properties");
        prop = new Properties();
        prop.load(input);
    }
}

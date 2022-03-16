package tests.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.*;
import pages.SauceLoginPage;
import io.qameta.allure.Step;


import java.io.IOException;

public class BaseTest {
    //Pages
    protected SauceLoginPage sauceLoginPage;
    //browser name
    protected String browserName;
    //data
    private WebDriver driver;

    @Step("Open Browser {0}")
    @BeforeClass
    @Parameters("browser")
    public void setup(String browser) throws Exception {
        browserName = browser.toLowerCase();

        //The Cross Browser tests setup
        //Check if parameter passed from TestNG is 'firefox'
        if (browserName.equalsIgnoreCase("firefox")) {
            //create firefox instance
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }
        //Check if parameter passed as 'chrome'
        else if (browserName.equalsIgnoreCase("chrome")) {
            //set path to chromedriver.exe
            WebDriverManager.chromedriver().setup();
            //create chrome instance
            driver = new ChromeDriver();
        }
        //Check if parameter passed as 'internet explorer'
        else if (browserName.equalsIgnoreCase("edge")) {
            //set path to internet_explorer.exe
            WebDriverManager.edgedriver().setup();
            //create internet explorer instance
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", "src\\main\\resources\\IEDriverServer.exe");
            driver = new InternetExplorerDriver();
        } else {
            //If no browser passed throw exception
            throw new Exception("Browser name is not correct or not supported now");
        }

        //Set The Driver Dimensions 1024x768px
        driver.manage().window().setSize(new Dimension(1024,768));
    }

    @Step("Go To Sauce Demo Login Page")
    @BeforeMethod
    public void beforeMethod() throws IOException {
        sauceLoginPage = new SauceLoginPage(driver);
    }

    @Step("Close Browser")
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}

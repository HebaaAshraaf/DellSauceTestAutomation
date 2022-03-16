package elements;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import readers.PropReader;

import java.util.List;
import java.util.Properties;

public class locators {

    public static WebElement getElementByName(String name, WebDriver driver, Properties prop) {
        return driver.findElement(By.name(PropReader.read(name, prop)));
    }

    public static WebElement getElementByID(String id, WebDriver driver, Properties prop) {
        return driver.findElement(By.id(PropReader.read(id, prop)));
    }

    public static WebElement getElementByXpath(String xpath, WebDriver driver, Properties prop) {
        return driver.findElement(By.xpath(PropReader.read(xpath, prop)));
    }

    public static List<WebElement> getElementsByXpath(String xpath, WebDriver driver, Properties prop) {
        return driver.findElements(By.xpath(PropReader.read(xpath, prop)));
    }
}

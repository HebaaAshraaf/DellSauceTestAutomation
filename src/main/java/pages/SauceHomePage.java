package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SauceHomePage extends page {

    //Buttons Locators from the prop file
    private final String homeTitle = "sauce.home.title.xpath";

    public SauceHomePage(WebDriver driver) throws IOException {
        super(driver);
    }

    @Step("Get The Home page title")
    public String getHomeTitle(){
        return elements.locators.getElementByXpath(homeTitle,driver,prop).getText();
    }
}

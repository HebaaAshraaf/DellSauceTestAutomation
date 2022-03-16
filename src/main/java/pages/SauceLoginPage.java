package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class SauceLoginPage extends page {

    //The path of url data in properties file
    private final String sauceURL = "sauce.login.url";

    //Buttons Locators from the prop file
    private final String userNameField = "sauce.login.username.id";
    private final String passwordField = "sauce.login.password.id";
    private final String loginBTN = "sauce.login.loginBTN.id";

    //Error Message locator
    private final String errorMSG = "sauce.login.errorMSG.xpath";
    private final String errorMSGCloseButton = "sauce.login.errorMSGCloseButton.xpath";

    public SauceLoginPage(WebDriver driver) throws IOException {
        super(driver);
        driver.get(readers.PropReader.read(sauceURL, prop));
    }

    @Step("Write User Name:")
    public void writeUserName(String data){
        elements.locators.getElementByID(userNameField,driver,prop).sendKeys(data);
    }
    @Step("Write Password:")
    public void writePassword(String data){
        elements.locators.getElementByID(passwordField,driver,prop).sendKeys(data);
    }

    @Step("Click Login")
    public void clickOnLoginButton(){
        elements.locators.getElementByID(loginBTN,driver,prop).click();
    }

    @Step("Get The Error Text")
    public String getTheErrorMessageText(){
        return elements.locators.getElementByXpath(errorMSG,driver,prop).getText();
    }

    @Step("Close The Error Message")
    public void closeTheErrorMSG(){
        elements.locators.getElementByXpath(errorMSGCloseButton,driver,prop).click();
    }
}

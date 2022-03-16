package tests.login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import readers.JSONReader;
import tests.base.BaseTest;
import utils.reports.AllureListener;

@Listeners({AllureListener.class})
@Epic("Automation Tests")
@Feature("Authentication Tests")
public class LoginWithWrongCredentialsTest extends BaseTest {

    @DataProvider
    public Object[][] jsonWrongData() {
        return JSONReader.JsonReader("wrong");
    }

    @Test(dataProvider = "jsonWrongData", description = "Check that the error message appears after login")
    public void checkTheErrorMessageAppears(String username, String password) {
        try {
            sauceLoginPage.writeUserName(username);
            sauceLoginPage.writePassword(password);
            sauceLoginPage.clickOnLoginButton();
            String msg = sauceLoginPage.getTheErrorMessageText();
            if(username == "locked_out_user"){
                Assert.assertEquals(msg,"Epic sadface: Sorry, this user has been locked out.");
            }
            else if(username == "user"){
                Assert.assertEquals(msg,"Epic sadface: Username and password do " +
                        "not match any user in this service");
            }
        } catch (InvalidSelectorException e) {
            exceptions.ExceptionsMessages.InvalidSelectorMsg(e);
        } catch (NoSuchElementException e) {
            exceptions.ExceptionsMessages.NoSuchElementMsg(e);
        } catch (ElementNotVisibleException e) {
            exceptions.ExceptionsMessages.ElementNotVisibleMsg(e);
        } catch (NoSuchSessionException e) {
            exceptions.ExceptionsMessages.NoSuchSessionMsg(e);
        } catch (NullPointerException e) {
            exceptions.ExceptionsMessages.NullPointerMsg(e);
        }
    }

    @Test(dataProvider = "jsonWrongData", description = "Check that the error message appears after Close it and Login again")
    public void checkTheErrorMessageAppearsAgainAfterCloseItAndLoginAgain(String username, String password) {
        try {
            sauceLoginPage.writeUserName(username);
            sauceLoginPage.writePassword(password);
            sauceLoginPage.clickOnLoginButton();
            sauceLoginPage.closeTheErrorMSG();
            sauceLoginPage.clickOnLoginButton();
            if(username == "locked_out_user"){
                Assert.assertEquals(sauceLoginPage.getTheErrorMessageText(),"Epic sadface: Sorry, this user has been locked out.");
            }
            else if(username == "user"){
                Assert.assertEquals(sauceLoginPage.getTheErrorMessageText(),"Epic sadface: Username and password do " +
                        "not match any user in this service");
            }
        } catch (InvalidSelectorException e) {
            exceptions.ExceptionsMessages.InvalidSelectorMsg(e);
        } catch (NoSuchElementException e) {
            exceptions.ExceptionsMessages.NoSuchElementMsg(e);
        } catch (ElementNotVisibleException e) {
            exceptions.ExceptionsMessages.ElementNotVisibleMsg(e);
        } catch (NoSuchSessionException e) {
            exceptions.ExceptionsMessages.NoSuchSessionMsg(e);
        } catch (NullPointerException e) {
            exceptions.ExceptionsMessages.NullPointerMsg(e);
        }
    }
}

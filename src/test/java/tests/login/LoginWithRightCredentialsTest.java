package tests.login;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.NoSuchSessionException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.SauceHomePage;
import readers.JSONReader;
import tests.base.BaseTest;
import utils.reports.AllureListener;

import java.io.IOException;

@Listeners({AllureListener.class})
@Epic("Automation Tests")
@Feature("Authentication Tests")
public class LoginWithRightCredentialsTest extends BaseTest {

    private SauceHomePage sauceHomePage;
    @DataProvider
    public Object[][] jsonRightData() {
        return JSONReader.JsonReader("right");
    }

    @Test(dataProvider = "jsonRightData", description = "Check that the Home page appears after login with right user")
    public void checkTheHomeTitleAppears(String username, String password) {
        try {
            sauceLoginPage.writeUserName(username);
            sauceLoginPage.writePassword(password);
            sauceLoginPage.clickOnLoginButton();
            sauceHomePage = new SauceHomePage(getDriver());
            String title = sauceHomePage.getHomeTitle();
            Assert.assertEquals(title,"PRODUCTS");
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
        } catch (IOException e) {
            exceptions.ExceptionsMessages.IOMsg(e);
        }
    }
}

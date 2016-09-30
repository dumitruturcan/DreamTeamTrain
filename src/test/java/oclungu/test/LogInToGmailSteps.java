package oclungu.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oclungu.gmail.helpers.ActionHelper;
import oclungu.gmail.page.objects.InboxPage;
import oclungu.gmail.page.objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;

public class LogInToGmailSteps {

    private ActionHelper actionHelper;
    private WebDriver webDriver;
    private LoginPage loginPage;
    private InboxPage inboxPage;

    @Before
    public void setUp() {

        File file = new File("./IEDriverServer.exe");
        System.setProperty("webdriver.ie.driver", file.getAbsolutePath());
        webDriver = new InternetExplorerDriver();

        actionHelper = new ActionHelper();

        loginPage = new LoginPage(webDriver);
        inboxPage = new InboxPage(webDriver);


    }

    @Given("^User is on Login page$")
    public void User_is_on_Login_page() throws Throwable {

        webDriver.get("gmail.com");

    }

    @When("^User provide user name as \"([^\"]*)\"$")
    public void User_provide_user_name_as(String arg1) throws Throwable {

        actionHelper.sendKeysToTheElement(loginPage.getLoginField(), arg1);

    }

    @When("^User click next button$")
    public void User_click_next_button() throws Throwable {

        actionHelper.clickTheElement(loginPage.getNextButton());

    }

    @When("^User provide password name as \"([^\"]*)\"$")
    public void User_provide_password_name_as(String arg1) throws Throwable {

        loginPage.getPasswordField().sendKeys(arg1);

        if (loginPage.getRememberCheckbox().isSelected()) {

            loginPage.getRememberCheckbox().click();

        }

    }

    @When("^User click sign in button$")
    public void User_click_sign_in_button() throws Throwable {

        loginPage.getSignInButton().click();

    }

    @Then("^User should be logged in$")
    public void User_should_be_logged_in() throws Throwable {

        inboxPage.getComposeButton().isDisplayed();

    }

    @After
    public void shutDown() {

        webDriver.quit();

    }

}

package oclungu.test;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oclungu.gmail.page.objects.InboxPage;
import oclungu.gmail.page.objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LogInToGmailSteps {

    private WebDriver webDriver;

    private LoginPage loginPage;
    private InboxPage inboxPage;

    @Before
    public void setUp() {

        webDriver = new InternetExplorerDriver();

        loginPage = new LoginPage(webDriver);
        inboxPage = new InboxPage(webDriver);


    }

    @Given("^User access gmail.$")
    public void User_access_gmail() throws Throwable {

        webDriver.get("gmail.com");

    }

    @When("^User provide user name as \"([^\"]*)\".$")
    public void User_provide_user_name_as_(String arg1) throws Throwable {

        loginPage.getLoginField().sendKeys(arg1);

    }

    @When("^User click next button.$")
    public void User_click_next_button() throws Throwable {

        loginPage.getNextButton().click();

    }

    @When("^User provide password name as \"([^\"]*)\".$")
    public void User_provide_password_name_as_(String arg1) throws Throwable {

        loginPage.getPasswordField().sendKeys(arg1);

        if (loginPage.getRememberCheckbox().isEnabled()) {

            loginPage.getRememberCheckbox().click();

        }

    }

    @When("^User click sign in button.$")
    public void User_click_sign_in_button() throws Throwable {

        loginPage.getSignInButton().click();

    }

    @Then("^User should be logged in.$")
    public void User_should_be_logged_in() throws Throwable {

        inboxPage.getComposeButton().isDisplayed();

    }

    @After
    public void shutDown() {

        webDriver.quit();

    }

}

package oclungu.test;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import oclungu.gmail.page.objects.InboxPage;
import oclungu.gmail.page.objects.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LogInToGmailSteps {

    private WebDriver webDriver = new InternetExplorerDriver();
    private LoginPage loginPage = new LoginPage(webDriver);
    private InboxPage inboxPage = new InboxPage(webDriver);

    @Given("^User access gmail.$")
    public void User_access_gmail() throws Throwable {

        webDriver.get("gmail.com");

    }

    @When("^User provide user name  as <username> and password <password>.$")
    public void User_provide_user_name_username_and_password_password_(DataTable arg1, DataTable arg2) throws Throwable {

        loginPage.getLoginField().sendKeys(arg1.toString());
        loginPage.getNextButton().click();
        loginPage.getPasswordField().sendKeys(arg2.toString());

        if (loginPage.getRememberCheckbox().isSelected()) {

            loginPage.getRememberCheckbox().click();

        }

        loginPage.getLoginField().click();

    }

    @Then("^User should be logged in.$")
    public void User_should_be_logged_in() throws Throwable {

        if (inboxPage.getComposeButton().isDisplayed()) {

            System.out.println("User logged.");

        } else {

            System.out.println("FAILED.");

        }

    }

}

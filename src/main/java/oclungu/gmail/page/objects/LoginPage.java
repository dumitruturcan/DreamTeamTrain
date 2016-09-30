package oclungu.gmail.page.objects;

import oclungu.gmail.helpers.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private Logger logger = Logger.getLogger(LoginPage.class);
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WaitHelper waitHelper;

    private By loginField = By.id("Email");
    private By nextButton = By.id("next");
    private By passwordField = By.id("Passwd");
    private By signInButton = By.id("signIn");
    private By rememberCheckbox = By.id("PersistentCookie");

    public LoginPage() {
    }

    public LoginPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.waitHelper = new WaitHelper(webDriver);

    }

    public WebElement getLoginField() {

        logger.info("Looking for Log In Field.");
        waitHelper.waitForElement(loginField);
        logger.info("Log In Field was found.");
        return webDriver.findElement(loginField);

    }

    public WebElement getNextButton() {

        logger.info("Looking for Next Button.");
        waitHelper.waitForElement(nextButton);
        logger.info("Next Button was found.");
        return webDriver.findElement(nextButton);

    }

    public WebElement getPasswordField() {

        logger.info("Looking for Password Field.");
        waitHelper.waitForElement(passwordField);
        logger.info("Password Field was found.");
        return webDriver.findElement(passwordField);

    }

    public WebElement getSignInButton() {

        logger.info("Looking for Sign In Button.");
        waitHelper.waitForElement(signInButton);
        logger.info("Sign In Button was found.");
        return webDriver.findElement(signInButton);

    }

    public WebElement getRememberCheckbox() {

        logger.info("Looking for Remember Checkbox.");
        waitHelper.waitForElement(rememberCheckbox);
        logger.info("Remember Checkbox was found.");
        return webDriver.findElement(rememberCheckbox);

    }

}

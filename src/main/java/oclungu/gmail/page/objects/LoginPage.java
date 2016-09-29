package oclungu.gmail.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

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

    }

    public WebElement getLoginField() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(loginField));
        return webDriver.findElement(loginField);

    }

    public WebElement getNextButton() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(nextButton));
        return webDriver.findElement(nextButton);

    }

    public WebElement getPasswordField() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        return webDriver.findElement(passwordField);

    }

    public WebElement getSignInButton() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(signInButton));
        return webDriver.findElement(signInButton);

    }

    public WebElement getRememberCheckbox() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(rememberCheckbox));
        return webDriver.findElement(rememberCheckbox);

    }

}

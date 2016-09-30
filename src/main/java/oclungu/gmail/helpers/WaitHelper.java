package oclungu.gmail.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitHelper {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    public WaitHelper() {
    }

    public WaitHelper(WebDriver webDriver) {

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);

    }

    public void waitForElement(By by) {

        webDriverWait.withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.elementToBeClickable(by));

    }

}

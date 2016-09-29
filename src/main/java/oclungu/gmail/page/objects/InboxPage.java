package oclungu.gmail.page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class InboxPage {

    private WebDriver webDriver;
    private WebDriverWait webDriverWait;

    private By composeButton = By.xpath("//a[@tabindex='0']");

    public InboxPage() {
    }

    public InboxPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);

    }

    public WebElement getComposeButton() {

        webDriverWait.pollingEvery(10, TimeUnit.SECONDS)
                .until(ExpectedConditions.elementToBeClickable(composeButton));
        return webDriver.findElement(composeButton);

    }

}

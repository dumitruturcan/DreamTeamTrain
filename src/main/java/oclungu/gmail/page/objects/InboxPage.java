package oclungu.gmail.page.objects;

import oclungu.gmail.helpers.WaitHelper;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InboxPage {

    private Logger logger = Logger.getLogger(InboxPage.class);
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private WaitHelper waitHelper;

    private By composeButton = By.xpath("//a[@tabindex='0']");

    public InboxPage() {
    }

    public InboxPage(WebDriver webDriver) {

        this.webDriver = webDriver;
        this.webDriverWait = new WebDriverWait(webDriver, 10);
        this.waitHelper = new WaitHelper(webDriver);

    }

    public WebElement getComposeButton() {

        logger.info("Looking for Compose Button.");
        waitHelper.waitForElement(composeButton);
        logger.info("Compose Button was found.");
        return webDriver.findElement(composeButton);

    }

}

package oclungu.gmail.helpers;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;

public class ActionHelper {

    private Logger logger = Logger.getLogger(ActionHelper.class);

    public ActionHelper() {
    }

    public void clickTheElement(WebElement webElement) {

        logger.info("Click the element.");
        webElement.click();
        logger.info("Element was clicked.");

    }

    public void sendKeysToTheElement(WebElement webElement, String s) {

        logger.info("Fill the element.");
        webElement.sendKeys(s);
        logger.info("Element was filled.");


    }

}

package dturcan.gmail.helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ActionHelper {

    WebDriver driver;
    WebDriverWait wait;

    public ActionHelper(WebDriver driver){

        this.driver = driver;

    }


    public void click(By by) {
       // WebElement element = driver.
        //wait.pollingEvery(5, TimeUnit.SECONDS).
    }

    public void sendKeys(String string, By by) {



    }
}

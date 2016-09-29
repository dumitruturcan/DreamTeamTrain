package dturcan.gmail.pageobjects;

import dturcan.gmail.helpers.ActionHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    final By USER_NAME_INPUT_FIELD = By.id("Email");
    final By NEXT_BUTTON = By.id("next");
    final By PASSWORD_INPUT_FIELD = By.id("Passwd");
    final By SIGNIN_BUTTON = By.id("signIn");


    ActionHelper action;
    WebDriver driver;


    public LoginPage(WebDriver driver){

        action = new ActionHelper(driver);
        this.driver=driver;

    }


    public void logIn(String userName, String password){

        sendKeys("dima", USER_NAME_INPUT_FIELD);

        click(NEXT_BUTTON);

        sendKeys("pass",PASSWORD_INPUT_FIELD);

        click(SIGNIN_BUTTON);

    }

    public void click(By by){

        action.click(by);

    }

    public void sendKeys(String string, By by){


        action.sendKeys(string,by);

    }
}

package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BasePage {

    private By usernameElement=By.id("");
    private By passwordElement=By.xpath("");
    private By loginButton=By.name("");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    /**
     *
     * @param userName
     * @param password
     */
    public void login(String userName,String password)
    {
        sendKeysToElement(usernameElement,userName);
        sendKeysToElement(passwordElement,password);
        clickElement(loginButton);

    }

}

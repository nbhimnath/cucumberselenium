package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;


    //Constructor
    public BasePage (WebDriver driver, WebDriverWait wait){
        this.driver = driver;
        this.wait = wait;
    }

    /**
     * Click on a element
     * @param webElement
     */
    public void clickElement(By webElement) {
        driver.findElement(webElement).click();
    }

    /**
     * Send Keys to an element
     * @param webElement
     * @param text
     */
    public void sendKeysToElement(By webElement, String text) {
        driver.findElement(webElement).sendKeys(text);
    }

    /**
     * Get text from a webElement
     * @param webElement
     * @return
     */
    public String getTextFromElement(By webElement) {
        return driver.findElement(webElement).getText();
    }

    /**
     *
     * @return page title
     */
    public String getPageTitle()
    {
        return driver.getTitle();
    }
}

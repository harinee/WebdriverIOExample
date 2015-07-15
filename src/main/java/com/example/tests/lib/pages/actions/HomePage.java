package com.example.tests.lib.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.DriverFactory;

/**
 * Created by harineem on 14-07-2015.
 */
public class HomePage {

    WebDriver driver;

    public HomePage() {
        this.driver = DriverFactory.getDriver();
    }

    @FindBy(id = "go")
    public WebElement searchButton;

    @FindBy(id = "q")
    public WebElement searchBox;

    @FindBy(linkText = "About Us")
    public WebElement aboutUsLink;


    public AboutUsPage openAboutUsPage() {
        aboutUsLink.click();
        return PageFactory.initElements(driver, AboutUsPage.class);
    }

    public AboutUsPage search(String searchString) {
        searchBox.sendKeys(searchString);
        searchButton.click();
        return PageFactory.initElements(driver, AboutUsPage.class);
    }
}

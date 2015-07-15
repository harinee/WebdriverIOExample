package com.example.tests.lib.pages.actions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.DriverFactory;

/**
 * Created by harineem on 14-07-2015.
 */
public class AboutUsPage {

    WebDriver driver;

    public AboutUsPage() {
        this.driver = DriverFactory.getDriver();
    }

    @FindBy(css = ".col.nopad .heading")
    public WebElement title;

    public boolean isTitleOfPage(String titleName) {
        String actualTitle = title.getText().toUpperCase();
        return actualTitle.equals(titleName);
    }
}

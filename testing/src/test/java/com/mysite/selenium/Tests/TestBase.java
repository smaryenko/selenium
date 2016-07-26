package com.mysite.selenium.Tests;

import com.mysite.selenium.HomePageBing;
import com.mysite.selenium.HomePageGoogle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {

    public static WebDriver driver;
    public static WebDriverWait driverWait;
    public static By SEARCH_FIELD_BASE;
    public static By SEARCH_BUTTON_BASE;

    public static void initializeGooglePage(){
        SEARCH_FIELD_BASE = HomePageGoogle.FIELD_SEARCH;
        SEARCH_BUTTON_BASE = HomePageGoogle.BUTTON_SEARCH_CHROME;
    }

    public static void initializeBingPage(){
        SEARCH_FIELD_BASE = HomePageBing.FIELD_SEARCH;
        SEARCH_BUTTON_BASE = HomePageBing.BUTTON_SEARCH_CHROME;
    }
}

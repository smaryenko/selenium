package com.mysite.conductor;

import org.openqa.selenium.By;

public interface HomePageGoogle {

    String URL_HOMEPAGE = "http://Google.com";

    // search field
    By FIELD_SEARCH = By.id("lst-ib");
    By BUTTON_SEARCH_CHROME = By.cssSelector("#sblsbb > button");
    By BUTTON_SEARCH_IE =  By.name("btnK");
    By BUTTON_SIGNIN =  By.cssSelector("#gb_70");

}
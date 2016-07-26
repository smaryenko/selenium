package com.mysite.conductor;

import org.openqa.selenium.By;

public interface HomePageBing {

    String URL_HOMEPAGE = "http://bing.com";

    // search field
    By FIELD_SEARCH = By.id("sb_form_q");
    By BUTTON_SEARCH_CHROME = By.id("sb_form_go");
    By BUTTON_SEARCH_IE =  BUTTON_SEARCH_CHROME;
    //By BUTTON_SIGNIN =  By.cssSelector("#gb_70");

}
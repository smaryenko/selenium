package com.mysite.conductor;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;
import org.openqa.selenium.By;

@Config(
        browser = Browser.INTERNET_EXPLORER,
        url     = SearchTests.URL_HOMEPAGE
)
public class IE extends SearchTests {
    @Override
    protected By getButtonSearch() {
        return BUTTON_SEARCH_IE;
    }
}
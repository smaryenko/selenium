package com.mysite.conductor;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;

@Config(
        browser = Browser.FIREFOX,
        url     = SearchTests.URL_HOMEPAGE
)
public class Firefox extends SearchTests {

}
package com.mysite.conductor;

import io.ddavison.conductor.Browser;
import io.ddavison.conductor.Config;


@Config(
        browser = Browser.CHROME,
        url     = SearchTests.URL_HOMEPAGE
)
public class Chrome extends SearchTests {

}


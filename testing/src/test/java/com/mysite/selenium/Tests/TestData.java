package com.mysite.selenium.Tests;

import static junitparams.JUnitParamsRunner.$;

public class TestData {
    public static Object[] parametersForTestSearch() {
        return $( $("Wikipedia", "Wikipedia"),
                $("Youtube", "YouTube") ); }

}
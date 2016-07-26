package com.mysite.conductor;

import static junitparams.JUnitParamsRunner.$;

public class TestData {
    public static Object[] parametersForTestSearch() {
        return $( $("Wikipedia", "Wikipedia"),
                  $("Youtube", "YouTube") ); }

}

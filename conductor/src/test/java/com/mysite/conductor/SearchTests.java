package com.mysite.conductor;

import io.ddavison.conductor.Locomotive;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.*;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(JUnitParamsRunner.class)
public abstract class SearchTests extends Locomotive implements HomePageBing {

    //region Variables initialization
    private WebDriverWait driverWait = new WebDriverWait(driver, 5);
    //endregion

    //region com.selenium.Tests Initialization
    @Before
    public void testInitialize() {
        //clickAndWait(By.partialLinkText("Google.com"), BUTTON_SIGNIN);
    }

    @After
    public void testCleanup() {
       driver.close();
    }
    //endregion

    //region com.selenium.Tests
    @Test
    @Parameters(source = TestData.class, method = "parametersForTestSearch")
    public void testSearch(String searchInput, String searchExpected) throws InterruptedException {

        setText(FIELD_SEARCH, searchInput);

        clickAndWait(getButtonSearch(), By.partialLinkText(searchExpected));
    }
    //endregion

    //region Helpers
    protected By getButtonSearch() {
        return BUTTON_SEARCH_CHROME;
    }

    private Locomotive clickAndWait(By locatorForClick, By locatorForWait) throws InterruptedException {
        click(locatorForClick);

        Thread.sleep(2000);

        driverWait.until(ExpectedConditions.presenceOfElementLocated(locatorForWait));
        return this;
    }
    //endregion
}

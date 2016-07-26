package com.mysite.selenium.Tests;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

@RunWith(JUnitParamsRunner.class)
public class TestSearch extends TestBase{

    @Test
    @Parameters(source = TestData.class, method = "parametersForTestSearch")
    public void shouldSearch(String searchInput, String searchExpected) {
        setText(SEARCH_FIELD_BASE, searchInput);

        clickAndWait(SEARCH_BUTTON_BASE, By.partialLinkText(searchExpected));
    }

    private void clickAndWait(By locatorForClick, By locatorForWait) {
        driver.findElement(locatorForClick).click();

        driverWait.until(ExpectedConditions.presenceOfElementLocated(locatorForWait));
    }

    private void setText(By locatorForText, String text) {
        WebElement element = driver.findElement(locatorForText);
        element.clear();
        element.sendKeys(new CharSequence[]{text});
    }

}

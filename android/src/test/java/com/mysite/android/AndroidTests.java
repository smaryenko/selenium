package com.mysite.android;

import io.selendroid.client.SelendroidDriver;
import io.selendroid.common.SelendroidCapabilities;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import java.net.URL;

public class AndroidTests implements GeneralContants, MainScreen{

    static SelendroidDriver driver;

    @BeforeClass
    public static void classInitialize() throws Exception {
        SelendroidCapabilities capa = new SelendroidCapabilities(testAppCapability);
        driver = new SelendroidDriver(new URL(URL), capa);
    }

    @AfterClass
    public static void classCleanup(){
        if (driver != null){
            driver.quit();
        }
    }

    @Test
    public void testTextField() {
        WebElement inputField = driver.findElement(textField);
        Assert.assertTrue(inputField.isEnabled());
        inputField.sendKeys("MyTest");
        Assert.assertEquals("MyTest", inputField.getText());
    }

    @Test
    public void testCheckbox() {
        WebElement checkboxField = driver.findElement(checkboxFiled);
        Assert.assertTrue(checkboxField.isSelected());
        checkboxField.click();
        Assert.assertFalse(checkboxField.isSelected());
    }
}

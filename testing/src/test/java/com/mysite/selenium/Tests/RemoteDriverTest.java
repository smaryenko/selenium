package com.mysite.selenium.Tests;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by smaryenko on 21-Jul-16.
 */
public class RemoteDriverTest {
    public static void main(String[] args) throws MalformedURLException {

        File file = new File("C:\\selenium\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());

        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setCapability(ChromeOptions.CAPABILITY, options);

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"),  capability);
        driver.get("http://google.com");
        driver.close();
    }
}

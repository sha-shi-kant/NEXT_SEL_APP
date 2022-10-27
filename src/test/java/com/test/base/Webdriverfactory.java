package com.test.base;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;

public class Webdriverfactory {
    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver setupDriver(String browserName) throws Exception {

        if (browserName == null) {
            throw new Exception("Browser name is null");
        }

        switch (browserName) {

            case BrowserType.FIREFOX:
                Capabilities firefoxCapabilities = DesiredCapabilities.firefox();
                driver.set( new RemoteWebDriver(new URL("http://selenium-hub:4444"), firefoxCapabilities));
                break;
            case BrowserType.CHROME:
                Capabilities chromeCapabilities = DesiredCapabilities.chrome();
                driver.set( new RemoteWebDriver(new URL("http://selenium-hub:4444"), chromeCapabilities));
                break;

            case BrowserType.EDGE:
                Capabilities EdgeCapabilities = new DesiredCapabilities(BrowserType.EDGE, "", Platform.LINUX);
                driver.set( new RemoteWebDriver(new URL("http://selenium-hub:4444"), EdgeCapabilities));
                break;

            default:
                throw new Exception("Browser name is not correct");
        }

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }

}

package me.matveev.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WikiPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        WebDriver driver = new FirefoxDriver(capabilities);

        driver.navigate().to("https://www.google.com");

        driver.quit();
    }
}

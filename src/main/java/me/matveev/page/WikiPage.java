package me.matveev.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WikiPage {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "geckodriver");

        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        WebDriver driver = new FirefoxDriver(capabilities);
        driver.manage()
                .window()
                .maximize();

        try {
            driver.navigate().to("https://www.google.com");

            WebElement searchInputElement = driver.findElement(By.cssSelector("input[name='q']"));
            searchInputElement.sendKeys("hello selenium");

            WebElement searchButton = driver.findElements(By.name("btnK")).get(1);
            searchButton.click();

        } catch (WebDriverException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}

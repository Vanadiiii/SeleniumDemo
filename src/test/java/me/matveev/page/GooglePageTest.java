package me.matveev.page;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertNotEquals;

public class GooglePageTest {
    private final String url = "https://www.google.com";
    private WebDriver driver;

    @BeforeClass
    public static void initProperties() {
        System.setProperty("webdriver.gecko.driver", "geckodriver");
    }

    @Before
    public void initWebDriver() {
        DesiredCapabilities capabilities = DesiredCapabilities.firefox();
        capabilities.setCapability("marionette", true);

        driver = new FirefoxDriver(capabilities);
        driver.manage()
                .window()
                .maximize();
        driver.manage()
                .timeouts()
                .implicitlyWait(3, TimeUnit.SECONDS);

        driver.navigate().to(url);
    }

    @Test
    public void test() {
        try {
            WebElement searchInputElement = driver.findElement(By.cssSelector("input[name='q']"));
            searchInputElement.sendKeys("hello selenium");

            WebElement searchButton = driver.findElements(By.name("btnK")).get(1);
            searchButton.click();

            String currentUrl = driver.getCurrentUrl();

            assertNotEquals(url, currentUrl);

        } catch (WebDriverException e) {
            e.printStackTrace();
        }
    }

    @After
    public void closeDriver() {
        driver.quit();
    }
}
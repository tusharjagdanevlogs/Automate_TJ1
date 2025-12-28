package testcase;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestDemo {

    @Test
    public void demoTest() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.google.com");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.name("q")));
            search.sendKeys("Selenium WebDriver");
            search.sendKeys(Keys.ENTER);
            wait.until(ExpectedConditions.titleContains("Selenium WebDriver"));
        } finally {
            driver.quit();
        }
    }
}
package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {

    @Test
    public void loginTest() {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage page = new LoginPage(driver);
        page.enterUsername("student");
        page.enterPassword("Password123");

        // Submit handled here
        driver.findElement(By.id("submit")).click();

        // Assertion here
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(actualText, "Logged In Successfully");

        driver.quit();
    }
}


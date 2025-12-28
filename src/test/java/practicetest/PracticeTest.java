package practicetest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.TestListener.class) // optional, keep if you already have it
public class PracticeTest {

    WebDriver driver;

    @Test
    public void loginTest() {

        // 1️⃣ Setup Chrome driver
        WebDriverManager.chromedriver().setup();

        // 2️⃣ Headless Chrome configuration (CI + local safe)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");       // REQUIRED for GitHub Actions
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // 3️⃣ Open test site
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // 4️⃣ Enter username
        driver.findElement(By.id("username"))
                .sendKeys("student");

        // 5️⃣ Enter password
        driver.findElement(By.id("password"))
                .sendKeys("Password123");

        // 6️⃣ Click login
        driver.findElement(By.id("submit")).click();

        // 7️⃣ Assertion – verify successful login
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                actualUrl.contains("logged-in-successfully"),
                "Login failed – success page not loaded"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

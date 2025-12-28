package practicetest;
//Creating WF with this code commit push and creating WF new
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class PracticeTest {

    WebDriver driver;

    @Test
    public void loginTest() {

        // Setup ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Headless Chrome configuration (MANDATORY for GitHub Actions)
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--window-size=1920,1080");

        driver = new ChromeDriver(options);

        // Open website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username
        driver.findElement(By.id("username")).sendKeys("student");

        // Enter password
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click login
        driver.findElement(By.id("submit")).click();

        // Assertion – verify successful login
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(
                currentUrl.contains("logged-in-successfully"),
                "Login failed: Success page not loaded"
        );
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}

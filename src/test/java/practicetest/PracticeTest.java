package practicetest;
//hi

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(utils.TestListener.class)
public class PracticeTest {

    @Test
    public void loginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // Open website
        driver.get("https://practicetestautomation.com/practice-test-login/");

        // Enter username & password
        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        // Click submit
        driver.findElement(By.id("submit")).click();

        // Validate success message
        String actualText = driver.findElement(By.tagName("h1")).getText();
        Thread.sleep(4000);

        Assert.assertEquals(
                actualText,
                "Logged In Successfully",
                "Login not successful"
        );

        driver.quit();
    }
}

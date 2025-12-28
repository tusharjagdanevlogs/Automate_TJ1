package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AmazonLoginPage;
import utils.ScreenshotUtil;

@Listeners(utils.TestListener.class)
public class AmazonLoginTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void amazonLoginInvalidTest() {
        try {
            driver.get("https://www.amazon.in/");
            System.out.println("🔹 Page opened");

            AmazonLoginPage login = new AmazonLoginPage(driver);

            login.enterEmail("wrong@mail.com");
            login.clickContinue();
            login.enterPassword("wrongPass123");
            login.clickSignIn();

            Assert.assertTrue(login.isErrorVisible(),
                    "Error message should be visible for invalid login");
            System.out.println("✔ Test Passed - Error message visible");

        } catch (Exception e) {
            System.out.println("❗ Failure detected: " + e.getMessage());
            ScreenshotUtil.takeScreenshot(driver, "Amazon_Failure");
            Assert.fail("Test failed - Screenshot captured.");
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}

package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.AmazonSearchPage;
import org.testng.Reporter;

public class AmazonSearchTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // for Extent Listener
        Reporter.getCurrentTestResult().getTestContext().setAttribute("driver", driver);
    }

    @Test
    public void searchProductTest() {
        driver.get("https://www.amazon.in");

        AmazonSearchPage amazon = new AmazonSearchPage(driver);
        amazon.searchProduct("Laptop");

        boolean results = amazon.isResultDisplayed();
        Assert.assertTrue(results, "Search results not visible");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}


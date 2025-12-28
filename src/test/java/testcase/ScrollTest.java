package testcase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

public class ScrollTest {

    WebDriver driver;
    JavascriptExecutor js;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.in"); // You can change URL anytime
        js = (JavascriptExecutor) driver; // convert driver to JS executor
    }

    @Test
    public void scrollDemo() throws InterruptedException {

        // 1️⃣ Scroll by pixels (downwards)
        js.executeScript("window.scrollBy(0,500);");
        Thread.sleep(2000);

        // 2️⃣ Scroll back up by pixels
        js.executeScript("window.scrollBy(0,-300);");
        Thread.sleep(2000);

        // 3️⃣ Scroll to bottom of page
        js.executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);

        // 4️⃣ Scroll to a specific element (e.g. "Customer Service" footer link)
        WebElement element = driver.findElement(By.xpath("//a[text()='Customer Service']"));
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        Thread.sleep(2000);

// SAFE CLICK using JS
        js.executeScript("arguments[0].click();", element);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

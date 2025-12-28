package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void searchProductTest() throws InterruptedException {
        driver.get("https://www.amazon.in");

        Thread.sleep(2000); // wait for page to load
        driver.navigate().refresh(); // Amazon trick

        Thread.sleep(2000); // wait again after refresh

        WebElement searchBox = driver.findElement(By.cssSelector("input#twotabsearchtextbox"));
        searchBox.sendKeys("iPhone 15");
        searchBox.sendKeys(Keys.ENTER);

        Thread.sleep(3000);
    }


    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}

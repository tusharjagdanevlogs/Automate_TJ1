package testcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TableHandlingTest {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/tables");
    }

    @Test
    public void getEmailForJason() {

        String email = driver.findElement(
                By.xpath("//table[@id='table1']//tr[td[text()='Jason']]/td[3]")
        ).getText();

        System.out.println("Jason's Email: " + email);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

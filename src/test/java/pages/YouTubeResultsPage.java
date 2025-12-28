package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class YouTubeResultsPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private By searchResults = By.xpath("//div[@id='contents']//ytd-video-renderer");

    public YouTubeResultsPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public boolean areResultsDisplayed() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(searchResults)).isDisplayed();
    }
}

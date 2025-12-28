package testcase;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.YouTubeHomePage;
import pages.YouTubeResultsPage;

@Listeners(utils.TestListener.class)
public class YouTubeTest extends BaseTest {

    @Test
    public void testYouTubeSearchAIAutomation() {
        driver.get("https://www.youtube.com");
        
        YouTubeHomePage homePage = new YouTubeHomePage(driver);
        YouTubeResultsPage resultsPage = new YouTubeResultsPage(driver);
        
        homePage.searchFor("AI Automation");
        Assert.assertTrue(resultsPage.areResultsDisplayed(), "Search results should be displayed");
    }
}

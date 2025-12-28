package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class AmazonLoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public AmazonLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // UI selectors - covering both possible locators
    private By emailField1 = By.id("ap_email");
    private By emailField2 = By.id("ap_email_login");    // new UI

    private By continueBtn1 = By.id("continue");
    private By continueBtn2 = By.xpath("//*[@id='continue']/span/input");

    private By passwordField = By.id("ap_password");
    private By signInBtn = By.id("signInSubmit");
    private By errorBox = By.cssSelector("#auth-error-message-box, .a-alert-content");

    // METHODS

    public void enterEmail(String email) {
        WebElement emailBox = wait.until(ExpectedConditions.visibilityOfElementLocated(
                (driver.findElements(emailField1).size() > 0) ? emailField1 : emailField2
        ));
        emailBox.sendKeys(email);
    }

    public void clickContinue() {
        WebElement cont =
                (driver.findElements(continueBtn1).size() > 0) ?
                        wait.until(ExpectedConditions.elementToBeClickable(continueBtn1)) :
                        wait.until(ExpectedConditions.elementToBeClickable(continueBtn2));
        cont.click();
    }

    public void enterPassword(String pass) {
        WebElement pwd = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        pwd.sendKeys(pass);
    }

    public void clickSignIn() {
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn)).click();
    }

    public boolean isErrorVisible() {
        return driver.findElements(errorBox).size() > 0;
    }
}

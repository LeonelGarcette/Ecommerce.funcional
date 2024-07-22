package Pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class login_Page {
    public WebDriver driver;
    public WebDriverWait wait;

    public By userNameLocator = By.id("user-name");
    public By passwordLocator = By.id("password");
    public By loginButtonLocator = By.id("login-button");

    public login_Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void userNameMethod(String standard_use) {
        WebElement nameInput = driver.findElement(userNameLocator);
        nameInput.sendKeys(standard_use);
    }

    public void passwordMethod(String secret_sauce) {
        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.sendKeys(secret_sauce);
    }

    public void loginButtonClick() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void inventoryTitle(String text) {
        By signLocator = By.xpath("//*[text()='" + text + "']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signLocator));
        WebElement sign = driver.findElement(signLocator);
        Assert.isTrue(sign.getText().equals(text), "error");
    }
}

package Pages;

import StepDefinition.Login;
import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static StepDefinition.Login.wait;

public class login_Page {
    public static WebDriver driver;
    public Login login;


    public login_Page(WebDriver driver) {
        this.driver = driver;
        this.login = new Login();
    }

    public By userNameLocator = By.id("user-name");
    public By passwordLocator = By.id("password");
    public By loginButtonLocator = By.id("login-button");

    public void userNameMethod(String user) {
        WebElement nameInput = driver.findElement(userNameLocator);
        nameInput.sendKeys(user);
    }

    public void passwordMethod(String password) {
        WebElement passwordInput = driver.findElement(passwordLocator);
        passwordInput.sendKeys(password);
    }

    public void loginButtonClick() {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();

    }
    public static void inventoryTitle(String text) {
        By signLocator=By.xpath("//*[text()='"+text+"']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(signLocator));
        WebElement sign = driver.findElement(signLocator);
        Assert.isTrue(sign.getText().equals(text),"error");
    }



}

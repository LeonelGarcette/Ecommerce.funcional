package StepDefinition;

import Pages.login_Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static login_Page LoginPage;

    @Before
    public static void setup() {
        System.setProperty("webDriver.chrome.driver", System.getProperty("user.dir") + "/src/java/driver/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        LoginPage = new login_Page(driver);
    }

    @After
    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @When("Access to the URL")
    public void access_to_the_url() {
        driver.get("https://www.saucedemo.com/");
    }

    @And("Type user name {string}")
    public void type_user_name(String user) {
        LoginPage.userNameMethod(user);
    }

    @And("Type password {string}")
    public void type_password(String password) {
        LoginPage.passwordMethod(password);
    }

    @And("Click in Login button")
    public void click_in_login_button() {
        LoginPage.loginButtonClick();
    }

    @Then("Message {string} should be display")
    public void messages_status(String status) {
        switch (status) {
            case "Success":
                LoginPage.inventoryTitle("Products");
                break;
            case "Locked":
                LoginPage.inventoryTitle("Epic sadface: Sorry, this user has been locked out.");
                break;
            case "Error":
                LoginPage.inventoryTitle("Epic sadface: Username and password do not match any user in this service");
                break;
            case "Password":
                LoginPage.inventoryTitle("Epic sadface: Username and password do not match any user in this service");
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + status);
        }
    }
}

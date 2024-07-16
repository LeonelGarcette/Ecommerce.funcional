package StepDefinition;

import Pages.login_Page;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Login {
    private static WebDriver driver;
    public static WebDriverWait wait;
    private static login_Page LoginPage;

    @BeforeAll
    public static void setup() {
        System.setProperty("webdriver.ie.driver", "src/main/java/driver/chromedriver2.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        driver.manage().window().maximize();
        LoginPage = new login_Page(driver);
    }

    @AfterAll
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
                login_Page.inventoryTitle("Products");
                break;
            case "Locked":
                login_Page.inventoryTitle("Epic sadface: Sorry, this user has been locked out.");
                break;
            case "Error":
                login_Page.inventoryTitle("Epic sadface: Username and password do not match any user in this service");
            case "Password":
                login_Page.inventoryTitle("Epic sadface: Username and password do not match any user in this service");
                break;

        }
    }

}

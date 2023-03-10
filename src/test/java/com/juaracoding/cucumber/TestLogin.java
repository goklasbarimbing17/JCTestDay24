package com.juaracoding.cucumber;

import com.juaracoding.cucumber.drivers.DriverSingleton;
import com.juaracoding.cucumber.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class TestLogin {
    public static WebDriver driver;
    public static LoginPage loginPage;

    @BeforeAll
    public static void setUp(){
        DriverSingleton.getInstance("chrome");
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage();
    }

    // Test User valid login into web HRM ...............................
    @Given("User open browser and url")
    public void user_open_browser_and_url() throws InterruptedException {
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        Thread.sleep(2000);
    }

    @When("User enter valid username")
    public void user_enter_valid_username() {
        System.out.println("User enter valid username");
        loginPage.setUsername("Admin");
    }

    @And("User enter valid password")
    public void user_enter_valid_password() {
        System.out.println("User enter valid password");
        loginPage.setPassword("admin123");
    }

    @And("User click button login")
    public void user_click_button_login() {
        System.out.println("User click button login");
        loginPage.clickLogin();
    }

    @Then("User go to page Dashboard")
    public void user_go_to_page_dashboard() {
        System.out.println("User go to page Dashboard");
        Assert.assertEquals(loginPage.getTextDashboard(), "Dashboard");
    }

    @When("User click on logout link")
    public void user_click_on_logout_link(){
        loginPage.logout();
        System.out.println("user logout");
    }

    @And("User enter invalid username")
    public void user_enter_invalid_username() {
        loginPage.setUsername("admin");
    }

    @And("User enter invalid password")
    public void user_enter_invalid_password() {
        loginPage.setPassword("admin123444");
    }

    @Then("User can view message invalid credential")
    public void user_can_view_message_invalid_credential() throws InterruptedException {
        Assert.assertEquals(loginPage.getInvalidCredential(),"Invalid credentials");
        Thread.sleep(2000);
    }

    @Then("User can view messages required")
    public void user_can_view_messages_required() throws InterruptedException {
        Assert.assertEquals(loginPage.getMessageRequired(),"Required");
        Thread.sleep(2000);
    }

    @AfterAll
    public static void tearDown(){
        DriverSingleton.closeObjectInstance();
    }
}

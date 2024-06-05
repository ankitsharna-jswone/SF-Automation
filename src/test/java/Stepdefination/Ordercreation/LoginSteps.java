package Stepdefination.Ordercreation;

import Pages.LoginPage;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;

import static Utils.BrowsserSetup.getDriver;

public class LoginSteps {
    WebDriver driver = getDriver();
    LoginPage log = new LoginPage(getDriver());


    @Given("the user navigates to the Salesforce login page {string}")
    public void userNavigatesToSalesforceLoginPage(String website) {
        driver.get(website);
        System.out.println("user at login page");
    }

    @When("the user enters the username {string}")
    public void userEntersUsername(String username) {
        // Implementation to enter the username
        log.usernameSF(username);
    }

    @When("the user enters the password {string}")
    public void userEntersPassword(String password) {
        // Implementation to enter the password
        log.passwordSF(password);
    }

    @When("the user clicks on the login button")
    public void userClicksOnLoginButton() {
        // Implementation to click on the login button
        log.loginSF();
    }
}

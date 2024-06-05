package Stepdefination.Ordercreation;
import Pages.*;
import Utils.Functionalities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;

import static Utils.BrowsserSetup.getDriver;


//import static Utils.BrowsserSetup.getDriver;

public class HrCoilDefination {

    WebDriver driver = getDriver();
    AccountPage accountPage = new AccountPage(driver);
    ProcessOpportunity processOpportunity = new ProcessOpportunity(driver);

    @Given("the user is on the account page")
    public void the_user_is_on_the_account_page() {
        System.out.println("Account Page");

    }
    @When("the user creates a quick opportunity")
    public void the_user_creates_a_quick_opportunity() {
        accountPage.quickOpportunity();
    }
    @When("the user adds a new opportunity")
    public void the_user_adds_a_new_opportunity() {
        processOpportunity.addButton();

    }
    @When("the user searches for the product {string}")
    public void the_user_searches_for_the_product(String string) {
        processOpportunity.searchProduct(string);

    }
    @When("the user selects the product {string}")
    public void the_user_selects_the_product(String string) {
        processOpportunity.selectProduct(string);
    }
    @When("the user sets the quantity to {string}")
    public void the_user_sets_the_quantity_to(String string) {
        processOpportunity.setQuantity(string);

    }
    @When("the user sets the thickness to {string}")
    public void the_user_sets_the_thickness_to(String string) {
        processOpportunity.setThickness(string);
    }

    @When("the user selects the width as {string}")
    public void the_user_selects_the_width_as(String string) {
        processOpportunity.selectWidht(string);

    }

    @When("the user saves the category price")
    public void the_user_saves_the_category_price() {
        processOpportunity.saveCategory();
    }

    @When("the user saves the opportunity")
    public void the_user_saves_the_opportunity() throws InterruptedException {
        processOpportunity.saveOpportunity();
    }


}

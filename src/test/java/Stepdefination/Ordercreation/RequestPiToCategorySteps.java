package Stepdefination.Ordercreation;

import Pages.AccountPage;
import Pages.ProcessOpportunity;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static Utils.BrowsserSetup.getDriver;

public class RequestPiToCategorySteps {
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());

    @Given("the user clicks on the process opportunity button for PI to category team")
    public void the_user_clicks_on_the_process_opportunity_button_for_pi_to_category_team() {
        processOpportunity.processOpportunitybutton();

    }
    @Given("the user saves the opportunity first")
    public void the_user_saves_the_opportunity_first() throws InterruptedException {
        processOpportunity.saveOpportunity();

    }
    @Given("the user requests PI to the category team")
    public void the_user_requests_pi_to_the_category_team() {
        processOpportunity.requestPItocategory();

    }
    @Given("the user selected the {string}")
    public void the_user_selected_the(String string) {
        processOpportunity.categoryUserTest();

    }
    @When("the user saves the category user")
    public void the_user_saves_the_category_user() {
        processOpportunity.saveCategory();

    }
    @When("the user saves the opportunity for sales")
    public void the_user_saves_the_opportunity_for_sales() throws InterruptedException {
        processOpportunity.saveOpportunity();

    }
    @Then("Check stage of the opportunity is {string}")
    public void check_stage_of_the_opportunity_is(String string) throws InterruptedException {
        AccountPage accountPage = new AccountPage(getDriver());
        Assert.assertEquals(string,accountPage.stageOfOpportunity());

    }

}

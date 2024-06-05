package Stepdefination.Ordercreation;

import Pages.AccountPage;
import Pages.GreenPopup;
import Pages.OpportunityPage;
import Pages.ProcessOpportunity;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static Utils.BrowsserSetup.getDriver;

public class CustomerPricingSteps {
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());
    AccountPage accountPage = new AccountPage(getDriver());
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @Given("the user clicks on the process opportunity button for pricing")
    public void the_user_clicks_on_the_process_opportunity_button_for_pricing() {
        processOpportunity.processOpportunitybutton();
    }
    @When("user sets the customer-accepted price to {string}")
    public void user_sets_the_customer_accepted_price_to(String price) {
        processOpportunity.customerFinalPrice(price);
    }
    @When("the user saves the opportunity for pricing")
    public void the_user_saves_the_opportunity_for_pricing() throws InterruptedException {
        processOpportunity.saveOpportunity();

    }
    @When("the user verifies the customer-accepted price")
    public void the_user_verifies_the_customer_accepted_price() throws InterruptedException {
        processOpportunity.verifyPriceCustomer();

    }
    @When("the user saves the opportunity final price")
    public void the_user_saves_the_opportunity_final_price() throws InterruptedException {
        processOpportunity.saveOpportunity();

    }
    @Then("the check stage of the opportunity is {string}")
    public void the_check_stage_of_the_opportunity_is(String string) throws InterruptedException {

        String stage = accountPage.stageOfOpportunity();
        Assert.assertEquals(string,stage);

    }

    @Then("Print the stage of the Opportunity")
    public void printStage() throws InterruptedException {
        System.out.println("Stage of the opportunity is : " + accountPage.stageOfOpportunity());
    }

    @Then("Then accept all the SKUs")
    public void acceptAllTheSku(){

        opportunityPage.acceptAllskus();
    }

    @Then("Click on the proceed button")
    public void clickSavebutton(){
        opportunityPage.acceptAllSkuproceed();
    }

}

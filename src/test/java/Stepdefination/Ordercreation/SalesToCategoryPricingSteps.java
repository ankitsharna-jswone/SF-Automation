package Stepdefination.Ordercreation;

import Pages.AccountPage;
import Pages.PricingAwaitingPage;
import Pages.ProcessOpportunity;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static Utils.BrowsserSetup.getDriver;

public class SalesToCategoryPricingSteps {


    PricingAwaitingPage awaitingPage = new PricingAwaitingPage(getDriver());
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());
    AccountPage accountPage = new AccountPage(getDriver());


    @When("Sales team clicks on the price awaiting section")
    public void the_user_clicks_on_the_price_awaiting_section() {
        awaitingPage.clickPriceAwaiting();
    }
    @When("the user performs the category user test with Category team {string}")
    public void the_user_performs_the_category_user_test(String category) {
        awaitingPage.categoryUserTest(category);

    }
    @When("the user saves the category")
    public void the_user_saves_the_category() {
        awaitingPage.saveCategory();

    }
    @Then("the stage of the opportunity is {string}")
    public void the_stage_of_the_opportunity_is(String string) throws InterruptedException {

        String stage = accountPage.stageOfOpportunity();
        Assert.assertEquals(string,stage);
    }
    @Then("The stage of opportunity will be printed")
    public void stagePrinting() throws InterruptedException {
        System.out.println(accountPage.stageOfOpportunity() + " -> is the stage of opportunity");
    }
}

package Stepdefination.Ordercreation;

import Pages.AccountPage;
import io.cucumber.java.en.*;
import org.testng.Assert;

import static Utils.BrowsserSetup.getDriver;

public class ChooseSellerPIsteps {
    AccountPage accountPage = new AccountPage(getDriver());
    @Given("the user navigates to the file page")
    public void userNavigatesToFilePage() {
        accountPage.filePage();

    }

    @And("the user chooses the seller PI")
    public void userChoosesSellerPI() {
        accountPage.chooseSellerPI();

    }

    @And("the user sets the seller PI")
    public void userSetsSellerPI() {
        accountPage.setSellerPi();

    }

    @Then("the stage of the opportunity is now {string}")
    public void stageOfOpportunityIs(String stage) throws InterruptedException {
        Assert.assertEquals(stage,accountPage.stageOfOpportunity());
    }
}

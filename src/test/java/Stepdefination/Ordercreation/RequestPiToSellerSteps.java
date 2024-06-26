package Stepdefination.Ordercreation;

import Pages.ProcessOpportunity;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_scouse.An;

import static Utils.BrowsserSetup.getDriver;

public class RequestPiToSellerSteps {
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());

    @Given("User processed opportunity to send PI to seller")
    public void userProcessedOpportunity(){
        processOpportunity.requestPItoSeller();
    }


    @When("User is on the user saves the opportunity")
    public void userSavesOpportunity() throws InterruptedException {
        processOpportunity.saveOpportunity();

    }

    @When("the user requests PI to the seller")
    public void userRequestedSellerToPI() throws InterruptedException {
        Thread.sleep(1000);
        processOpportunity.requestPItoSeller();

    }

    @And("the user saves the final order")
    public void userSaved(){
        processOpportunity.saveFinalOrder();
    }

}

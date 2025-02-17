package Stepdefination.Opportunity;

import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static Utils.BrowsserSetup.getDriver;

public class AdvanceApprovalSteps {

    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @Given("User opens the Submit for approval component")
    public void user_opens_to_submit_for_approval(){
        opportunityPage.showMoreActions();
        opportunityPage.submitForApprovalAdvanceButton();
        opportunityPage.approvalComment("Approve it");
    }

    @When("User Opens the approval submit box")
    public void user_open_the_advance_approval(){
        opportunityPage.submitButtonForAdvanceApproval();
    }

    @When("User Opens the Approval Box User checks the Status of Approval")
    public void user_checks_the_status_of_approval(){
        System.out.println(opportunityPage.statusOfApproval());

    }

    @Then("The approval is routed to {string} with Advance % between 0 and 10.")
    public void user_checks_the_approver(String name){
        System.out.println(opportunityPage.assginedToUser());
    }




}

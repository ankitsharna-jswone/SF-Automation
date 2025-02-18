package Stepdefination.Opportunity;

import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.driver;

public class AdvanceApprovalSteps {

    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @Given("User opens the Submit for approval component")
    public void user_opens_to_submit_for_approval(){
        opportunityPage.showMoreActions();
        opportunityPage.submitForApprovalAdvanceButton();

    }

    @When("User submits the approval submit for approval box")
    public void user_open_the_advance_approval(){
        opportunityPage.approvalComment("Approve it");
        opportunityPage.submitButtonForAdvanceApproval();

    }

    @When("User Opens the Approval Box User checks the Status of Approval")
    public void user_checks_the_status_of_approval() throws InterruptedException {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) getDriver();
        for (int i = 0; i < 10; i++) {
            javascriptExecutor.executeScript("window.scrollBy(0, 500);"); // Scrolls 100 pixels down
            Thread.sleep(500);
        }
        opportunityPage.approvalHistoryBoxButton();
        System.out.println("Status For approval : " + opportunityPage.statusOfApproval());

    }

    @When("User Checks for the approval submitted by is current User")
    public void check_approval_submitted_by(){
        System.out.println("Approval Submitted by : " + opportunityPage.requestedByUser());
    }

    @Then("The approval is routed to {string} with Advance % between 0 and 10.")
    public void user_checks_the_approver(String name){
        System.out.println("Approval assigned to" +  opportunityPage.assginedToUser());
    }




}

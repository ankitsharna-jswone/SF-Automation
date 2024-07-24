package Stepdefination.Ordercreation;

import Pages.OpportunityPage;
import io.cucumber.java.en.When;

import static Utils.BrowsserSetup.getDriver;

public class OpportunityPageSteps {
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @When("User click on Select Credit button")
    public void user_click_on_credit_button(){
        opportunityPage.selectCreditButton();
    }

    @When("User marked Credit requirement as Required")
    public void user_mark_credit_required_true(){
        opportunityPage.creditRequiredTrue();
    }

    @When("user chose the credit program on the Opportunity {string}")
    public void userChoseCreditProgrma(String string){
        opportunityPage.userSelectCreditProgramButton();
        opportunityPage.userSelectCreditProgramType(string);
    }

    @When("User selects the credit Days on the Opportutnity {string}")
    public void userFilledCreditDays(String days){
        opportunityPage.userFillsCreditDays(days);
    }

    @When("User fills the advance percentage {string}")
    public void userFillsAdvancePercentage(String advance){
        opportunityPage.userSelectsAdvacncePercentage(advance);
    }

    @When("User saves the Credit Program on the Opportunity")
    public void userSavesTheCreditProgram(){
        opportunityPage.userSavesCreditProgram();
    }
}

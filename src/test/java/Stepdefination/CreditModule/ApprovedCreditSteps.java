package Stepdefination.CreditModule;

import Pages.AccountPage;
import Pages.ApprovedCreditPrograms;
import com.aventstack.extentreports.util.Assert;
import io.cucumber.java.en.*;

import javax.xml.transform.Source;
import java.util.List;

import static Utils.BrowsserSetup.getDriver;

public class ApprovedCreditSteps {
    AccountPage accountPage = new AccountPage(getDriver());
    ApprovedCreditPrograms approvedCreditPrograms = new ApprovedCreditPrograms();

    @When("the user goes to the Approved Credit Program tab")
    public void the_user_goes_to_the_approved_credit_program_tab() {
        accountPage.ApprovedCreditProgramButton();
    }
    @When("the user fetches the credit program names")
    public void the_user_fetches_the_credit_program_names() {
        List<String> Names = approvedCreditPrograms.CreditProgramName();
        for(String name : Names){
            System.out.println("Credit Programs Present in this Account is : " + name);
        }

    }
    @When("the user fetches the usable limit amount for the credit program {string}")
    public void the_user_fetches_the_usable_limit_amount_for_the_credit_program(String string) {
        System.out.println(approvedCreditPrograms.UsableAmount(string) + " : Utilised Amount");
        Assert.notNull(approvedCreditPrograms.UsableAmount(string),"Passed");

    }
    @When("the user fetches the sanctioned amount for the credit program {string}")
    public void the_user_fetches_the_sanctioned_amount_for_the_credit_program(String string) {

        Assert.notNull(approvedCreditPrograms.SanctionedAmount(string),"Passed");
        System.out.println(approvedCreditPrograms.SanctionedAmount(string) + " : SanctionedAmount Amount");
    }
    @When("the user fetches the utilised amount for the credit program {string}")
    public void the_user_fetches_the_utilised_amount_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.UtilisedAmount(string),"Passed");
        System.out.println(approvedCreditPrograms.UtilisedAmount(string) + " : Utilised Amount");

    }
    @When("the user fetches the available amount for the credit program {string}")
    public void the_user_fetches_the_available_amount_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.AvailableAmount(string),"Passed");
        approvedCreditPrograms.AvailableAmount(string);
    }
    @When("the user fetches the blocked amount for the credit program {string}")
    public void the_user_fetches_the_blocked_amount_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.BlockedAmount(string),"Passed");
        System.out.println(approvedCreditPrograms.BlockedAmount(string) + " : BlockedAmount Amount");
    }
    @When("the user fetches the usable amount for the credit program {string}")
    public void the_user_fetches_the_usable_amount_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.UsableAmount(string),"Passed");
        System.out.println(approvedCreditPrograms.UsableAmount(string) + " : UsableAmount Amount");
    }
    @When("the user fetches the credit expiry date for the credit program {string}")
    public void the_user_fetches_the_credit_expiry_date_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.CreditExpiryDate(string),"Passed");
        System.out.println(approvedCreditPrograms.CreditExpiryDate(string) + " : CreditExpiryDate ");
    }
    @When("the user fetches the credit due days for the credit program {string}")
    public void the_user_fetches_the_credit_due_days_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.CreditDueDays(string),"Passed");
        System.out.println(approvedCreditPrograms.CreditDueDays(string) + " : CreditDueDays ");
    }
    @When("the user fetches the penal rate for the credit program {string}")
    public void the_user_fetches_the_penal_rate_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.PenalRate(string),"Passed");
        System.out.println(approvedCreditPrograms.PenalRate(string) + " : CreditDueDays ");
    }
    @When("the user fetches the credit limit block for the credit program {string}")
    public void the_user_fetches_the_credit_limit_block_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.CreditLimitBlock(string),"Passed");
        System.out.println(approvedCreditPrograms.CreditLimitBlock(string) + " : CreditLimitBlock ");
    }
    @When("the user fetches the credit limit block reason for the credit program {string}")
    public void the_user_fetches_the_credit_limit_block_reason_for_the_credit_program(String string) {
        Assert.notNull(approvedCreditPrograms.CreditLimitBlockReason(string),"Passed");
        System.out.println(approvedCreditPrograms.CreditLimitBlockReason(string) + " : CreditLimitBlockReason ");
    }
    @Then("the user stores the credit details in a JSON file for future validation {string}")
    public void the_user_stores_the_credit_details_in_a_json_file_for_future_validation(String string) {
        approvedCreditPrograms.CreditDetialsJSON(string);
        System.out.println("Credit Details store for future assertions");
    }

}

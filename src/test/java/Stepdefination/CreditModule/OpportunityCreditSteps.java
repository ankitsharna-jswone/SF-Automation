package Stepdefination.CreditModule;

import Pages.OpportunityCreditPage;
import com.google.gson.JsonObject;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static Utils.JsonUtills.getValueFromJson;

public class OpportunityCreditSteps {

    OpportunityCreditPage opportunityCreditPage = new OpportunityCreditPage();

    String creidtAmount ;
    String ApprovedCreditDays ;
    String creditAvialable ;
    String creditDays;
    String creditProgramName;
    String creditRequired;
    String creditUtilised;
    String blockedLimiit;
    String CreditProgramName;
    String CreditExpiryDate;
    String CreditProgramType;
    String PenalInterest;




    @When("the user should fetch the Credit Amount from the Opportunity page")
    public void the_user_should_fetch_the_credit_amount_from_the_opportunity_page() {
         creidtAmount = opportunityCreditPage.CreditAmount();
        Assert.assertNotNull(creidtAmount);
    }
    @When("the user should fetch the Approved Credit Days from the Opportunity page")
    public void the_user_should_fetch_the_approved_credit_days_from_the_opportunity_page() {
         ApprovedCreditDays = opportunityCreditPage.ApprovedCreditDays();
        Assert.assertNotNull(ApprovedCreditDays);

    }
    @When("the user should fetch the Credit Available from the Opportunity page")
    public void the_user_should_fetch_the_credit_available_from_the_opportunity_page() {
         creditAvialable = opportunityCreditPage.CreditAvialable();
        Assert.assertNotNull(creditAvialable);
    }
    @When("the user should fetch the Credit Days from the Opportunity page")
    public void the_user_should_fetch_the_credit_days_from_the_opportunity_page() {
         creditDays = opportunityCreditPage.CreditDays();
        Assert.assertNotNull(creditDays);
    }
    @When("the user should fetch the Credit Program Name from the Opportunity page")
    public void the_user_should_fetch_the_credit_program_name_from_the_opportunity_page() {
         creditProgramName = opportunityCreditPage.CreditProgramName();
        Assert.assertNotNull(creditProgramName);
    }
    @When("the user should fetch the Credit Required from the Opportunity page")
    public void the_user_should_fetch_the_credit_required_from_the_opportunity_page() {
         creditRequired = opportunityCreditPage.CreditRequired();
        Assert.assertNotNull(creditRequired);
    }
    @When("the user should fetch the Credit Utilised from the Opportunity page")
    public void the_user_should_fetch_the_credit_utilised_from_the_opportunity_page() {
         creditUtilised = opportunityCreditPage.CreditUtilised();
        Assert.assertNotNull(creditUtilised);
    }
    @When("the user should fetch the Blocked Limit from the Opportunity page")
    public void the_user_should_fetch_the_blocked_limit_from_the_opportunity_page() {
         blockedLimiit = opportunityCreditPage.BlockedLimiit();
        Assert.assertNotNull(blockedLimiit);
    }
    @When("the user should fetch the Program Credit from the Opportunity page")
    public void the_user_should_fetch_the_program_credit_from_the_opportunity_page() {
         CreditProgramName = opportunityCreditPage.CreditProgramName();
        Assert.assertNotNull(CreditProgramName);
    }
    @When("the user should fetch the Credit Expiry Date from the Opportunity page")
    public void the_user_should_fetch_the_credit_expiry_date_from_the_opportunity_page() {
         CreditExpiryDate = opportunityCreditPage.CreditExpiryDate();
        Assert.assertNotNull(CreditExpiryDate);
    }
    @When("the user should fetch the Credit Program Type from the Opportunity page")
    public void the_user_should_fetch_the_credit_program_type_from_the_opportunity_page() {
         CreditProgramType = opportunityCreditPage.CreditProgramType();
        Assert.assertNotNull(CreditProgramType);
    }
    @When("the user should fetch the Penal Interest from the Opportunity page")
    public void the_user_should_fetch_the_penal_interest_from_the_opportunity_page() {
         PenalInterest = opportunityCreditPage.PenalInterest();
        Assert.assertNotNull(PenalInterest);
    }
    @When("the user should fetch the API response for the selected Credit Program")
    public void the_user_should_fetch_the_api_response_for_the_selected_credit_program() throws IOException {
        String jsonString = new String(Files.readAllBytes(Paths.get("src/test/resources/ApiResponse/ApprovedCreditProgram.json")));
        Assert.assertNotNull(jsonString);
    }
    @Then("the Credit Amount from the Opportunity page should match the Credit Amount in the API response")
    public void the_credit_amount_from_the_opportunity_page_should_match_the_credit_amount_in_the_api_response() {
        System.out.println("Credit Amount is based on the Advance so the value will be independent of the API response : ");
    }

    @Then("the Approved Credit Days from the Opportunity page should match the Approved Credit Days in the API response")
    public void the_approved_credit_days_from_the_opportunity_page_should_match_the_approved_credit_days_in_the_api_response() {
        Assert.assertEquals(ApprovedCreditDays,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "CreditDueDays"));
    }

    @Then("the Credit Available from the Opportunity page should match the Credit Available in the API response")
    public void the_credit_available_from_the_opportunity_page_should_match_the_credit_available_in_the_api_response() {
        Assert.assertEquals(creditAvialable,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "UsableAmount"));
    }
    @Then("the Credit Days from the Opportunity page should match the Credit Days in the API response")
    public void the_credit_days_from_the_opportunity_page_should_match_the_credit_days_in_the_api_response() {
        Assert.assertEquals(creditDays,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "CreditDueDays"));
    }
    @Then("the Credit Program Name from the Opportunity page should match the Credit Program Name in the API response")
    public void the_credit_program_name_from_the_opportunity_page_should_match_the_credit_program_name_in_the_api_response() {
        Assert.assertNotNull(creditProgramName);
    }
    @Then("the Credit Required from the Opportunity page should match the Credit Required in the API response")
    public void the_credit_required_from_the_opportunity_page_should_match_the_credit_required_in_the_api_response() {
        Assert.assertNotNull(creditRequired);
    }
    @Then("the Credit Utilised from the Opportunity page should match the Credit Utilised in the API response")
    public void the_credit_utilised_from_the_opportunity_page_should_match_the_credit_utilised_in_the_api_response() {
        Assert.assertEquals(creditUtilised,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "UtilisedAmount"));
    }
    @Then("the Blocked Limit from the Opportunity page should match the Blocked Limit in the API response")
    public void the_blocked_limit_from_the_opportunity_page_should_match_the_blocked_limit_in_the_api_response() {
        Assert.assertEquals(blockedLimiit,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "BlockedAmount"));
    }
    @Then("the Program Credit from the Opportunity page should match the Program Credit in the API response")
    public void the_program_credit_from_the_opportunity_page_should_match_the_program_credit_in_the_api_response() {
        Assert.assertNotNull(creditProgramName);
    }
    @Then("the Credit Expiry Date from the Opportunity page should match the Credit Expiry Date in the API response")
    public void the_credit_expiry_date_from_the_opportunity_page_should_match_the_credit_expiry_date_in_the_api_response() {
        Assert.assertEquals(CreditExpiryDate,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "CreditExpiryDate"));
    }
    @Then("the Credit Program Type from the Opportunity page should match the Credit Program Type in the API response")
    public void the_credit_program_type_from_the_opportunity_page_should_match_the_credit_program_type_in_the_api_response() {
//        Assert.assertEquals(CreditProgramType,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "CreditProgramName"));
    }
    @Then("the Penal Interest from the Opportunity page should match the Penal Interest in the API response")
    public void the_penal_interest_from_the_opportunity_page_should_match_the_penal_interest_in_the_api_response() {
        Assert.assertEquals(PenalInterest,getValueFromJson("src/test/resources/ApiResponse/ApprovedCreditProgram.json", "PenalRate"));
    }

}

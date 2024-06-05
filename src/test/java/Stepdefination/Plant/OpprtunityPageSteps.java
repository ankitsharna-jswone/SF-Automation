package Stepdefination.Plant;

import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static Utils.BrowsserSetup.getDriver;

public class OpprtunityPageSteps {
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @Given("User click edit button to edit for TDC upload")
    public void clickEditbutton(){
        opportunityPage.editTDCButton();
    }

    @Given("User checked the TDC uploaded")
    public void checkTheTDCValidation(){
        opportunityPage.TdcUploadcheckBox();
    }

    @Given("User checked PO Uploaded")
    public void checkPOupload(){
        opportunityPage.PopUploadCheckBox();
    }

    @When("user saved the opportunity")
    public void saveTheOpportunitypage(){
        opportunityPage.opportunitySave();
    }

    @Given("User click edit button to edit for supply")
    public void click_Editbutton(){
        opportunityPage.editTDCButton();
    }

    @Given("User check the TDC sent to customer")
    public void checkTDC2Customer(){
        opportunityPage.TDCsent2Customer();
    }

    @Given("User check the TDC sent to Plant")
    public void checkTDC2Plant(){
        opportunityPage.TDCsent2Plant();
    }

    @Given("User check the TDC validation")
    public void checkTDCvalidation(){
        opportunityPage.TDC_valdition();
    }

    @When("Check the feasibility of the order")
    public void clickOnDropDown(){
        opportunityPage.SupplyFeasibalityDropdwon();
    }

    @When("Choose yes for the feasibility")
    public void chooseTheResponse(){
        opportunityPage.selectYesResponse();
    }

    @Then("Then User filled the advance % {string}")
    public void fillAdvanceAtOpportunity(String string){
        opportunityPage.opportunityAdvance(string);
    }






}

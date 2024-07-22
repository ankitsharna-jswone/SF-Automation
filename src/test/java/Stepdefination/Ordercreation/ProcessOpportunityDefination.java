package Stepdefination.Ordercreation;
import Pages.*;
import Utils.Functionalities;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.WebDriver;

import static Utils.BrowsserSetup.getDriver;

//import static Utils.BrowsserSetup.getDriver;

public class ProcessOpportunityDefination {

    WebDriver driver = getDriver();
    ProcessOpportunity processOpportunity = new ProcessOpportunity(driver);
    AccountPage accountPage = new AccountPage(driver);

    @Given("the user is on the opportunity processing page")
    public void the_user_is_on_the_opportunity_processing_page() {
        System.out.println("Opportunity processin page");
    }
    @When("the user clicks on the process opportunity button")
    public void the_user_clicks_on_the_process_opportunity_button() throws InterruptedException {
        processOpportunity.processOpportunitybutton();
    }
    @When("the user selects to edit the opportunity")
    public void the_user_selects_to_edit_the_opportunity() {
        processOpportunity.editOpportunity();

    }
    @When("the user edits the delivery type to {string}")
    public void the_user_edits_the_delivery_type_to(String deliveryType) {
        processOpportunity.editDelivery(deliveryType);
    }

    @When("the user selectes the credit required as YES")
    public void user_selects_credit_required_yes(){
        processOpportunity.creditRequired();
        processOpportunity.creditRequiredYes();

    }

    @When("User selects the credit {string} for the user")
    public void user_choose_credit_program(String string){
        processOpportunity.creditProgramType();
        processOpportunity.selectCreditProgram(string);
    }

    @When("User sets the Credit days {string}")
    public void select_credit_days(String days){
        processOpportunity.creditDays(days);
    }

    @When("the user edits the delivery time to {string} days")
    public void the_user_edits_the_delivery_time_to_days(String days) {
        processOpportunity.editDeliveryTime(days);

    }
    @When("the user edits the special message to {string}")
    public void the_user_edits_the_special_message_to(String specialmessage) {
        processOpportunity.editSpecialMessage(specialmessage);
    }
    @When("the user selects the category price as {string}")
    public void the_user_selects_the_category_price_as(String price) {
        processOpportunity.categoryPrice(price);
    }

    @When("the user chose the paint colour {string}")
    public void choose_the_paint_colour(String colour){
        processOpportunity.chooseColour(colour);

    }

    @When("the user searches for the source seller {string}")
    public void the_user_searches_for_the_source_seller(String seller) {
        processOpportunity.searchSouceSeller(seller);
    }


    @When("the user selects the source seller {string}")
    public void the_user_selects_the_source_seller(String seller) {
        processOpportunity.selectSourceSeller(seller);
    }



    @When("the user searches for the seller {string}")
    public void the_user_searches_for_the_coil_seller(String seller) {
        processOpportunity.searchSeller(seller);
    }
    @When("the user selects plant the seller {string}")
    public void the_user_selects_the_coil_seller(String seller) {
        processOpportunity.selectPlantSeller(seller);
    }
    @When("the user edits the cost price to {string}")
    public void the_user_edits_the_cost_price_to(String string) {
        processOpportunity.editCostPrice(string);

    }
    @And("the opportunity is processed to the Category team for pricing")
    public void the_opportunity_is_processed_to_the_sales_team_and_required_documents_are_filled_successfully() {
        processOpportunity.pricingAwaited();
    }

    @Then("wait for the {string} success")
    public void wait_for_succes_message(String message){
        processOpportunity.greenMessage(message);
    }

    @Then("the user saves the opportunity for sales team")
    public void savefor_sales() throws InterruptedException {
        processOpportunity.saveOpportunity();
    }

    @Then("User Went to SKU requirement page")
    public void SKUreqs(){
        accountPage.skuReqPage();
    }

    @Then("User selected the SKU number {string}")
    public void chooseTheSKU(String sku){
        int ind = Integer.parseInt(sku);
        accountPage.selectSKU(ind);
    }

    @Then("Click on the Opportunity Page")
    public void gotoOpportunity(){
        SKUPage skuPage = new SKUPage(getDriver());
        skuPage.opportunityPage();
    }
}

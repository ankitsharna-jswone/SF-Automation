package Stepdefination.Ordercreation;

import Pages.HomePage;
import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static Utils.BrowsserSetup.getDriver;

public class HomePageNavigationSteps {
    HomePage homePage = new HomePage(getDriver());
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());


    @Given("the user opens the search tab")
    public void userOpensSearchTab() {
        homePage.openSearchTab();
    }

    @When("the user searches for the item {string}")
    public void userSearchesForItem(String searchItem) {
        homePage.searchItem(searchItem);


    }

    @When("the user clicks on the search result for {string} accounts")
    public void userClicksOnSearchResultForAccounts(String searchResult) {
        // Implementation to click on the search result for accounts
        homePage.searchAccountClick(searchResult + " accounts");

    }

    @When("the user opens the account {string}")
    public void userOpensAccount(String accountName) {
        // Implementation to open the specified account
        homePage.openAccount(accountName);
    }

    @When("user accepted All SKUs")
    public void acceptAllSKU(){
        opportunityPage.acceptAllskus();
    }

    @When("user click on proceed button")
    public void acceptSKUproceed(){
        opportunityPage.acceptAllSkuproceed();
    }

}

package Stepdefination.Ordercreation;

import Pages.HomePage;
import Pages.OpportunityPage;
import io.cucumber.java.en.Given;

import static Utils.BrowsserSetup.getDriver;

public class CategoryUserSteps {


    OpportunityPage opportunityPage = new OpportunityPage(getDriver());
    HomePage homePage = new HomePage(getDriver());

    @Given("Category team Searches the opportunity")
    public void searchTheOpportunity(){
        String opp = String.valueOf(opportunityPage.getOpportunityName());
        System.out.println(opp + " Opportunity name");
        homePage.searchItem(opp);
    }

    @Given("Sales team Searches the opportunity")
    public void searchTheOpportunitySales(){
        String opp = String.valueOf(opportunityPage.getOpportunityName());
        System.out.println(opp + " Opportunity name");
        homePage.searchItem(opp);
    }

    @Given("User opens the Opportunity page")
    public void openTheOpportunity(){
        String opp = String.valueOf(opportunityPage.getOpportunityName());
        homePage.openOpportunity(opp);
    }
}

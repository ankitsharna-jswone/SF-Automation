package Stepdefination.Sales;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static Utils.BrowsserSetup.getDriver;

public class AccountPageSteps {

    AccountPage accountPage = new AccountPage(getDriver());
    HomePage homePage = new HomePage(getDriver());
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());

    @Given("User is on the Account page")
    public void accountPageConfirmation(){
        System.out.println("Account page reached");
    }

    @Given("User click on the dropdown and click on the quick opportunity button")
    public void dropDownbuttonClick(){
        accountPage.OpportunityDropDown();
        accountPage.salesQuickOpportunity();
    }

    @When("User choose the manufacturing type of Opportunity")
    public void ManfacturingTypeOrderSelect(){
        accountPage.opportunityManufacturing();
    }

    @Given("user clicks on account button")
    public void UserAccountIconButtonClick(){
        homePage.LoggedUserIconButton();
    }

    @Given("User clicks on log out button")
    public void UserClicksOnLogoutButton(){
        homePage.LogOutButton();
    }

    @When("User saves the Opportunity name")
    public void UserSaveTheOpportunityName(){
        opportunityPage.setOpportunityNumber();
    }


}

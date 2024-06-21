package Stepdefination.Sales;

import Pages.AccountPage;
import Pages.HomePage;
import Pages.OpportunityPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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
    public void UserAccountIconButtonClick() throws InterruptedException {
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

    @Given("User is on Opportunity page")
    public void userHomePage(){
        System.out.println("User at homepage");
    }

    @When("User clicks on the Handover Opportunity to category team")
    public void userClicksOnHandoverCategoryTeamButton(){
        opportunityPage.handoverToCategoryButton();
    }

    @Then("User Searches the {string} user for that opportunity")
    public void userSearchedtheCategoryFolk(String category){
        opportunityPage.searchCategory(category);
    }

    @Then("User selected the  {string} folk")
    public void userSelectsTheCategoryFolk(String category){
        opportunityPage.selectCategoryUser(category);
    }

    @Then("User clicked on next button")
    public void userClicksOnNextButton(){
        opportunityPage.nextButton();
    }





}

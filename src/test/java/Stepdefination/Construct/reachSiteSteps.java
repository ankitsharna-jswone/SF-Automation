package Stepdefination.Construct;


import Pages.AccountPage;
import Pages.HomePage;
import io.cucumber.java.en.*;

import static Utils.BrowsserSetup.getDriver;

public class reachSiteSteps {
    HomePage home = new HomePage(getDriver());
    AccountPage accountPage = new AccountPage(getDriver());

    @Given("the user is on the home page")
    public void navigateToHomePage() {
        home.openSearchTab();
    }

    @When("they search for account {string}")
    public void searchForItem(String item) {
        home.searchItem(item);
    }

    @And("they click on the account for {string}")
    public void clickOnAccount(String accountName) {
        home.searchAccountClick(accountName);
    }


    @And("they moved to the site tab")
    public void openSite() {
        accountPage.openSite();
    }

    @Then("they should be on the {string} site page")
    public void verifySitePage(String siteName) {
        accountPage.chooseSite(siteName);
    }
}


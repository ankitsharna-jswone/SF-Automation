package Stepdefination.Construct;


import Pages.SitePage;
import io.cucumber.java.en.*;

import static Utils.BrowsserSetup.getDriver;

public class createOpportunitySteps {

        SitePage site = new SitePage(getDriver());

        @Given("they creates an opportunity")
        public void quickOpportunityCreation() {
            site.quickOpportunity();
        }

        @And("they select the cement option")
        public void selectCementOption() {
            site.cementButton();

        }

        @And("they choose the cement brand {string}")
        public void chooseCementBrand(String brandName) {
            site.cementBrandSelect(brandName);

        }

        @When("they specify the cement type as {string} with quantity {string}")
        public void specifyCementTypeAndQuantity(String cementType, String quantity) {
            site.cementTypeAndQuantity(cementType, quantity);

        }

        @And("they save the cement opportunity")
        public void saveCementOpportunity() {
            site.saveCementOpportunity();
        }
    }


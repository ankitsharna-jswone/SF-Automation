package Stepdefination.Ordercreation;

import Pages.*;
import Utils.Functionalities;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

import static Utils.BrowsserSetup.getDriver;
import static Utils.BrowsserSetup.setDriver;

public class GenericFlow {
    static WebDriver driver;
    static WebDriverWait wait;
    Actions actions;
    Functionalities func;
    LoginPage log ;
    HomePage homePage;
    AccountPage accountPage;
    ProcessOpportunity processOpportunity;
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());
    PricingAwaitingPage awaitingPage;
    String ordernumber;
    OrderPage orderPage;

    @Given("the browser and driver are set for automation {string}")
    public void the_browser_and_driver_are_set_for_automation(String browser) {
        setDriver(browser);
        driver = getDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        actions = new Actions(driver);
        func = new Functionalities(driver);


        log = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        processOpportunity = new ProcessOpportunity(driver);
        awaitingPage = new PricingAwaitingPage(driver);
        orderPage = new OrderPage(driver);

    }
    @Given("the user logs in to Salesforce with {string} and {string} at {string}")
    public void the_user_logs_in_to_salesforce_with_and_at(String username, String password, String website) {
        driver.get(website);
        log.usernameSF(username);
        log.passwordSF(password);
        log.loginSF();
    }
    @Given("the user selects the {string} app")
    public void the_user_selects_the_app(String string) {
        homePage.Applauncher();
        homePage.AppSearchingBox(string);
        homePage.SelectApp(string);

    }
    @Given("the user navigates to the {string} account")
    public void the_user_navigates_to_the_account(String searchItem) {
        homePage.openSearchTab();
        homePage.searchItem(searchItem);
        homePage.searchAccountClick(searchItem + " accounts");
        homePage.openAccount(searchItem);

    }
    @Given("the user creates an opportunity with product {string}, quantity {string}, thickness {string}, and width {string}")
    public void the_user_creates_an_opportunity_with_product_quantity_thickness_and_width(String product, String quantity, String thickness, String width) throws InterruptedException {
        accountPage.quickOpportunity();
        processOpportunity.addButton();
        processOpportunity.searchProduct(product);
        processOpportunity.selectProduct(product);
        processOpportunity.setQuantity(quantity);
        processOpportunity.setThickness(thickness);
        processOpportunity.selectWidht(width);
        processOpportunity.saveOpportunity();
    }
    @Given("the user processes the opportunity with delivery type {string}, address {string}, delivery time {string}, special message {string}, advance {string}, seller {string}, source seller type {string}, and cost {string}")
    public void the_user_processes_the_opportunity_with_delivery_type_address_delivery_time_special_message_advance_seller_source_seller_type_and_cost(String deliveryType, String Address, String days, String specialmessage, String advance, String seller, String source_seller_type, String costPrice) throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.editOpportunity();
        processOpportunity.editDelivery(deliveryType);
        processOpportunity.editDeliveryAdress(Address);
        processOpportunity.editDeliveryTime(days);
        processOpportunity.editSpecialMessage(specialmessage);
        opportunityPage.opportunityAdvance(advance);
        processOpportunity.searchSouceSeller(seller);
        processOpportunity.selectSourceSeller(seller);
        processOpportunity.userClicksOnSourceSellerButton();
        processOpportunity.userSelectSourceSellerType(source_seller_type);
        processOpportunity.editCostPrice(costPrice);
        processOpportunity.saveOpportunity();

    }
    @Given("the user sends the opportunity for pricing to category {string}")
    public void the_user_sends_the_opportunity_for_pricing_to_category(String category) throws InterruptedException {
        awaitingPage.clickPriceAwaiting();
        awaitingPage.categoryUserTest(category);
        awaitingPage.saveCategory();
        processOpportunity.saveOpportunity();

    }
    @Given("the user updates the customer-accepted price to {string} with category price {string} and override reason {string}")
    public void the_user_updates_the_customer_accepted_price_to_with_category_price_and_override_reason(String price, String categoryprice, String reason) throws InterruptedException {
        processOpportunity.processOpportunitybutton();
//        processOpportunity.overrideButton();
//        processOpportunity.reasonForOverride(reason);
        processOpportunity.categoryPrice(categoryprice);
        processOpportunity.customerFinalPrice(price);
        processOpportunity.saveOpportunity();
        processOpportunity.saveOpportunity();
    }
    @Given("the user requests PI to the category team {string}")
    public void the_user_requests_pi_to_the_category_team(String string) throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.saveOpportunity();
        processOpportunity.verifyPriceCustomer();
        processOpportunity.requestPItocategory();
        processOpportunity.categoryUserTest(string);
        processOpportunity.saveCategory();
        processOpportunity.saveOpportunity();

    }
    @Given("the user updates the seller PI and sets the stage to {string}")
    public void the_user_updates_the_seller_pi_and_sets_the_stage_to(String string) {
        processOpportunity.processOpportunitybutton();
        processOpportunity.saveFinalOrder();
        processOpportunity.requestPItoSeller();
        processOpportunity.saveFinalOrder();
        accountPage.filePage();
        accountPage.chooseSellerPI();
        accountPage.setSellerPi();

    }


}

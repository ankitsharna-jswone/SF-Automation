package Stepdefination.Ordercreation;

import Pages.*;
import Utils.Functionalities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static Utils.BrowsserSetup.getDriver;
import static Utils.BrowsserSetup.setDriver;

//import static Utils.BrowsserSetup.getDriver;
//import static Utils.Functionalities.setConsoleReader;

public class LoginSetupSteps {

    static WebDriver driver;
    static WebDriverWait wait;
    Actions actions;
    Functionalities func;
    LoginPage log;
    HomePage homePage;
    AccountPage accountPage;
    ProcessOpportunity processOpportunity;
    PricingAwaitingPage awaitingPage;
    String ordernumber;
    OrderPage orderPage;


    private static @NotNull String getDateTimeString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return dateFormat.format(new Date());
    }


    public static void updateOutputPaths() {
        Properties props = new Properties();
        FileInputStream in = null;
        FileOutputStream out = null;

        try {
            // Load the properties file
            in = new FileInputStream("extent.properties");
            props.load(in);

            // Get current date and time
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
            String currentDateTime = dateFormat.format(new Date());

            // Update output paths with current date and time
            props.setProperty("extent.reporter.spark.out", "test-output/html/reports/automationReport_ConstuctFlow_" + currentDateTime + ".html");
            props.setProperty("extent.reporter.html.out", "test-output/html/reports/automationHTML_ConstuctFlow_" + currentDateTime + ".html");

            // Write back to the properties file
            out = new FileOutputStream("extent.properties");
            props.store(out, null);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            // Close resources
            try {
                if (in != null) {
                    in.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }




    @Given("Set the file and driver and configuration")
    public void setup(){

        setDriver("chrome");
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

    @Given("user is at the login page and user logged in to the webiste {string}")
    public void setup(String website){
//        driver.get(website);
//        log.usernameSF("v_ankit.sharma@jsw.in");
//        log.passwordSF("@Ankit123");
//        log.loginSF();
    }

    @And("User reached homepage! {string}")
    public void userReachedHomepage(String string) {
        homePage.openSearchTab();
        homePage.searchItem(string);
        homePage.searchAccountClick(string + " accounts");
        homePage.openAccount(string);

    }

    @Given("User created opportunity and selected the product {string} and quantity {string}")
    public void userCreatedOpportunityAndSelectedTheProductAndQuantity(String product,String quantity) throws InterruptedException {
        accountPage.quickOpportunity();
        processOpportunity.addButton();
        processOpportunity.searchProduct(product);
        processOpportunity.selectProduct(product);
        processOpportunity.setQuantity(quantity);
        processOpportunity.setThickness("10");
        processOpportunity.selectWidht("1500");
        processOpportunity.saveOpportunity();
    }


    @And("User processed opportunity to set delivery type {string} in {string} and with a {string} message")
    public void userProcessedOpportunityToSalesTeamAndFilledTheRequiredDocuments(String deliveryType,String days,String specialmessage) {
        processOpportunity.processOpportunitybutton();
        processOpportunity.editOpportunity();
        processOpportunity.editDelivery(deliveryType);
        processOpportunity.editDeliveryTime(days);
        processOpportunity.editSpecialMessage(specialmessage);

    }

    @And("Category team set the {string} and the {string}")
    public void setCategoryDetials(String price,String seller) throws InterruptedException {
        processOpportunity.categoryPrice(price);
        processOpportunity.searchCoilSeller(seller);
        processOpportunity.selectCoilSeller(seller);
        processOpportunity.editCostPrice("1000");
        processOpportunity.saveOpportunity();

    }


    @And("User send the file to pricing to the Category team")
    public void userSendTheFileToPricingToTheCategoryTeam() throws InterruptedException {
        awaitingPage.clickPriceAwaiting();
        awaitingPage.categoryUserTest("category");
        awaitingPage.saveCategory();
        processOpportunity.saveOpportunity();
        System.out.println("Stage is : " + accountPage.stageOfOpportunity());

    }


    @When("User got pricing from the category then user updated the customer accepted price {string}")
    public void userGotPricingFromTheCategoryThenUserUpdatedTheCustomerAcceptedPrice(String price) throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.customerFinalPrice(price);
        processOpportunity.saveOpportunity();
        processOpportunity.verifyPriceCustomer();
        processOpportunity.saveOpportunity();
        System.out.println("Stage is : " + accountPage.stageOfOpportunity());
    }


    @And("user requested for the PI to the category team")
    public void userRequestedForThePIToTheCategoryTeam() throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.saveOpportunity();
        processOpportunity.requestPItocategory();
        processOpportunity.categoryUserTest("Category");
        processOpportunity.saveCategory();
        processOpportunity.saveOpportunity();
        System.out.println("Stage is : " + accountPage.stageOfOpportunity());
        processOpportunity.processOpportunitybutton();
        processOpportunity.saveOpportunity();
        processOpportunity.requestPItoSeller();
        processOpportunity.saveFinalOrder();

    }


    @Then("User updated the sellerPI to and sent that to the seller")
    public void userUpdatedTheSellerPIToAndSentThatToTheSeller() throws InterruptedException {
        accountPage.filePage();
        accountPage.chooseSellerPI();
        accountPage.setSellerPi();
        System.out.println("Stage is : " + accountPage.stageOfOpportunity()) ;

    }


    @And("Created the Order")
    public void createdTheOrder() {
        accountPage.createOrderButton();
        String subtotal =  accountPage.subTotalCreateOrder();
        System.out.println(subtotal + " : total value for the order is" );
        accountPage.insideCreateButtonCoil();
        ordernumber = accountPage.captureOrderNumber();
        System.out.println(ordernumber + " : ordernumber ");
    }

    @And("Verify the opportunity created")
    public void verifyOrderCreated(){
        accountPage.OrderTab();
        accountPage.orderNumberClick(ordernumber);
        System.out.println(orderPage.getExternalOrderID() + " : external order ID");
        System.out.println(orderPage.OrderStatusAtOrderPage() +  " : order status is now! ");
        System.out.println("Registered company name is : " + orderPage.GetRegisteredCompanyName());
//        System.out.println("OMS link for the order is" +  orderPage.OMSorderLink());
        System.out.println("Order payemebt : " + orderPage.GetOrderPayment());
//        System.out.println("Paid amount is : " + orderPage.GetPaidAmount());
//        System.out.println("Due amount is : " + orderPage.GetPaymentDueAmount());
        System.out.println("Payment status : " + orderPage.GetPaymentStatus());
        System.out.println("Opportunity Name : " + orderPage.OpportunityOftheOrder());
    }


    @And("Check Order summary is present or not")
    public void  checkOrderSummary(){
        driver.navigate().back();
        accountPage.filePage();
        boolean flag = accountPage.checkFIle("System_OS", accountPage.filesList());
        System.out.println("The summary is present ? : " + flag );
    }


}

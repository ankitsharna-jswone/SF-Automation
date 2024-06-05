package Stepdefination.Ordercreation;

import Pages.AccountPage;
import Pages.OpportunityPage;
import Pages.OrderPage;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.en.*;
import org.jetbrains.annotations.NotNull;

import java.text.SimpleDateFormat;
import java.util.Date;

import static Utils.BrowsserSetup.getDriver;

public class CreateOrderPageSteps {

    AccountPage accountPage = new AccountPage(getDriver());
    OpportunityPage opportunityPage = new OpportunityPage(getDriver());
    static String ordernumber;
    String subtotal;

    @Given("the user is on the account page for order creation")
    public void userIsOnAccountPage() {
        System.out.println("User at account page");
        getDriver().navigate().refresh();
    }

    @Given("User approves the approval history")
    public void editHistoryApproval(){
        opportunityPage.ApporvalHistoryEditBUtton();

    }

    @Given("User approves the credit pricing approval")
    public void creditPricingApproval(){
        opportunityPage.CreditPricingEditButton();
        opportunityPage.CreditPriceApporvalDrop();
        opportunityPage.CreditPriceApporved();
        opportunityPage.opportunitySave();

    }

    @When("the user clicks on the create order button")
    public void userClicksOnCreateOrderButton() {
        accountPage.createOrderButton();

    }


    @When("the user clicks on next for creation order")
    public void nextButtonClick(){
        accountPage.nextButtonPlant();
    }

    @When("the user captures the subtotal for the order")
    public void userCapturesSubtotalForOrder() {
        subtotal =  accountPage.subTotalCreateOrder();
    }

    @Then("the user prints the subtotal and indicates it as the total value for the order")
    public void userPrintsSubtotal() {
        System.out.println(subtotal + " : total value for the order is" );
    }

    @When("the user clicks on the button to create an order for coils")
    public void userClicksOnCreateOrderButtonForCoils() {
        accountPage.insideCreateButtonCoil();
    }

    @When("the user captures the order number")
    public void userCapturesOrderNumber() {
        ordernumber = accountPage.captureOrderNumber();
    }

    @Then("the user prints the order number")
    public void userPrintsOrderNumber() {
        System.out.println(ordernumber + " : ordernumber ");
    }

    private static @NotNull String getDateTimeString() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
        return dateFormat.format(new Date());
    }

    @Then("the date and time of the report is given")
    public void reportTime(){
        String dateTimeString = getDateTimeString();
        System.out.println(dateTimeString);
        String sparkReportPath = "test-output/html/reports/automationReport_ConstuctFlow_" + dateTimeString + ".html";
        String htmlReportPath = "test-output/html/reports/automationHTML_ConstuctFlow_" + dateTimeString + ".html";
        String pdfReportPath = "test-output/reports/reportPDF_ConstuctFlow_" + dateTimeString + ".pdf";

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(sparkReportPath);
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(htmlReportPath);
//        ExtentPdfReporter pdfReporter = new ExtentPdfReporter(pdfReportPath);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(sparkReporter, htmlReporter);
    }
}

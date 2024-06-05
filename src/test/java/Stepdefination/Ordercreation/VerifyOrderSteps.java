package Stepdefination.Ordercreation;

import Pages.AccountPage;
import Pages.OrderPage;
import io.cucumber.java.en.*;

import static Stepdefination.Ordercreation.CreateOrderPageSteps.ordernumber;
import static Utils.BrowsserSetup.getDriver;

public class VerifyOrderSteps {

   AccountPage accountPage = new AccountPage(getDriver());
   OrderPage orderPage = new OrderPage(getDriver());

    @Given("the user clicks on the order tab")
    public void userClicksOnOrderTab() {
        accountPage.OrderTab();

    }

    @And("the user clicks on the order number")
    public void userClicksOnOrderNumber() {
        accountPage.orderNumberClick(ordernumber);
    }

    @Then("the user prints the external order ID")
    public void userPrintsExternalOrderID() {
        System.out.println(orderPage.getExternalOrderID() + " : external order ID");

    }

    @Then("the user prints the order status")
    public void userPrintsOrderStatus() {
        System.out.println(orderPage.OrderStatusAtOrderPage() +  " : order status is now! ");

    }

    @Then("the user prints the registered company name")
    public void userPrintsRegisteredCompanyName() {
        // Implementation to print the registered company name
        System.out.println("Registered company name is : " + orderPage.GetRegisteredCompanyName());
//        System.out.println("OMS link for the order is" +  orderPage.OMSorderLink());

    }

    @Then("the user prints the order payment")
    public void userPrintsOrderPayment() {
        // Implementation to print the order payment
        System.out.println("Order payemebt : " + orderPage.GetOrderPayment());
//        System.out.println("Paid amount is : " + orderPage.GetPaidAmount());
//        System.out.println("Due amount is : " + orderPage.GetPaymentDueAmount());

    }

    @Then("the user prints the payment status")
    public void userPrintsPaymentStatus() {
        // Implementation to print the payment status
        System.out.println("Payment status : " + orderPage.GetPaymentStatus());

    }

    @Then("the user prints the opportunity name")
    public void userPrintsOpportunityName() {
        // Implementation to print the opportunity name
        System.out.println("Opportunity Name : " + orderPage.OpportunityOftheOrder());
    }
}

package Pages;

import org.openqa.selenium.WebDriver;
import static Utils.Functionalities.*;

public class OrderPage {
    WebDriver driver;
    public OrderPage(WebDriver driver){
        this.driver = driver;

    }

    public String OrderStatusAtOrderPage(){
        waitLocatedXpath("//dt[.//span[text()='Order Status']]/following-sibling::dd//span//slot//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Order Status']]/following-sibling::dd//span//slot//lightning-formatted-text").getText();
    }

    public String GetRegisteredCompanyName(){
        waitLocatedXpath("//dt[.//div[@class='test-id__field-label-container slds-form-element__label no-utility-icon']//span[text()='Registered Company Name']]/following-sibling::dd//a//slot//span[text()]");
        return xpathELem("//dt[.//div[@class='test-id__field-label-container slds-form-element__label no-utility-icon']//span[text()='Registered Company Name']]/following-sibling::dd//a//slot//span[text()]").getText();
    }

    public String getExternalOrderID(){
        waitLocatedXpath("//dt[.//span[text()='Order External Id']]/following-sibling::dd//span//slot//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Order External Id']]/following-sibling::dd//span//slot//lightning-formatted-text").getText();
    }

    public String OMSorderLink(){
        waitLocatedXpath("//dt[.//span[text()='OMS Order Link']]/following-sibling::dd//a");
        return xpathELem("//dt[.//span[text()='OMS Order Link']]/following-sibling::dd//a").getText();
    }

    public String GetPaymentStatus(){
        waitLocatedXpath("//dt[.//span[text()='Payment Status']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Payment Status']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String GetPaymentDueAmount(){
        waitLocatedXpath("//dt[.//span[text()='Payment Amount Due']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Payment Amount Due']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String GetPaidAmount(){
        waitLocatedXpath("//dt[.//span[text()='Paid Amount']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Paid Amount']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String GetOrderPayment(){
        waitLocatedXpath("//dt[.//span[text()='Order Amount']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Order Amount']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String OpportunityOftheOrder(){
        waitLocatedXpath("//dt[.//span[text()='Opportunity']]/following-sibling::dd//slot//span[@lwc-47ngqe6rvah]");
        return xpathELem("//dt[.//span[text()='Opportunity']]/following-sibling::dd//slot//span[@lwc-47ngqe6rvah]").getText();
    }




}

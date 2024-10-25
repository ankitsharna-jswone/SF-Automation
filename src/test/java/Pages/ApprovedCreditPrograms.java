package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static Utils.BrowsserSetup.*;
import static Utils.Functionalities.*;

public class ApprovedCreditPrograms {

    WebDriver driver = getDriver();

    public List<String> CreditProgramName(){
        waitLocatedXpath("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText']");
        List<WebElement> CreditPrograms =  xpathELems("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText']");

        List<String> CreditProgramsNames  = new ArrayList<>();

        for(WebElement element : CreditPrograms){
            CreditProgramsNames.add(element.getText());
        }

        return CreditProgramsNames;
    }


    public String UsableLimitAmount(String CreditName){
        waitLocatedXpath("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='"+ CreditName  +"']" +
                "/following-sibling::div[@c-approvedcreditprogram_approvedcreditprogram]" +
                "/lightning-formatted-number[@c-approvedcreditprogram_approvedcreditprogram ]");
        return xpathELem("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='"+ CreditName  +"']" +
                "/following-sibling::div[@c-approvedcreditprogram_approvedcreditprogram]" +
                "/lightning-formatted-number[@c-approvedcreditprogram_approvedcreditprogram ]").getText();
    }

    public String SanctionedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()=' Sanctioned']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()=' Sanctioned']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String UtilisedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Utilised']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Utilised']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String AvailableAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Available']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Available']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String BlockedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Blocked']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Blocked']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String UsableAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Usable']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Usable']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String CreditExpiryDate(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Expires on']/following-sibling::td//lightning-formatted-date-time");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Expires on']/following-sibling::td//lightning-formatted-date-time").getText();
    }

    public String CreditDueDays(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td").getText();
    }

    public String PenalRate(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Penal Rate']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td").getText();
    }

    public String CreditLimitBlock(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block']/following-sibling::td").getText();
    }

    public String CreditLimitBlockReason(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block Reason']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block Reason']/following-sibling::td").getText();
    }


}

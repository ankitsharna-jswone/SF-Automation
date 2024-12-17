package Pages;

import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import javax.xml.transform.Source;

import static Utils.BrowsserSetup.*;
import static Utils.Functionalities.*;
import static Utils.Functionalities.JavaScriptScroll;

public class OpportunityCreditPage {

    WebDriver driver = getDriver();



    public String CreditRequired(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));
        waitLocatedXpath("//dt[.//span[text()='Credit Requirement']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Credit Requirement']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String CreditProgramName(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Credit Program Name']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Credit Program Name']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String CreditProgramType(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Credit Type']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Credit Type']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String PenalInterest(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Penal Interest']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Penal Interest']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String ApprovedCreditDays(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Approved credit days']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Approved credit days']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String CreditProgramPan(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Credit Program PAN']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Credit Program PAN']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String CreditExpiryDate(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Expiration date of credit']]/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt[.//span[text()='Expiration date of credit']]/following-sibling::dd//lightning-formatted-text").getText();
    }

    public String CreditAmount(){

        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));


        waitLocatedXpath("//dt[.//span[text()='Credit Amount']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Credit Amount']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String CreditAvialable(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));
        waitLocatedXpath("//dt[.//span[text()='Credit Available']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Credit Available']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String BlockedLimiit(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Blocked Limit']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Blocked Limit']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String CreditUtilised(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Credit utilised']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Credit utilised']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String CreditDays(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Credit Days']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Credit Days']]/following-sibling::dd//lightning-formatted-number").getText();
    }

    public String SanctionedLimit(){
        JavaScriptScroll(xpathELem("//flexipage-component2//h3[.//span[text()='Credit Requirement']]"));

        waitLocatedXpath("//dt[.//span[text()='Sanctioned Limit']]/following-sibling::dd//lightning-formatted-number");
        return xpathELem("//dt[.//span[text()='Credit Days']]/following-sibling::dd//lightning-formatted-number").getText();
    }



}

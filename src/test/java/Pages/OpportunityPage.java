package Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.Functionalities.*;
import static Utils.Functionalities.JavaScriptClick;

public class OpportunityPage {
    WebDriver driver;

    public OpportunityPage(WebDriver driver){
        this.driver = driver;
    }


    static StringBuilder OpportunityNumber = new StringBuilder("");

    public void setOpportunityNumber() {
        System.out.println(xpathELem("//lightning-formatted-text[contains(text(), 'OP') and @slot='primaryField']").getText());

        OpportunityNumber = new StringBuilder(xpathELem("//lightning-formatted-text[contains(text(), 'OP') and @slot='primaryField']").getText());
    }

    public StringBuilder getOpportunityName() {
        return OpportunityNumber;
    }

    public void acceptAllskus(){
        waitLocatedXpath("//button[text()='Accept all SKUs']");
        clickingTool(xpathELem("//button[text()='Accept all SKUs']"));

    }

    public void acceptAllSkuproceed(){
        waitLocatedXpath("//button[text()='Proceed']");
        clickingTool(xpathELem("//button[text()='Proceed']"));
        wait.until(ExpectedConditions.invisibilityOf(xpathELem("//h2[text()='Accept all SKUs']")));
    }

    public void editTDCButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,450)", "");
        waitLocatedXpath("//button[./span[text()='Edit TDC uploaded']]");

        clickingTool(xpathELem("//button[./span[text()='Edit TDC uploaded']]"));
    }

    public void handoverToCategoryButton(){
        waitLocatedXpath("//button[text()='Handover to Category']");
        clickingTool(xpathELem("//button[text()='Handover to Category']"));
    }

    public void searchCategory(String category){
        waitLocatedXpath("//input[@placeholder='Search People...']");
        xpathELem("//input[@placeholder='Search People...']").sendKeys(category);

        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title='"+category +"']");
        clickingTool(xpathELem("//lightning-base-combobox-formatted-text[@title='"+category +"']"));
    }

    public void selectCategoryUser(String category){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title='"+category +"']");
        clickingTool(xpathELem("//lightning-base-combobox-formatted-text[@title='"+category +"']"));
    }

    public void nextButton(){
        waitLocatedXpath("//button[text()='Next']");
        clickingTool(xpathELem("//button[text()='Next']"));
    }


    public void CreditPriceApporvalDrop(){
        waitLocatedXpath("//button[@aria-label='Credit pricing approval status']");
        clickingTool(xpathELem("//button[@aria-label='Credit pricing approval status']"));
    }

    public void CreditPriceApporved(){
        waitLocatedXpath("//span[text()='Approved' and @lwc-4kb6kaqheak]");
        clickingTool(xpathELem("//span[text()='Approved' and @lwc-4kb6kaqheak]"));
    }
    public void TdcUploadcheckBox(){

//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name ='TDC_uploaded__c']")));
        JavaScriptClick("//input[@name ='TDC_uploaded__c']");
    }
    public void CreditPricingEditButton(){
        JavaScriptClick("//button[@title='Edit Credit pricing approval status']");
    }

    public void ApporvalHistoryEditBUtton(){
        waitLocatedXpath("//span[text()='Show actions for Stage History']");
        clickingTool(xpathELem("//span[text()='Show actions for Stage History']"));
    }

    public void PopUploadCheckBox(){
//        waitLocatedXpath("//input[@name ='PO_Uploaded__c']");
        JavaScriptClick("//input[@name ='PO_Uploaded__c']");
    }

    public void TDCsent2Customer(){
        JavaScriptClick("//input[@name ='TDC_Sent_to_Customer__c']");
    }

    public void TDCsent2Plant(){
        JavaScriptClick("//input[@name ='TDC_Sent_to_Plant__c']");
    }

    public void TDC_valdition(){
        JavaScriptClick("//input[@name ='TDC_Validation__c']");
    }

    public void SupplyFeasibalityDropdwon(){
        waitLocatedXpath("//button[@aria-label = 'Supply Feasibility']");
        clickingTool(xpathELem("//button[@aria-label = 'Supply Feasibility']"));
    }

    public void selectYesResponse (){
        waitLocatedXpath("//span[text()='Yes']");
        JavaScriptClick("//span[text()='Yes']");
    }



    public void opportunitySave(){
        clickingTool(xpathELem("//button[text()='Save']"));
    }


    public void opportunityAdvance(String  string){
        waitLocatedXpath("//input[@name ='Advance__c']");
        xpathELem("//input[@name ='Advance__c']").sendKeys(string);
    }

    public void selectCreditButton(){
        waitLocatedXpath("//button[@name='Opportunity.Select_credit']");
        clickingTool(xpathELem("//button[@name='Opportunity.Select_credit']"));
    }

    public void creditRequiredTrue(){
        waitLocatedXpath("//button[@name='Credit_requirement__c']");
        clickingTool(xpathELem("//button[@name='Credit_requirement__c']"));
        waitLocatedXpath("//span[text()='Required']");
        clickingTool(xpathELem("//span[text()='Required']"));
    }


    public void userSelectCreditProgramButton(){
        waitLocatedXpath("//button[@name='Credit_Program_Type__c']");
        clickingTool(xpathELem("//button[@name='Credit_Program_Type__c']"));
    }

    public void userSelectCreditProgramType(String credt){
        waitLocatedXpath("//span[contains(@title,'"+credt+"')]");
        clickingTool(xpathELem("//span[contains(@title,'"+credt+"')]"));
    }

    public void userFillsCreditDays(String days){

        xpathELem("//input[@name='Credit_Days__c']").clear();
        xpathELem("//input[@name='Credit_Days__c']").sendKeys(days);
    }

    public void userSelectsAdvacncePercentage(String advance){
        xpathELem("//input[@name='Advance__c']").clear();
        xpathELem("//input[@name='Advance__c']").sendKeys(advance);
    }

    public void userSavesCreditProgram(){
//        waitLocatedXpath("//button[text()='Save'and @style]");
        clickingTool(xpathELem("(//button[text()='Save'])[2]"));
    }



}

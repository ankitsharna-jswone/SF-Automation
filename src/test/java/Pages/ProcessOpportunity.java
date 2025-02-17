package Pages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en_old.Ac;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;

public class ProcessOpportunity {
    WebDriver driver;
    public  ProcessOpportunity(WebDriver driver){
        this.driver = driver;
    }

    public void searchProduct(String text){
        waitLocatedXpath("//input[@placeholder ='Search Products...']");
        xpathELem("//input[@placeholder ='Search Products...']").sendKeys(text);
    }

    public void selectProduct(String text){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title='"+text+"']");
        xpathELem("//lightning-base-combobox-formatted-text[@title='"+text+"']").click();
    }

    public void setQuantity(String quantity){
        waitLocatedXpath("//input[@name ='Primary Revised Quantity']");
        xpathELem("//input[@name ='Primary Revised Quantity']").sendKeys(quantity);
    }


    public void chooseColour(String colour) {
        waitLocatedXpath("//button[@aria-label='Paint Colour']");
        clickingTool(xpathELem("//button[@aria-label='Paint Colour']"));

        waitLocatedXpath("//lightning-base-combobox-item[@data-value='Grey']");

        clickingTool(xpathELem("//lightning-base-combobox-item[@data-value='" + colour +"']"));

    }

    public void creditDays(String days){
        xpathELem("//input[@name='Credit_Days__c']").clear();
        xpathELem("//input[@name='Credit_Days__c']").sendKeys(days);
    }


    public void creditRequired(){
        waitLocatedXpath("//button[@name='Credit_requirement__c']");
        clickingTool(xpathELem("//button[@name='Credit_requirement__c']"));
    }

    public void creditRequiredYes(){
        waitLocatedXpath("//lightning-base-combobox-item[@data-value='Required']");
        clickingTool(xpathELem("//lightning-base-combobox-item[@data-value='Required']"));
    }

    public void creditProgramType(){
        waitLocatedXpath("//button[@aria-label='Credit Program Type']");
        clickingTool(xpathELem("//button[@aria-label='Credit Program Type']"));
    }



    public void selectCreditProgram(String credit){
//        clickingTool(xpathELem("//span[contains(text(), '"+credit+ "')]"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Credit Program Type']")));
        wait.until(ExpectedConditions.presenceOfElementLocated( By.xpath("//span[contains(text(), '" + credit + "')]")));
        clickingTool(xpathELem("//span[contains(text(), '" + credit + "')]"));

    }

    public void setThickness(String thickness){
        waitLocatedXpath("//input[@name ='Thickness (mm)']");
        xpathELem("//input[@name ='Thickness (mm)']").sendKeys(thickness);
    }

    public void fillWidth(String wid){
        waitLocatedXpath("//input[@name='Width (mm)']");
        xpathELem("//input[@name='Width (mm)']").sendKeys(wid);
    }

    public void selectWidht(String wid){
        int width = Integer.parseInt(wid);

        if(width == 1250){
           JavaElemClick(xpathELem("//span[text() ='1250']"));
        }
        else if (width == 1500){
           JavaElemClick(xpathELem("//span[text() ='1500']"));
        }
        else{
           JavaElemClick(xpathELem("//span[text() ='Non-Standard']"));
        }


    }


    public void addButton(){
        //button[@title='Add']
        waitLocatedXpath("//button[@title='Add']");
        xpathELem("//button[@title='Add']").click();
    }

    public void overrideButton(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(" //input[@name='Over_ride_prices__c']")));
        clickingTool(xpathELem("//input[@name='Over_ride_prices__c']"));
    }

    public void reasonForOverride(String string){
        waitLocatedXpath("//button[@aria-label='Reason for override']");
        clickingTool(xpathELem("//button[@aria-label='Reason for override']"));
        waitLocatedXpath("//span[@title='" + string +"']");
        clickingTool(xpathELem("//span[@title='" + string +"']"));

    }



    public void processOpportunitybutton(){
        //process opportunity
        waitLocatedXpath("//button[text()='Process Opportunity']");
        clickingTool(xpathELem("//button[text()='Process Opportunity']"));
    }

    public void editOpportunity(){
        waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));
        List<WebElement> buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
        WebElement editOpportunity = buttons.get(0);
        clickingTool(editOpportunity);
    }

    public void editDelivery(String type){
        //Delivery Instructions
        xpathELem("//button[@aria-label ='Delivery Instructions']").click();
        waitLocatedXpath("//lightning-base-combobox-item[@data-value='Self pickup']");
        if(type.equals("JOTS")){
            xpathELem("//lightning-base-combobox-item[@data-value='3PL']").click();
        }
        else{
            xpathELem("//lightning-base-combobox-item[@data-value='" + type + "']").click();
        }

    }


    public void editDeliveryAdress(String address){

        String add = address.toUpperCase();

        xpathELem("//input[@placeholder='Search Addresses...']").sendKeys(add);
//        xpathELem("//label[@class='slds-form-element__label' and text()= 'Delivery Address']/following-sibling::div//input").sendKeys(address);

//        waitLocatedXpath("//span[@class='slds-listbox__option-meta slds-listbox__option-meta_entity' and .//span[text()='" + address +"']]");

        clickingTool(xpathELem("//lightning-base-combobox-formatted-text[contains(@title,'" + add +"')]"));
    }



    public void editDeliveryTime(String day){
        //Delivery Time
        clickingTool(xpathELem("//button[@name ='Delivery_timeline__c']"));
        waitLocatedXpath("//lightning-base-combobox-item[@data-value ='3 days']");
        xpathELem("//lightning-base-combobox-item[@data-value ='"+ day + " days']").click();
    }

    public void editSpecialMessage(String message){
        //Special message
        waitLocatedXpath("//input[@required and @name ='TDC_PO__c']");
        xpathELem("//input[@required and @name ='TDC_PO__c']").sendKeys(message);
    }

    public void categoryPrice(String price){
        //category price
        waitLocatedXpath("//input[@name ='Category_Price__c']");
        xpathELem("//input[@name ='Category_Price__c']").sendKeys(price);
    }

    public void selectSeller(String seller){
        //Seller( JODL )
        waitLocatedXpath("//input[@placeholder = 'Search Accounts...']");
        xpathELem("//input[@placeholder = 'Search Accounts...']").sendKeys( seller); //JSW
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title ='JSW One Distribution Limited - KA (JODL)']");
        xpathELem("//lightning-base-combobox-formatted-text[@title ='JSW One Distribution Limited - KA (JODL)']").click();
    }

    public void pricingAwaited(){
        waitLocatedXpath("//button[text()='Pricing Awaited']");
        clickingTool(xpathELem("//button[text()='Pricing Awaited']"));
    }

    public void editCostPrice(String price){
        //cost price
        waitLocatedXpath("//input[@name ='Source_Seller_Quote__c']");
        xpathELem("//input[@name ='Source_Seller_Quote__c']").sendKeys(price);
    }

    public void saveOpportunity() throws InterruptedException {
        //save

        waitLocatedXpath("//button[text()='Save' and @title]");

        Actions actions = new Actions(driver);
        waitForElement("//button[text()='Save' and @title]");
        WebElement save = xpathELem("//button[text()='Save' and @title]");
        actions.scrollToElement(save).build().perform();
        clickingTool(save);
        Thread.sleep(1000);

    }


    public void editCustomerButton(){
        waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));

        List<WebElement> buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
        WebElement editOpportunity = buttons.get(2);
        clickingTool(editOpportunity);
    }

    public void searchCoilSeller(String seller){
        waitLocatedXpath("//label[text()='Source Seller Name']/following-sibling::div//input");
        xpathELem("//label[text()='Source Seller Name']/following-sibling::div//input").sendKeys(seller);
    }

    public void searchSouceSeller(String seller){
        waitLocatedXpath("//label[text()='Source Seller Name']/following-sibling::div//input");
        clickingTool(xpathELem("//label[text()='Source Seller Name']/following-sibling::div//input"));
        xpathELem("//label[text()='Source Seller Name']/following-sibling::div//input").sendKeys(seller);
        clickingTool(xpathELem("//label[text()='Source Seller Name']/following-sibling::div//input"));
    }

    public void searchSeller(String seller){
        waitLocatedXpath("//label[text()='Seller Name']/following-sibling::div//input");
        xpathELem("//label[text()='Seller Name']/following-sibling::div//input").sendKeys(seller);
    }

    public void userClicksOnSourceSellerButton(){
        clickingTool(xpathELem("//button[@name='Source_Seller_Type__c']"));
    }
    public void userSelectSourceSellerType(String SellerType){
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Source Seller Type']")));
        clickingTool(xpathELem("//span [ @lwc-7co8ha3nedg and ./span[ text()='" + SellerType +"']  ]"));
        //span [ @lwc-7co8ha3nedg and ./span[ text()='Marketplace']]
    }

    public void selectSourceSeller(String seller){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = '" + seller +"']");
        xpathELem("//lightning-base-combobox-formatted-text[@title = '" + seller +"']").click();
    }

    public void SelectSeller(String seller){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = '" + seller +"']");
        xpathELem("//lightning-base-combobox-formatted-text[@title = '" + seller +"']").click();
    }
    public void selectPlantSeller(String seller){
        waitLocatedXpath("(//lightning-base-combobox-formatted-text[@title = '" + seller +"'])[2]");
        xpathELem("(//lightning-base-combobox-formatted-text[@title = '" + seller + "'])[2]").click();
    }

    public void selectCoilSeller(String seller){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = '" + seller +"']");
        xpathELem("//lightning-base-combobox-formatted-text[@title = '" + seller +"']").click();
    }

    public void customerFinalPrice(String price){
        waitLocatedXpath("//input[@name ='Final_Distributor_Quote__c']");
        xpathELem("//input[@name ='Final_Distributor_Quote__c']").clear();
        xpathELem("//input[@name ='Final_Distributor_Quote__c']").sendKeys(price);

    }

    public void saveCustomer(){
        waitLocatedXpath("//button[text()='Save']");
        Actions actions = new Actions(driver);
        actions.scrollToElement(xpathELem("//button[text()='Save']")).build().perform();
        clickingTool(xpathELem("//button[text()='Save']"));
    }

    public void verifyPriceCustomer() throws InterruptedException {

//        wait.until(ExpectedConditions.stalenessOf(xpathELem("//button[text()='Verify Prices']")));
//        WebElement verifyPrice = xpathELem("//button[text()='Verify Prices']");1
        waitForElement("//div[@class='customButtonPosition']//button[text()='Verify Prices']");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='customButtonPosition']//button[text()='Verify Prices']")));
        clickingTool(xpathELem("//div[@class='customButtonPosition']//button[text()='Verify Prices']"));
        Thread.sleep(1000);

//        waitLocatedXpath("//button[text()='Move to awaiting documents']");

    }

    public void requestPItocategory(){
        waitLocatedXpath("//button[text()='Request PI to Category']");
        WebElement RequestPI = xpathELem("//button[text()='Request PI to Category']");
        clickingTool(RequestPI);
    }

    public void categoryUserTest( String categoryUser){
        waitLocatedXpath("//input[@placeholder='Search People...']");

        clickingTool(xpathELem("//input[@placeholder='Search People...']"));
        xpathELem("//input[@placeholder='Search People...']").sendKeys(categoryUser);


        clickingTool(xpathELem("//input[@placeholder='Search People...']"));

        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = '" + categoryUser +"']");
        WebElement category = xpathELem("//lightning-base-combobox-formatted-text[@title = '" + categoryUser  +"']");
        clickingTool(category);
    }


    public void saveCategory(){
        WebElement Catsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//footer//button[text()='Save' and @class = 'slds-button slds-button_brand' and @title = 'Primary action']")));
        clickingTool(Catsave);

    }

    public void requestPItoSeller(){
        waitLocatedXpath("//button[text()='Request PI to Seller']");
        WebElement requestPI = xpathELem("//button[text()='Request PI to Seller']");
        clickingTool(requestPI);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='toastMessage forceActionsText' and text()='Email sent to Seller successfully']")));
//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//span[@class='toastMessage forceActionsText' and text()='Email sent to Seller successfully']")));

    }

    public void greenMessage(String string){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class = 'slds-assistive-text' and text()='" + string + "']")));
    }


    public void saveFinalOrder(){
        waitLocatedXpath("//div[@class ='customButtonPosition']//button[text()='Save']");
        WebElement save = xpathELem("//div[@class ='customButtonPosition']//button[text()='Save']");
        clickingTool(save);
    }
}

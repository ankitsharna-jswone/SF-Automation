package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

import static Utils.Functionalities.*;
import static Utils.Functionalities.clickingTool;

public class MultiProcessOpportunitypage {
        WebDriver driver;
        public  MultiProcessOpportunitypage(WebDriver driver){
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

        public void setThickness(String thickness){
            waitLocatedXpath("//input[@name ='Thickness (mm)']");
            xpathELem("//input[@name ='Thickness (mm)']").sendKeys(thickness);
        }

        public void selectWidht(String wid){
            int width = Integer.parseInt(wid);
            if(width == 1250){
                xpathELem("//span[text() ='1250']").click();
            }
            else if (width == 1500){
                xpathELem("//span[text() ='1500']").click();
            }
            else{
                xpathELem("//span[text() ='Non-Standard']").click();
            }
        }


        public void addButton(){
            //button[@title='Add']
            waitLocatedXpath("//button[@title='Add']");
            xpathELem("//button[@title='Add']").click();
        }

        public void processOpportunitybutton(){
            //process opportunity
            waitLocatedXpath("//button[text()='Process Opportunity']");
            xpathELem("//button[text()='Process Opportunity']").click();
        }



        public void editDelivery(String type){
            //Delivery Instructions
            xpathELem("//button[@aria-label ='Delivery Instructions - Current Selection: Select Delivery Instructions']").click();
            waitLocatedXpath("//lightning-base-combobox-item[@data-value='Self pickup']");
            xpathELem("//lightning-base-combobox-item[@data-value='" + type + "']").click(); // Self pickup
        }


        public void editDeliveryTime(String day){
            //Delivery Time
            xpathELem("//button[@name ='Delivery_timeline__c']").click();
            waitLocatedXpath("//lightning-base-combobox-item[@data-value ='3 days']");
            xpathELem("//lightning-base-combobox-item[@data-value ='"+ day + " days']").click();
        }

        public void editSpecialMessage(String message){
            //Special message
            waitLocatedXpath("//input[@required and @name ='TDC_PO__c']");
            xpathELem("//input[@required and @name ='TDC_PO__c']").sendKeys(message);
        }

        public void categoryPrices(String price,int index){

            waitLocatedXpaths("//input[@name ='Category_Price__c']");
            xpathELems("//input[@name ='Category_Price__c']").get(index).sendKeys(price);
        }

        public void selectSourceSellers(String seller,int index,int selindex) throws InterruptedException {
            //Seller( JODL )
            waitLocatedXpaths("//label[@class='slds-form-element__label' and text()= 'Source Seller Name']/following-sibling::div//input");
            xpathELems("//label[@class='slds-form-element__label' and text()= 'Source Seller Name']/following-sibling::div//input").get(index).sendKeys( seller); //JSW

            List<WebElement> sellers = xpathELems("//lightning-base-combobox-formatted-text[@title ='" + seller +"']");
            System.out.println(sellers.size() + " seller size is this ");
            System.out.println(selindex + " seller index is this");
            clickingTool(xpathELems("//lightning-base-combobox-formatted-text[@title ='" + seller +"']").get(selindex));
            Thread.sleep(2000);

        }

        public void selectSellers(String seller,int index) throws InterruptedException {
            waitLocatedXpaths("//label[@class='slds-form-element__label' and text()= 'Seller Name']/following-sibling::div//input");
            xpathELems("//label[@class='slds-form-element__label' and text()= 'Seller Name']/following-sibling::div//input").get(index*2).sendKeys( seller); //JSW

            waitLocatedXpaths("(//lightning-base-combobox-formatted-text[@title ='" + seller +"']");
            Thread.sleep(1000);
            List<WebElement> sellers = xpathELems("//lightning-base-combobox-formatted-text[@title ='" + seller +"']");
            clickingTool(xpathELems("//lightning-base-combobox-formatted-text[@title ='" + seller +"']").get(sellers.size()-1));
        }

        public void editCostPrices(String price,int index){
            //cost price
            waitLocatedXpaths("//input[@name ='Source_Seller_Quote__c']");
            xpathELems("//input[@name ='Source_Seller_Quote__c']").get(index).sendKeys(price);
        }

        public void selectColour(String colour,int index){
            waitLocatedXpaths("//button[@name='Paint_Colour__c']");
            clickingTool(xpathELems("//button[@name='Paint_Colour__c']").get(index));


            clickingTool(xpathELems("//lightning-base-combobox-item[@data-value='"+ colour +"']").get(index));



        }

        public void saveOpportunity(){
            //save
            waitLocatedXpath("//button[text()='Save' and @title]");
            WebElement save = xpathELem("//button[text()='Save' and @title]");
            clickingTool(save);
        }


        public void editCustomerButton(){
            waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));

            List<WebElement> buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
            WebElement editOpportunity = buttons.get(2);
            clickingTool(editOpportunity);
        }

        public void searchCoilSeller(String seller){
            waitLocatedXpath("//input[@placeholder = 'Search Accounts...']");
            xpathELem("//input[@placeholder = 'Search Accounts...']").sendKeys(seller);
        }
        public void selectCoilSeller(String seller){
            waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = '" + seller +"']");
            xpathELem("//lightning-base-combobox-formatted-text[@title = '" + seller +"']").click();
        }

        public void customerFinalPrices(String price,int ind){
            waitLocatedXpaths("//input[@name ='Final_Distributor_Quote__c']");
            xpathELems("//input[@name ='Final_Distributor_Quote__c']").get(ind).sendKeys(price);

        }

        public void saveCustomer(){
            waitLocatedXpath("//button[text()='Save']");
            Actions actions = new Actions(driver);
            actions.scrollToElement(xpathELem("//button[text()='Save']")).build().perform();
            clickingTool(xpathELem("//button[text()='Save']"));
        }

        public void verifyPriceCustomer(){
            waitLocatedXpath("//button[text()='Verify Prices']");
            WebElement verifyPrice = xpathELem("//button[text()='Verify Prices']");
            clickingTool(verifyPrice);
        }

        public void requestPItocategory(){
            waitLocatedXpath("//button[text()='Request PI to Category']");
            WebElement RequestPI = xpathELem("//button[text()='Request PI to Category']");
            clickingTool(RequestPI);

        }

        public List<String> getProductsNames(){
            waitLocatedXpaths("//label[@class='slds-form-element__label' and text()= 'Product']/following-sibling::div//input[@class='slds-combobox__input slds-input slds-combobox__input-value']");
            List<WebElement> namesELem = xpathELems("//label[@class='slds-form-element__label' and text()= 'Product']/following-sibling::div//input[@class='slds-combobox__input slds-input slds-combobox__input-value']");
            List<String> names = new ArrayList<>();
            for (WebElement n : namesELem){
                 names.add(n.getAttribute("placeholder"));
//                System.out.println(n.getAttribute("placeholder"));
            }
            return names;
        }

        public void categoryUserTest(){
            waitLocatedXpath("//input[@placeholder='Search People...']");

            clickingTool(xpathELem("//input[@placeholder='Search People...']"));
            xpathELem("//input[@placeholder='Search People...']").sendKeys("Category Test user");


            clickingTool(xpathELem("//input[@placeholder='Search People...']"));

            waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
            WebElement category = xpathELem("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
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
        }


        public void saveFinalOrder(){
            WebElement save = xpathELem("//button[text()='Save' and @title]");
            clickingTool(save);
        }
    }


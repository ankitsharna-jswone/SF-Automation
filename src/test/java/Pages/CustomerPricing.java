package Pages;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static Utils.Functionalities.*;

public class CustomerPricing {
    WebDriver driver;
    WebDriverWait wait;
    public CustomerPricing(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public void editCustomerButton(){
        waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));

        List<WebElement> buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
        WebElement editOpportunity = buttons.get(2);
        clickingTool(editOpportunity);
    }

    public void customerFinalPrice(String price){
        waitLocatedXpath("//input[@name ='Final_Distributor_Quote__c']");
        xpathELem("//input[@name ='Final_Distributor_Quote__c']").sendKeys(price);

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
        waitLocatedXpath("//button[text()='Save']");
        WebElement save = xpathELem("//button[text()='Save']");
        clickingTool(save);
    }

}

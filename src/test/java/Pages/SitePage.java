package Pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static Utils.Functionalities.*;

public class SitePage {
    WebDriver driver;
    public SitePage(WebDriver driver){
        this.driver =driver;
    }

    public void quickOpportunity(){
        String quickOpportunity = "//button[@name = 'MSME_Construct_Site__c.Quick_Opportunity_aura']";
        waitLocatedXpath(quickOpportunity);
        xpathELem(quickOpportunity).click();
    }

    public void cementButton(){
        //cement
        waitLocatedXpath("//a[text()='Cement']");
        xpathELem("//a[text()='Cement']").click();
    }

    public void cementBrandSelect(String brand){
        //Brand Drop down
        waitLocatedXpath("//button[@name ='Cement Brand']");
        xpathELem("//button[@name ='Cement Brand']").click();
        //Select Brand
        waitLocatedXpath("//lightning-base-combobox-item[@data-value ='" + brand + "']");
        xpathELem("//lightning-base-combobox-item[@data-value ='" + brand + "']").click();
    }

    public void cementTypeAndQuantity(String type, String quantity){
        //select label
        WebElement labelElement = driver.findElement(By.xpath("//label[text()='" + type + "']")); // OPC-53
        //select quantity
        WebElement inputElement = labelElement.findElement(By.xpath("./following-sibling::div/input"));
        inputElement.sendKeys(quantity);
    }

    public void saveCementOpportunity(){
        waitLocatedXpath("//button[text()='Save']");
        clickingTool(xpathELem("//button[text()='Save']"));
    }
}

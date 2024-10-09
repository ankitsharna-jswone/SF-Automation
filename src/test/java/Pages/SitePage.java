package Pages;

import io.cucumber.java.sl.In;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.Functionalities.*;

public class SitePage {
    WebDriver driver;
    public SitePage(WebDriver driver){
        this.driver =driver;
    }

    public void quickOpportunity(){
        String quickOpportunity = "//button[@name = 'MSME_Construct_Site__c.Quick_Opportunity_Aura']";
        waitLocatedXpath(quickOpportunity);
        clickingTool(xpathELem("//button[@name = 'MSME_Construct_Site__c.Quick_Opportunity_Aura']"));

    }

    public void cementButton(){
        //cement
        waitLocatedXpath("//a[text()='Cement']");
        xpathELem("//a[text()='Cement']").click();
    }

    public void TmTButton(){
        //TMT
        waitLocatedXpath("//a[text()='TMT']");
        xpathELem("//a[text()='TMT']").click();
    }

    public void TmtSubgrade(String subgrade){
        waitLocatedXpath("//button[@name='Subgrade Type']");
        clickingTool(xpathELem("//button[@name='Subgrade Type']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Subgrade Type']")));
        clickingTool(xpathELem("//lightning-base-combobox-item[@data-value='"+ subgrade + "']"));
    }

    public void TMTWidthSelect(String widht, String quantity){
        waitLocatedXpath("//label[text()='12']/following-sibling::div/input");
        xpathELem("//label[text()='"+ widht + "']/following-sibling::div/input").sendKeys(quantity);
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

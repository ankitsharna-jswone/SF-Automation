package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.Functionalities.*;
import static Utils.Functionalities.clickingTool;

public class PricingAwaitingPage {
    WebDriver driver;
    public PricingAwaitingPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickPriceAwaiting(){
        WebElement pricingWait = xpathELem("//button[text()='Pricing Awaited']");
        waitFor(pricingWait);
        clickingTool(pricingWait);

    }

    public void categoryUserTest(){
        waitLocatedXpath("//input[@placeholder='Search People...']");

        clickingTool(xpathELem("//input[@placeholder='Search People...']"));
        xpathELem("//input[@placeholder='Search People...']").sendKeys("Category Test user");

        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
        WebElement category = xpathELem("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
        clickingTool(category);
    }


    public void saveCategory(){
        WebElement save = xpathELem("//footer//button[text()='Save' and @class = 'slds-button slds-button_brand' and @title = 'Primary action']");
        clickingTool(save);
    }

}

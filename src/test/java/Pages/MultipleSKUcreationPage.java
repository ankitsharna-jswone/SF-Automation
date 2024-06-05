package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utils.Functionalities.*;
import static Utils.Functionalities.clickingTool;


public class MultipleSKUcreationPage {
    WebDriver driver;
    public MultipleSKUcreationPage(WebDriver driver){
        this.driver = driver;
    }
    public void searchProducts(String text,int index){
        waitLocatedXpaths("//input[@placeholder ='Search Products...']");
        xpathELems("//input[@placeholder ='Search Products...']").get(index).sendKeys(text);
    }
    public void searchProduct(String text){
        waitLocatedXpath("//input[@placeholder ='Search Products...']");
        xpathELem("//input[@placeholder ='Search Products...']").sendKeys(text);
    }

    public void selectProduct(String text){
        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title='"+text+"']");
        xpathELem("//lightning-base-combobox-formatted-text[@title='"+text+"']").click();
    }

    public void setQuantity(String quantity,int index){
        waitLocatedXpaths("//input[@name ='Primary Revised Quantity']");
        xpathELems("//input[@name ='Primary Revised Quantity']").get(index).sendKeys(quantity);
    }
    public void setDiameter(String quantity,int index){
        waitLocatedXpaths("//input[@name ='Diameter (mm)']");
        xpathELems("//input[@name ='Diameter (mm)']").get(index).sendKeys(quantity);

    }

    public void setThickness(String thickness) throws InterruptedException {
        Thread.sleep(1000);
        waitLocatedXpaths("//input[@name ='Thickness (mm)']");
        List<WebElement> elements = xpathELems("//input[@name ='Thickness (mm)']");
        int size = elements.size()-1;
        System.out.println(size + " :  hfhjgyjg");

        xpathELems("//input[@name ='Thickness (mm)']").get(size).sendKeys(thickness);
    }

    public void setLengths(String length,int index){
        waitLocatedXpaths("//input[@name ='Length (mm)']");
        xpathELems("//input[@name ='Length (mm)']").get(index).sendKeys(length);
    }


    public void selectWidhts(String wid,int index){
        int width = Integer.parseInt(wid);
        if(width == 1250){
            xpathELems("//span[text() ='1250']").get(index).click();
        }
        else if (width == 1500){
            xpathELems("//span[text() ='1500']").get(index).click();
        }
        else{
            xpathELems("//span[text() ='Non-Standard']").get(index).click();
        }
    }



    public void saveOpportunity(){
        //save
        waitLocatedXpath("//button[text()='Save' and @title]");
        WebElement save = xpathELem("//button[text()='Save' and @title]");
        clickingTool(save);
    }

}

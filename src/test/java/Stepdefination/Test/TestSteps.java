package Stepdefination.Test;

import Utils.Functionalities;
import Utils.Functionalities.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.zh_cn.假如;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import javax.swing.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;

public class TestSteps {

    Functionalities functionalities = new Functionalities(getDriver());
    WebDriver driver = getDriver();
    List<WebElement> subSegment  = new ArrayList<>();
    List<String> categories = Arrays.asList(
            "--None--",
            "Buildings - Residential",
            "Buildings - Commercial",
            "Buildings - Industrial",
            "Buildings - Components & extensions",
            "Pipes & Tubes",
            "Buildings - HVAC",
            "Retail",
            "Infra - Public",
            "Infra - Transport",
            "Infra - Energy",
            "Infra - Water",
            "Automotive",
            "Industrial and Machinery",
            "Consumer Goods and Appliances",
            "Packaging",
            "Healthcare and Medical Equipment",
            "Defense and Military",
            "Agriculture",
            "Telecommunications",
            "Pressure Vessels and Tanks",
            "Processors"
    );
    List<String> fetchedSegment = new ArrayList<>();



    @Given("run this function")
    public void testClass(){
//        waitLocatedXpath("//a[text()='Details']");
//        clickingTool(xpathELem("//a[text()='Details']"));


        waitLocatedXpath("//button[@title='Edit Segment']");
        Actions action = new Actions(driver);
        action.moveToElement(xpathELem("//button[@title='Edit Segment']")).build().perform();
        action.scrollToElement(xpathELem("//button[@title='Edit Segment']")).build().perform();
        clickingTool(xpathELem("//button[@title='Edit Segment']"));

        waitLocatedXpath("//button[@aria-label='Segment']");
        clickingTool(xpathELem("//button[@aria-label='Segment']"));

//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='slds-listbox slds-listbox_vertical slds-dropdown slds-dropdown_fluid slds-dropdown_left' and @aria-label='Segment']")));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Segment']")));
        List<WebElement> SegmentList = xpathELems("//div[@aria-label='Segment']//span[@class='slds-truncate']");

        for(WebElement webElement : SegmentList){
            System.out.println(webElement.getText() + " : name of segment elements");
            fetchedSegment.add(webElement.getText());
        }

        assertList(fetchedSegment,categories);

        for(int i =1 ;i<SegmentList.size();i++){
            clickingTool(xpathELem("//button[@aria-label='Segment']"));
            clickingTool(SegmentList.get(i));

            waitLocatedXpath("//button[@aria-label='Sub Segment']");
            clickingTool(xpathELem("//button[@aria-label='Sub Segment']"));
            wait.until(ExpectedConditions.visibilityOf(xpathELem("//div[@aria-label='Sub Segment']")));
            subSegment =  xpathELems("//div[@aria-label='Sub Segment']//span[@class='slds-truncate']");
            System.out.println(SegmentList.get(i).getText() + " : Name of the segment is ------");
            for (WebElement webElement : subSegment){
                System.out.println(webElement.getText() + " : sub segment");
            }
        }



    }

    public void assertList(List<String>categories,List<String> Feteched){
       Assert.assertEquals(categories,Feteched);

    }

}

package Stepdefination.SegmentSubSegment;

import Pages.AccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;
import static Utils.Functionalities.xpathELem;

public class SegmentSteps {

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

    List<WebElement> SegmentListElem = new ArrayList<>();

    WebDriver driver = getDriver();
    AccountPage accountPage = new AccountPage(getDriver());


    public void moveToDetailsOfAccount(){
        accountPage.detailsOfPage();
    }

    @Given("User scrolls down to the Edit segment button")
    public void editButtonClicking(){
        accountPage.editButton();
    }

    @Given("User clicks on Edit segment button")
    public void userClickedOnSegmentButton(){
        accountPage.segmentButton();
    }

    @When("User validated the fields newly added to the category")
    public void checkTheSegmentList(DataTable dataTable){

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Segment']")));
        SegmentListElem = xpathELems("//div[@aria-label='Segment']//span[@class='slds-truncate']");
        List<String> FetchedNames = new ArrayList<>();

        for(WebElement webElement : SegmentListElem){
            System.out.println(webElement.getText() + " : name of segment elements");
            FetchedNames.add(webElement.getText());
        }

        Assert.assertEquals(FetchedNames,categories);
    }


    public void checTheSubSegmentForEachCtegory(){

        for(int i =1 ;i<SegmentListElem.size();i++){
            clickingTool(xpathELem("//button[@aria-label='Segment']"));
            clickingTool(SegmentListElem.get(i));

            waitLocatedXpath("//button[@aria-label='Sub Segment']");
            clickingTool(xpathELem("//button[@aria-label='Sub Segment']"));

            wait.until(ExpectedConditions.visibilityOf(xpathELem("//div[@aria-label='Sub Segment']")));

            List<WebElement>subSegment =  xpathELems("//div[@aria-label='Sub Segment']//span[@class='slds-truncate']");
            System.out.println(SegmentListElem.get(i).getText() + " : Segment");
            for (WebElement webElement : subSegment){
                System.out.println(webElement.getText() + " : sub segment");
            }
        }

    }




}

package Stepdefination.SegmentSubSegment;

import Pages.AccountPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.lv.Tad;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.lang.reflect.Type;
import java.util.*;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;
import static Utils.Functionalities.xpathELem;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class SegmentSteps {

    List<String> categories = new ArrayList<>();

    List<WebElement> SegmentListElem = new ArrayList<>();
    List<String> BuildingsResidential = new ArrayList<>();
    List<String> BuildingsCommercial  = new ArrayList<>();
    List<String> BuildingsIndustrial  = new ArrayList<>();
    List<String> BuildingsComponents = new ArrayList<>();
    List<String> Pipes  = new ArrayList<>();
    List<String> BuildingsHVAC  = new ArrayList<>();
    List<String> Retail  = new ArrayList<>();
    List<String> InfraPublic  = new ArrayList<>();
    List<String> InfraTransport  = new ArrayList<>();
    List<String> InfraEnergy  = new ArrayList<>();
    List<String> InfraWater  = new ArrayList<>();
    List<String> Automotive    = new ArrayList<>();
    List<String> Industrial  = new ArrayList<>();
    List<String> Consumer   = new ArrayList<>();
    List<String> Packaging   = new ArrayList<>();
    List<String> Healthcare   = new ArrayList<>();
    List<String> Defense   = new ArrayList<>();
    List<String> Agriculture   = new ArrayList<>();
    List<String> Telecommunications   = new ArrayList<>();
    List<String> PressureVessels    = new ArrayList<>();
    List<String> Processors    = new ArrayList<>();




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

        List<Map<String,String>> categoriesTable = dataTable.asMaps(String.class,String.class);

        for(Map category : categoriesTable){
             categories.add((String) category.get("Category"));
//                System.out.println(category.get("Category") + " Loop value");
        }

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@aria-label='Segment']")));
        SegmentListElem = xpathELems("//div[@aria-label='Segment']//span[@class='slds-truncate']");
        List<String> FetchedNames = new ArrayList<>();

        for(WebElement webElement : SegmentListElem){
            System.out.println(webElement.getText() + " : name of segment elements");
            FetchedNames.add(webElement.getText());
        }

        Assert.assertEquals(FetchedNames,categories);
    }

    @When("User sets the value for the subCategory for each Category")
    public void userSetsTheValueForEachSubCategory(DataTable dataTable) {
        List<Map<String, String>> subCategoryTable = dataTable.asMaps(String.class, String.class);


        for (Map<String, String> row : subCategoryTable) {
            String residential = row.get("Buildings - Residential");
            if (residential != null && !residential.isEmpty()) {
                BuildingsResidential.add(residential);
                System.out.println(BuildingsResidential +  "-- data insertion");
            }

            String commercial = row.get("Buildings - Commercial");
            if (commercial != null && !commercial.isEmpty()) {
                BuildingsCommercial.add(commercial);
            }

            String industrial = row.get("Buildings - Industrial");
            if (industrial != null && !industrial.isEmpty()) {
                BuildingsIndustrial.add(industrial);
            }

            String components = row.get("Buildings - Components & extensions");
            if (components != null && !components.isEmpty()) {
                BuildingsComponents.add(components);
            }

            String pipes = row.get("Pipes & Tubes");
            if (pipes != null && !pipes.isEmpty()) {
                Pipes.add(pipes);
            }

            String hvac = row.get("Buildings - HVAC");
            if (hvac != null && !hvac.isEmpty()) {
                BuildingsHVAC.add(hvac);
            }

            String retail = row.get("Retail");
            if (retail != null && !retail.isEmpty()) {
                Retail.add(retail);
            }

            String infraPublic = row.get("Infra - Public");
            if (infraPublic != null && !infraPublic.isEmpty()) {
                InfraPublic.add(infraPublic);
            }

            String infraTransport = row.get("Infra - Transport");
            if (infraTransport != null && !infraTransport.isEmpty()) {
                InfraTransport.add(infraTransport);
            }

            String infraEnergy = row.get("Infra - Energy");
            if (infraEnergy != null && !infraEnergy.isEmpty()) {
                InfraEnergy.add(infraEnergy);
            }

            String infraWater = row.get("Infra - Water");
            if (infraWater != null && !infraWater.isEmpty()) {
                InfraWater.add(infraWater);
            }

            String automotive = row.get("Automotive");
            if (automotive != null && !automotive.isEmpty()) {
                Automotive.add(automotive);
            }

            String industrialMachinery = row.get("Industrial and Machinery");
            if (industrialMachinery != null && !industrialMachinery.isEmpty()) {
                Industrial.add(industrialMachinery);
            }

            String consumerGoods = row.get("Consumer Goods and Appliances");
            if (consumerGoods != null && !consumerGoods.isEmpty()) {
                Consumer.add(consumerGoods);
            }

            String packaging = row.get("Packaging");
            if (packaging != null && !packaging.isEmpty()) {
                Packaging.add(packaging);
            }

            String healthcare = row.get("Healthcare and Medical Equipment");
            if (healthcare != null && !healthcare.isEmpty()) {
                Healthcare.add(healthcare);
            }

            String defense = row.get("Defense and Military");
            if (defense != null && !defense.isEmpty()) {
                Defense.add(defense);
            }

            String agriculture = row.get("Agriculture");
            if (agriculture != null && !agriculture.isEmpty()) {
                Agriculture.add(agriculture);
            }

            String telecommunications = row.get("Telecommunications");
            if(telecommunications != null && !telecommunications.isEmpty()){
                Telecommunications.add(telecommunications);
            }

            String pressureVessels = row.get("Pressure Vessels and Tanks");
            if (pressureVessels != null && !pressureVessels.isEmpty()) {
                PressureVessels.add(pressureVessels);
            }

            String processors = row.get("Processors");
            if (processors != null && !processors.isEmpty()) {
                Processors.add(processors);
            }
        }

    }


    @Then("User fetchs the date from the segment and assert with the respective array")
    public void checTheSubSegmentForEachCtegory(){

        for(int i =1 ;i<SegmentListElem.size();i++){
            clickingTool(xpathELem("//button[@aria-label='Segment']"));
            clickingTool(SegmentListElem.get(i));
            System.out.println(accountPage.segmentButtonTitle() + " : Segment");

            String segmentName = accountPage.segmentButtonTitle();

            waitLocatedXpath("//button[@aria-label='Sub Segment']");
            clickingTool(xpathELem("//button[@aria-label='Sub Segment']"));

            wait.until(ExpectedConditions.visibilityOf(xpathELem("//div[@aria-label='Sub Segment']")));
            List<WebElement>subSegment =  xpathELems("//div[@aria-label='Sub Segment']//span[@class='slds-truncate']");
            List<String> fetchedSubSegment = new ArrayList<>();

            for (WebElement webElement : subSegment){
                System.out.println(webElement.getText() + " : sub segment");
                fetchedSubSegment.add(webElement.getText());
            }

            AssertTheArray(segmentName,fetchedSubSegment);
        }


    }


    public void AssertTheArray(String name, List<String> array) {
        switch (name) {
            case "Buildings - Residential":
                assertThat(array).containsExactlyInAnyOrderElementsOf(BuildingsResidential);
                break;
            case "Buildings - Commercial":
                assertThat(array).containsExactlyInAnyOrderElementsOf(BuildingsCommercial);
                break;
            case "Buildings - Industrial":
                assertThat(array).containsExactlyInAnyOrderElementsOf(BuildingsIndustrial);
                break;
            case "Buildings - Components & extensions":
                assertThat(array).containsExactlyInAnyOrderElementsOf(BuildingsComponents);
                break;
            case "Pipes & Tubes":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Pipes);
                break;
            case "Buildings - HVAC":
                assertThat(array).containsExactlyInAnyOrderElementsOf(BuildingsHVAC);
                break;
            case "Retail":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Retail);
                break;
            case "Infra - Public":
                assertThat(array).containsExactlyInAnyOrderElementsOf(InfraPublic);
                break;
            case "Infra - Transport":
                assertThat(array).containsExactlyInAnyOrderElementsOf(InfraTransport);
                break;
            case "Infra - Energy":
                assertThat(array).containsExactlyInAnyOrderElementsOf(InfraEnergy);
                break;
            case "Infra - Water":
                assertThat(array).containsExactlyInAnyOrderElementsOf(InfraWater);
                break;
            case "Automotive":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Automotive);
                break;
            case "Industrial and Machinery":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Industrial);
                break;
            case "Consumer Goods and Appliances":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Consumer);
                break;
            case "Packaging":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Packaging);
                break;
            case "Healthcare and Medical Equipment":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Healthcare);
                break;
            case "Defense and Military":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Defense);
                break;
            case "Agriculture":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Agriculture);
                break;
            case "Telecommunications":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Telecommunications);
                break;
            case "Pressure Vessels and Tanks":
                assertThat(array).containsExactlyInAnyOrderElementsOf(PressureVessels);
                break;
            case "Processors":
                assertThat(array).containsExactlyInAnyOrderElementsOf(Processors);
                break;
            default:
                throw new IllegalArgumentException("Unexpected value: " + name);
        }
    }



}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }
    public HomePage(){
        this.driver = getDriver();
    }


    public void Applauncher(){
        waitLocatedXpath("//button[@title='App Launcher']");
        clickingTool(xpathELem("//button[@title='App Launcher']"));
    }

    public void AppSearchingBox(String search){
        waitLocatedXpath("//input[@placeholder='Search apps and items...']");
        xpathELem("//input[@placeholder='Search apps and items...']").sendKeys(search);
    }

    public void SelectApp(String app){

        waitLocatedXpath("//a[contains(@data-label, '" + app     +"')]");
        clickingTool(xpathELem("//a[contains(@data-label, '"+ app    +"')]"));
    }


    public void openSearchTab(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']")));
        wait.until(ExpectedConditions.stalenessOf(xpathELem("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']")));
        waitLocatedXpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']");
        WebElement SearchBox = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']"));
        waitFor(SearchBox);
        clickingTool(SearchBox);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @class= 'slds-input' and @placeholder ='Search...' ]")));
    }

    public void openOpportunity(String name) {
        wait.until(ExpectedConditions.visibilityOf(xpathELem("//mark[@class='data-match' and contains(text(),'"+ name +"')]"))).click();
    }

    public void LoggedUserIconButton() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='uiImage' and @data-aura-class='uiImage' and ./img[@alt='User']]")));
        clickingTool(xpathELem("//span[@class='uiImage' and @data-aura-class='uiImage' and ./img[@alt='User']]"));
    }

    public void LogOutButton(){
        waitLocatedXpath("//a[text()='Log Out']");
        clickingTool(xpathELem("//a[text()='Log Out']"));
    }



    public void searchItem(String search) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']")));
            waitLocatedXpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']");
            WebElement SearchBox = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']"));
            waitFor(SearchBox);
            JavaElemClick(SearchBox);



        } catch (Exception e) {

            wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']")));
            waitLocatedXpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']");
            WebElement SearchBox = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']"));
            waitFor(SearchBox);
            JavaElemClick(SearchBox);
        }

        WebElement SearchTab = driver.findElement(By.xpath("//input[@class='slds-input' and @part='input' and @placeholder='Search...']"));
        SearchTab.sendKeys(search);
    }

    public void searchAccountClick(String search){
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[ @title='" + search + "']")));
        WebElement SearchResult = driver.findElement(By.xpath("//span[ @title='" + search + "']"));
        clickingTool(SearchResult);

    }

    public void openAccount(String text) {
        WebElement account =  xpathELem("(//a[text()='"+text +"' and @data-refid='recordId' ])");
        clickingTool(account);
    }

    public void openAccountinSales(String text){
        //ADANI GREEN ENERGY TWENTY FOUR B LIMITED
        WebElement account =  xpathELem("(//a[text()='"+text +"' and @data-refid='recordId' ])[2]");
        clickingTool(account);
    }

}

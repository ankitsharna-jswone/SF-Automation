package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static Utils.Functionalities.*;

public class HomePage {
    WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    public void openSearchTab(){
        WebElement SearchBox = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']"));
        waitFor(SearchBox);
        JavaElemClick(SearchBox);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @class= 'slds-input' and @placeholder ='Search...' ]")));
    }

    public void openOpportunity(String name) {
        wait.until(ExpectedConditions.visibilityOf(xpathELem("//mark[@class='data-match' and contains(text(),"+ name +")]"))).click();
    }

    public void LoggedUserIconButton() throws InterruptedException {
        Thread.sleep(2000);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='uiImage' and @data-aura-class='uiImage' and ./img[@title='User']]")));
        clickingTool(xpathELem("//span[@class='uiImage' and @data-aura-class='uiImage' and ./img[@title='User']]"));
    }

    public void LogOutButton(){
        waitLocatedXpath("//a[text()='Log Out']");
        clickingTool(xpathELem("//a[text()='Log Out']"));
    }



    public void searchItem(String search){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']")));
        WebElement SearchBox = driver.findElement(By.xpath("//button[@class='slds-button slds-button_neutral search-button slds-truncate' and text()='Search...']"));
        clickingTool(SearchBox);
        WebElement SearchTab = driver.findElement(By.xpath("//input[@class='slds-input' and @part='input' and @placeholder='Search...']"));
        SearchTab.sendKeys(search); //CHAKRESH INDUSTRIES

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

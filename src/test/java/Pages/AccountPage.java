package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static Utils.BrowsserSetup.getDriver;
import static Utils.Functionalities.*;

public class AccountPage {

    WebDriver driver;

    public AccountPage(WebDriver driver) {
        this.driver = driver;
    }

    public void detailsOfPage(){
        waitLocatedXpath("//a[text()='Details']");
        clickingTool(xpathELem("//a[text()='Details']"));
    }

    public void PageRefresh(){
        driver.navigate().refresh();
    }

    public void saveEdit() throws InterruptedException {
        Thread.sleep(3000);
        clickingTool(xpathELem("//button[text()='Save' and @name ='SaveEdit']"));
    }

    public void editButton(){


        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath ("//button[@class ='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon' and @title='Edit Segment']")));
        JavaScriptScroll(xpathELem("//button[@class ='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon' and @title='Edit Segment']"));
        Actions action = new Actions(getDriver());
        action.moveToElement(xpathELem("//button[@class ='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon' and @title='Edit Segment']")).build().perform();
        action.scrollToElement(xpathELem("//button[@class ='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon' and @title='Edit Segment']")).build().perform();
        clickingTool(xpathELem("//button[@class ='test-id__inline-edit-trigger slds-shrink-none inline-edit-trigger slds-button slds-button_icon' and @title='Edit Segment']"));
    }

    public void segmentButton(){
        waitLocatedXpath("//button[@aria-label='Segment']");
        clickingTool(xpathELem("//button[@aria-label='Segment']"));
    }

    public String segmentButtonTitle(){
        return    xpathELem("//button[@aria-label='Segment']").getAttribute("data-value");
    }



    public void quickOpportunity() {
        String quickOpportunity = "//button[text()= 'Create opportunity']";
        waitLocatedXpath(quickOpportunity);
        xpathELem(quickOpportunity).click();
    }

    public void OpportunityDropDown(){
        waitLocatedXpath("(//button[./span[text()='Show more actions']])");
        clickingTool(xpathELem("(//button[./span[text()='Show more actions']])"));
    }
    public void salesQuickOpportunity(){
        waitLocatedXpath("//span[text() = 'Quick Opportunity']");
        clickingTool(xpathELem("//span[text() = 'Quick Opportunity']"));
    }

    public void opportunityManufacturing(){
        waitLocatedXpath("//a[text() = 'Manufacturing']");
        clickingTool(xpathELem("//a[text() = 'Manufacturing']"));
    }


    public void openSite() {
        waitLocatedXpath("//a[text()='Site']");
        clickingTool(xpathELem("//a[text()='Site']"));
    }


    public void chooseSite(String site) {
        waitLocatedXpath("//slot[text()='" + site + "']");
        JavaScriptClick("//slot[text()='" + site + "']");
    }

    public void filePage() {
        waitLocatedXpath("//a[text()='Files' and @data-tab-value ='customTab']");
        WebElement files = xpathELem("//a[text()='Files' and @data-tab-value ='customTab']");
        clickingTool(files);
    }

    public void skuReqPage() {
        waitLocatedXpath("//a[text()='SKU Requirements']");
        clickingTool(xpathELem("//a[text()='SKU Requirements']"));
    }

    public void selectSKU(int index) {
        waitLocatedXpaths("//a[contains(text(), 'SKUR')]");
        List<WebElement> skus = xpathELems("//a[contains(text(), 'SKUR')]");
        WebElement sku = skus.get(index);
        clickingTool(sku);
    }

    public String SKUStatus() {
        //dd//lightning-formatted-text
        waitLocatedXpath("//dt//span[contains(text(), 'SKU Status')  and @class = 'test-id__field-label']/following-sibling::dd//lightning-formatted-text");
        return xpathELem("//dt//span[contains(text(), 'SKU Status')  and @class = 'test-id__field-label']/following-sibling::dd//lightning-formatted-text").getText();
    }


    public void chooseSellerPI() {

        List<WebElement> files = filesList();
        int ind = 0;

        for (int i = 0; i < files.size(); i++) {

            if (files.get(i).getText().contains("Seller PI")) {
                ind = i;
                break;
            }
        }
        System.out.println(ind + " index ");

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title='Edit']")));
        List<WebElement> EditButtons = driver.findElements(By.xpath("//button[@title='Edit']"));
        WebElement edit = EditButtons.get(ind);
        clickingTool(edit);
    }


public void setSellerPi() {

    waitLocatedXpath("//button[@aria-label='Select Tag']/span[text()='Select an Option']");
    WebElement dropDown = xpathELem("//button[@aria-label='Select Tag']/span[text()='Select an Option']");
    clickingTool(dropDown);

    waitLocatedXpath("//span[@title='Seller PI']");
    WebElement sellerPI = xpathELem("//span[@title='Seller PI']");
    clickingTool(sellerPI);

    waitLocatedXpath("//button[text()='Save']");
    WebElement save = xpathELem("//button[text()='Save']");
    clickingTool(save);
}

public void createOrderButton() {
    waitLocatedXpath("//button[text()='Create Order']");
    WebElement create = xpathELem("//button[text()='Create Order']");
    clickingTool(create);
}

public void nextButtonPlant() {
    waitLocatedXpath("//button[text()='Next']");
    clickingTool(xpathELem("//button[text()='Next']"));
}

public String stageOfOpportunity() throws InterruptedException {
        Thread.sleep(2000);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("")));
        return  xpathELem("dt[.//span[text()='Stage']]/following-sibling::dd//span[@class='test-id__field-value slds-form-element__static slds-grow word-break-ie11']//slot//lightning-formatted-text").getText();



}

public static void handleAlert(WebDriver driver) {
    try {
        Alert alert = driver.switchTo().alert();
        System.out.println("Alert text is: " + alert.getText());
        alert.accept();
    } catch (NoAlertPresentException e) {

    }
}

public void insideCreateButtonOpc() {
    waitLocatedXpath("//button[text()='Create Order' and @class='slds-button slds-button_success']");
    WebElement createOrder = xpathELem("//button[text()='Create Order' and @class='slds-button slds-button_success']");
    clickingTool(createOrder);
}

public void insideCreateButtonCoil() {

    clickingTool(xpathELem("//lightning-button[@variant = 'success']//button[text()='Create Order']"));
}

public String captureOrderNumber() {
    waitLocatedXpath("//span[@class='toastMessage forceActionsText']");
    String orderMessage = xpathELem("//span[@class='toastMessage forceActionsText']").getText();

    int startIndex = orderMessage.lastIndexOf("- ") + 2;
    String orderNumber = orderMessage.substring(startIndex);
    return orderNumber;

}

public void closeCreateOrderTab() {
    xpathELem("//button[@title = 'Close this window']").click();
}

public WebElement closeButton() {
    return xpathELem("//button[@title = 'Close this window']");
}

public String subTotalCreateOrder() {
    String subtotal = xpathELem("//div[contains(@class, 'slds-col') and .//span[contains(text(), 'Amount due')]]/following-sibling::div/span").getText();
    return subtotal;
}


public void OrderTab() {
    waitLocatedXpath("//a[text()='Order' and @tabindex =-1]");
    WebElement orderTab = xpathELem("//a[text()='Order' and @tabindex =-1]");
    clickingTool(orderTab);
}


public void orderNumberClick(String ordernumber) {
    waitLocatedXpath("//a[@title ='" + ordernumber + "']");
    WebElement orderNumber = xpathELem("//a[@title ='" + ordernumber + "']");
    clickingTool(orderNumber);
}

public List<WebElement> filesList() {
    wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='slds']")));
    List<WebElement> documents = driver.findElements(By.xpath("//div[@class='slds']"));
    return documents;
}

public boolean checkFIle(String file, List<WebElement> list) {
    for (WebElement web : list) {
        String text = web.getText();
        if (text.contains(file)) {
            return true;
        }
    }
    return false;
}

    public void ApprovedCreditProgramButton(){

            waitLocatedXpath("(//button[text()='More' and @title='More Tabs'])[2]");
            clickingTool(xpathELem("(//button[text()='More' and @title='More Tabs'])[2]"));
            waitLocatedXpath("//a[ .//text()='Approved Credit Programs']");
            clickingTool(xpathELem("//a[ .//text()='Approved Credit Programs']"));


    }


}


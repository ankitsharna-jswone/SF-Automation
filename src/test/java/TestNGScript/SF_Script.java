package TestNGScript;

import Pages.*;
import Utils.Functionalities;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.Functionalities.*;

public class SF_Script {

    static WebDriver driver;
    static WebDriverWait wait;
    Actions actions;
    List<WebElement> buttons;

    LoginPage log;
    HomePage home;
    AccountPage accountPage;
    Functionalities func;
    ProcessOpportunity processOpportunity;
    PricingAwaitingPage priceawaiting;
    CustomerPricing customerPricing;

    SitePage site;
    @BeforeTest
    public void setup(){
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);
        driver = new ChromeDriver(options);
        setConsoleReader(driver);
        driver.manage().window().maximize();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
        driver.get("https://jswoneplatforms--prdreplica.sandbox.my.salesforce.com/");
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        actions = new Actions(driver);

        func = new Functionalities(driver);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        log = new LoginPage(driver);
        home = new HomePage(driver);
        accountPage = new AccountPage(driver);
        site = new SitePage(driver);
        processOpportunity = new ProcessOpportunity(driver);
        priceawaiting = new PricingAwaitingPage(driver);
        customerPricing = new CustomerPricing(driver);

    }

    @Test(priority = 1)
    public void login()
    {
        log.usernameSF("v_ankit.sharma@jsw.in");
        log.passwordSF("@Ankit123");
        log.loginSF();

        readLevel();
//        WebElement username = driver.findElement(By.cssSelector("input#username"));
//        waitFor(username);
//        username.sendKeys("v_ankit.sharma@jsw.in");
//        WebElement password = driver.findElement(By.cssSelector("input#password"));
//        waitFor(password);
//        password.sendKeys("@Ankit123");
//        WebElement loginButton = driver.findElement(By.cssSelector("input#Login"));
//        waitFor(loginButton);
//        loginButton.click();
    }

    @Test(priority = 2)
    public void homePage() throws InterruptedException {
        home.openSearchTab();
        home.searchItem("CHAKRESH INDUSTRIES");
        home.searchAccountClick("CHAKRESH INDUSTRIES");


        accountPage.openSite();
        accountPage.chooseSite("Global city");


//        WebElement SearchBox = driver.findElement(By.cssSelector("button.slds-button.slds-button_neutral.search-button.slds-truncate"));
//        waitFor(SearchBox);
//        SearchBox.click();
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='search' and @class= 'slds-input' and @placeholder ='Search...' ]")));
//        WebElement SearchTab = driver.findElement(By.xpath("//input[@type='search' and @class= 'slds-input' and @placeholder ='Search...']"));
//        waitFor(SearchTab);
//        SearchTab.sendKeys("CHAKRESH INDUSTRIES ");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[ @title='CHAKRESH INDUSTRIES']")));
//        WebElement SearchResult = driver.findElement(By.xpath("//span[ @title='CHAKRESH INDUSTRIES']"));
//        SearchResult.click();
//
//        waitLocatedXpath("//a[text()='Site']");
//        xpathELem("//a[text()='Site']").click();
//        waitLocatedXpath("//span[text()='Global city']");
//        JavaScriptClick("//span[text()='Global city']");
    }

    @Test(priority = 3)
    public void opportunityCreation() {
        site.quickOpportunity();
        site.cementButton();
        site.cementBrandSelect("JSW");
        site.cementTypeAndQuantity("OPC-53", "50");
        site.saveCementOpportunity();


        //quick opportunity
//        String quickOpportunity = "//button[@name = 'MSME_Construct_Site__c.Quick_Opportunity_aura']";
//        waitLocatedXpath(quickOpportunity);
//        xpathELem(quickOpportunity).click();
//
//        //cement
//        waitLocatedXpath("//a[text()='Cement']");
//        xpathELem("//a[text()='Cement']").click();
//
//        //Brand Drop down
//        waitLocatedXpath("//button[@name ='Cement Brand']");
//        xpathELem("//button[@name ='Cement Brand']").click();
//
//        //Select Brand
//        waitLocatedXpath("//lightning-base-combobox-item[@data-value ='JSW']");
//        xpathELem("//lightning-base-combobox-item[@data-value ='JSW']").click();
//
//        //select label
//        WebElement labelElement = driver.findElement(By.xpath("//label[text()='OPC-53']"));
//        //select quantity
//        WebElement inputElement = labelElement.findElement(By.xpath("./following-sibling::div/input"));
//        inputElement.sendKeys("50");

        //save
//        waitLocatedXpath("//button[text()='Save']");
//        Actions act = new Actions(driver);
//        act.scrollToElement(xpathELem("//button[text()='Save']")).build().perform();
//        act.moveToElement(xpathELem("//button[text()='Save']")).build().perform();
//        JavaScriptClick("//button[text()='Save']");

    }

    @Test(priority = 4)
    public void process_opportunity() throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.editOpportunity();
        processOpportunity.editDelivery("Self pickup");
        processOpportunity.editDeliveryTime("4");
        processOpportunity.editSpecialMessage("Will deliver soon");
        processOpportunity.categoryPrice("180");
        processOpportunity.selectSeller("JSW");
        processOpportunity.editCostPrice("150");
        processOpportunity.saveOpportunity();


        readLevel();


        //process opportunity
//        waitLocatedXpath("//button[text()='Process Opportunity']");
//        xpathELem("//button[text()='Process Opportunity']").click();
//
//        //edit opportunity
//        waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));
//        buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
//        WebElement editOpportunity = buttons.get(0);
//        JavaElemClick(editOpportunity);
//
//        //Delivery Instructions
//        xpathELem("//button[@aria-label ='Delivery Instructions - Current Selection: Select Delivery Instructions']").click();
//        waitLocatedXpath("//lightning-base-combobox-item[@data-value='Self pickup']");
//        xpathELem("//lightning-base-combobox-item[@data-value='Self pickup']").click();
//
//        //Delivery Time
//        xpathELem("//button[@name ='Delivery_timeline__c']").click();
//        waitLocatedXpath("//lightning-base-combobox-item[@data-value ='3 days']");
//        xpathELem("//lightning-base-combobox-item[@data-value ='3 days']").click();
//
//        //Special message
//        waitLocatedXpath("//input[@required and @name ='TDC_PO__c']");
//        xpathELem("//input[@required and @name ='TDC_PO__c']").sendKeys("soon");
//
//
//        //category price
//        waitLocatedXpath("//input[@name ='Category_Price__c']");
//        xpathELem("//input[@name ='Category_Price__c']").sendKeys("180");
//
//        //Seller( JODL )
//        waitLocatedXpath("//input[@placeholder = 'Search Accounts...']");
//        xpathELem("//input[@placeholder = 'Search Accounts...']").sendKeys("JSW");
//        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title ='JSW One Distribution Limited (JODLMH001)']");
//        xpathELem("//lightning-base-combobox-formatted-text[@title ='JSW One Distribution Limited (JODLMH001)']").click();
//
//
//        //cost price
//        waitLocatedXpath("//input[@name ='Source_Seller_Quote__c']");
//        xpathELem("//input[@name ='Source_Seller_Quote__c']").sendKeys("150");
//
//        //save
//        waitLocatedXpath("//button[text()='Save' and @title]");
//        WebElement save = xpathELem("//button[text()='Save' and @title]");
//        JavaElemClick(save);

    }


    @Test(priority = 5)
    public void pricingAwaiting() throws InterruptedException {

        priceawaiting.clickPriceAwaiting();
        priceawaiting.categoryUserTest("Category Test User");
        priceawaiting.saveCategory();


//        WebElement pricingWait = xpathELem("//button[text()='Pricing Awaited']");
//        waitFor(pricingWait);
//        JavaElemClick(pricingWait);
//
//        waitLocatedXpath("//input[@placeholder='Search People...']");
//
//        clickingTool(xpathELem("//input[@placeholder='Search People...']"));
//        xpathELem("//input[@placeholder='Search People...']").sendKeys("Category Test user");
//        xpathELem("//input[@placeholder='Search People...']").click();
//        waitLocatedXpath("//h2[text()='Select Users']");
//
//        waitLocatedXpath("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
//        WebElement category = xpathELem("//lightning-base-combobox-formatted-text[@title = 'Category Test user']");
//        category.click();
//
//        WebElement save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//footer//button[text()='Save' and @class = 'slds-button slds-button_brand' and @title = 'Primary action']")));
//        actions.scrollToElement(save).build().perform();
//        clickingTool(save);

    }

    @Test(priority = 6)
    public void customerPricing() throws InterruptedException {
        processOpportunity.editCustomerButton();
        processOpportunity.customerFinalPrice("180");
        processOpportunity.saveCustomer();
        processOpportunity.verifyPriceCustomer();
        processOpportunity.requestPItocategory();
        processOpportunity.saveCategory();
        processOpportunity.requestPItoSeller();
        processOpportunity.saveFinalOrder();

//        waitLocatedXpath("//lightning-tab[@class='slds-tabs_scoped__content slds-show']");
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title ='Show More']")));
//
//        buttons = driver.findElements(By.xpath("//button[@title ='Show More']"));
//        WebElement editOpportunity = buttons.get(2);
//        JavaElemClick(editOpportunity);
//
//
//        waitLocatedXpath("//input[@name ='Final_Distributor_Quote__c']");
//        xpathELem("//input[@name ='Final_Distributor_Quote__c']").sendKeys("200");
//
//        waitLocatedXpath("//button[text()='Save']");
//        xpathELem("//button[text()='Save']").click();
//
//        waitLocatedXpath("//button[text()='Verify Prices']");
//        WebElement verifyPrice = xpathELem("//button[text()='Verify Prices']");
//        clickingTool(verifyPrice);
//
//        waitLocatedXpath("//button[text()='Request PI to Category']");
//        WebElement RequestPI = xpathELem("//button[text()='Request PI to Category']");
//        clickingTool(RequestPI);
//
//        WebElement Catsave = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//footer//button[text()='Save' and @class = 'slds-button slds-button_brand' and @title = 'Primary action']")));
//        actions.scrollToElement(Catsave).build().perform();
//        clickingTool(Catsave);
//
//
//        waitLocatedXpath("//button[text()='Request PI to Seller']");
//        WebElement requestPI = xpathELem("//button[text()='Request PI to Seller']");
//        clickingTool(requestPI);
//
//        waitLocatedXpath("//button[text()='Save']");
//        WebElement save = xpathELem("//button[text()='Save']");
//        clickingTool(save);

    }

    @Test(priority = 7)
    public void createPayment(){
        driver.navigate().refresh();

        accountPage.filePage();
        accountPage.chooseSellerPI();
        accountPage.setSellerPi();
//        waitLocatedXpath("//a[text()='Files' and @data-tab-value ='customTab']");
//        WebElement files = xpathELem("//a[text()='Files' and @data-tab-value ='customTab']");
//        clickingTool(files);

//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@title='Edit']")));
//        List<WebElement> EditButtons = driver.findElements(By.xpath("//button[@title='Edit']"));
//        WebElement edit = EditButtons.get(0);
//        clickingTool(edit);
//
//        waitLocatedXpath("//button[@aria-label='Select Tag - Current Selection: Select an Option']");
//        WebElement dropDown = xpathELem("//button[@aria-label='Select Tag - Current Selection: Select an Option']");
//        clickingTool(dropDown);
//
//        waitLocatedXpath("//span[@title='Seller PI']");
//        WebElement sellerPI = xpathELem("//span[@title='Seller PI']");
//        clickingTool(sellerPI);
//
//        waitLocatedXpath("//button[text()='Save']");
//        WebElement save = xpathELem("//button[text()='Save']");
//        clickingTool(save);

        readConsole();

        readLevel();

        driver.navigate().refresh();
    }

    @Test(priority = 8)
    public void createOrder(){
        accountPage.createOrderButton();
        accountPage.insideCreateButtonOpc();
//        accountPage.captureOrderNumber();

//        waitLocatedXpath("//button[text()='Create Order']");
//        WebElement create = xpathELem("//button[text()='Create Order']");
//        clickingTool(create);
//
//        waitLocatedXpath("//button[text()='Create Order' and @class='slds-button slds-button_success']");
//        WebElement createOrder = xpathELem("//button[text()='Create Order' and @class='slds-button slds-button_success']");
//        clickingTool(TestNGScript.createOrder);
//        readLevel();

//        waitLocatedXpath("//span[@class='toastMessage forceActionsText']");
//        String orderMessage = xpathELem("//span[@class='toastMessage forceActionsText']").getText();
//
//        int startIndex = orderMessage.lastIndexOf("- ") + 2;
//        String orderNumber =  orderMessage.substring(startIndex);
//        System.out.println(orderNumber + " : ans ");

    }



}

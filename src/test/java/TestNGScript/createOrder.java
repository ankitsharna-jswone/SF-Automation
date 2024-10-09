package TestNGScript;

import Pages.*;
import Utils.Functionalities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.v85.log.Log;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.Functionalities.setConsoleReader;

public class createOrder {

    static WebDriver driver;
    static WebDriverWait wait;
    Actions actions;
    Functionalities func;
    LoginPage log;
    HomePage homePage;
    AccountPage accountPage;
    ProcessOpportunity processOpportunity;
    PricingAwaitingPage awaitingPage;
    OrderPage orderPage;
    String ordernumber;


    String search = "MS HR Coil 2062:2011 E250A";
    String seler = "HEENA STEEL LLP";

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
         log = new LoginPage(driver);
         homePage = new HomePage(driver);
         accountPage = new AccountPage(driver);
         processOpportunity = new ProcessOpportunity(driver);
         awaitingPage = new PricingAwaitingPage(driver);
         orderPage = new OrderPage(driver);


    }

    @Test(priority = 1)
    public void login() {
        log.usernameSF("v_ankit.sharma@jsw.in");
        log.passwordSF("@Ankit123");
        log.loginSF();
    }

    @Test(priority = 2)
    public void homePage(){
        homePage.openSearchTab();
        homePage.searchItem("Test Account B");
        homePage.searchAccountClick("Test Account B");
        homePage.openAccount("Test Account B");
    }

    @Test(priority = 3)
    public void createOpportunity() throws InterruptedException {
        accountPage.quickOpportunity();
        processOpportunity.addButton();
        processOpportunity.searchProduct(search);
        processOpportunity.selectProduct(search);
        processOpportunity.setQuantity("50");
        processOpportunity.setThickness("10");
        processOpportunity.selectWidht("1500");
//        MS HR Sheet 2062:2011 E250A
//        JSW Steel Pre-Painted Galvalume Coils IS 15965:2012 YS550
//        Jindal Hissar ERW Round Pipe IS 1239 (Part1):2004 Black
//        Ador SUPERINOX 1C E308L-16 Stainless Steel Welding Electrode


        processOpportunity.saveOpportunity();
    }

    @Test(priority = 4)
    public void process_opportunity() throws InterruptedException {
        processOpportunity.processOpportunitybutton();
        processOpportunity.editOpportunity();
        processOpportunity.editDelivery("Self pickup");
//        processOpportunity.editDeliveryAdress("Manas Nagar");
        processOpportunity.editDeliveryTime("4");
        processOpportunity.editSpecialMessage("Will deliver soon");
        processOpportunity.categoryPrice("1500");
        processOpportunity.searchCoilSeller("HEENA STEEL LLP");
        processOpportunity.selectCoilSeller("HEENA STEEL LLP");
        processOpportunity.editCostPrice("1000");
        processOpportunity.saveOpportunity();
    }

    @Test(priority = 5)
    public void pricingAwaiting() throws InterruptedException {
        awaitingPage.clickPriceAwaiting();
        awaitingPage.categoryUserTest("Category Test User");
        awaitingPage.saveCategory();
        processOpportunity.saveOpportunity();
        System.out.println("Stage is : " + accountPage.stageOfOpportunity()) ;

    }

//    @Test(priority = 6)
//    public void customerPricing()  {
//        processOpportunity.processOpportunitybutton();
//        processOpportunity.customerFinalPrice("1800");
//        processOpportunity.saveOpportunity();
//        processOpportunity.verifyPriceCustomer();
//        processOpportunity.saveOpportunity();
//        System.out.println("Stage is : " + accountPage.stageOfOpportunity()) ;
//
//    }
//
//    @Test(priority = 7)
//    public void requestPItoCategory() {
//        processOpportunity.processOpportunitybutton();
//        processOpportunity.saveOpportunity();
//        processOpportunity.requestPItocategory();
//        processOpportunity.categoryUserTest();
//        processOpportunity.saveCategory();
//        processOpportunity.saveOpportunity();
//        System.out.println("Stage is : " + accountPage.stageOfOpportunity());
//        accountPage.skuReqPage();
//        accountPage.selectSKU(0);
//        accountPage.stageOfOpportunity();
//
//    }
//    @Test(priority = 8)
//    public void requestPItoSeller(){
//        processOpportunity.processOpportunitybutton();
//        processOpportunity.saveOpportunity();
//        processOpportunity.requestPItoSeller();
//        processOpportunity.saveFinalOrder();
//    }
////
//    @Test(priority = 9)
//    public void selectSellerPI() {
//        accountPage.filePage();
//        accountPage.chooseSellerPI();
//        accountPage.setSellerPi();
//        System.out.println("Stage is : " + accountPage.stageOfOpportunity()) ;
//    }
////
//    @Test(priority = 10)
//    public void createOrder() {
//        accountPage.createOrderButton();
//        String subtotal =  accountPage.subTotalCreateOrder();
//        System.out.println(subtotal + " : total value for the order is" );
//        accountPage.insideCreateButtonCoil();
//        ordernumber = accountPage.captureOrderNumber();
//        System.out.println(ordernumber + " : ordernumber ");
//
//
////        if(wait.until(ExpectedConditions.invisibilityOf(accountPage.closeButton()))){
////            accountPage.closeCreateOrderTab();
////            System.out.println("closing the the tab!");
////        }
//
////        System.out.println("Stage is : " + accountPage.stageOfOpportunity());
//    }
//
//    @Test(priority = 11)
//    public void checkOrderCreation(){
//
//        accountPage.OrderTab();
//        accountPage.orderNumberClick(ordernumber);
//        System.out.println(orderPage.getExternalOrderID() + " : external order ID");
//        System.out.println(orderPage.OrderStatusAtOrderPage() +  " : order status is now! ");
//        System.out.println("Registered company name is : " + orderPage.GetRegisteredCompanyName());
////        System.out.println("OMS link for the order is" +  orderPage.OMSorderLink());
//        System.out.println("Order payemebt : " + orderPage.GetOrderPayment());
////        System.out.println("Paid amount is : " + orderPage.GetPaidAmount());
////        System.out.println("Due amount is : " + orderPage.GetPaymentDueAmount());
//        System.out.println("Payment status : " + orderPage.GetPaymentStatus());
//        System.out.println("Opportunity Name : " + orderPage.OpportunityOftheOrder());
//
//    }
//
////    @Test(priority = 12)
//    public void  checkOrderSummary(){
//        driver.navigate().back();
//        accountPage.filePage();
//        boolean flag = accountPage.checkFIle("System_OS", accountPage.filesList());
//        System.out.println("The summary is present ? : " + flag );
//    }
//
//
//
//
//
////
//










}

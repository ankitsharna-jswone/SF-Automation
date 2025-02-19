package TestNGScript;

import Pages.*;
import Utils.Functionalities;
import io.cucumber.java.en_old.Ac;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.Functionalities.*;
import static java.util.logging.Level.ALL;

public class testScript {

    WebDriver driver;
    Actions actions;

    Functionalities func;
    LoginPage log;
    HomePage homePage;
    ProcessOpportunity processOpportunity;
    AccountPage accountPage;
    PricingAwaitingPage awaitingPage;

    OpportunityPage opportunityPage;
    ApprovedCreditPrograms approvedCreditPrograms;
    OpportunityCreditPage opportunityCreditPage;
    @BeforeTest
    public void setup(){

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);

//        options.setCapability("goog:loggingPrefs", "{\"browser\": \"ALL\"}");
//        options.setCapability("goog:loggingPrefs", "{browser: ALL}");

        driver = new ChromeDriver(options);
//        setConsoleReader(driver);
        driver.manage().window().maximize();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
        driver.get("https://jswoneplatforms--uat.sandbox.lightning.force.com/lightning/r/Opportunity/006Ik000003Mom6IAC/view");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);

        func = new Functionalities(driver);
        log = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        processOpportunity = new ProcessOpportunity(driver);
        awaitingPage = new PricingAwaitingPage(driver);
        opportunityPage = new OpportunityPage(driver);
        approvedCreditPrograms = new ApprovedCreditPrograms();
        opportunityCreditPage = new OpportunityCreditPage();

    }



    @Test(priority = 1)
    public void login() {
        String username = "ankit.sharma@jsw.in.uat ";
        String password = "@Bhuvi176";
        log.usernameSF(username);
        log.passwordSF(password);
        log.loginSF();


    }

    @Test(priority = 2)
    public void setp() throws InterruptedException {
        opportunityPage.showMoreActions();
        opportunityPage.submitForApprovalAdvanceButton();
        opportunityPage.approvalComment("Approve it");
        opportunityPage.submitButtonForAdvanceApproval();

        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        for (int i = 0; i < 10; i++) {
            javascriptExecutor.executeScript("window.scrollBy(0, 500);"); // Scrolls 100 pixels down
            Thread.sleep(500); // Wait for 500 milliseconds between each scroll
        }

        opportunityPage.approvalHistoryBoxButton();

        System.out.println(opportunityPage.statusOfApproval());

//        System.out.println(opportunityCreditPage.CreditAmount() + " Credit Amount");
//        System.out.println(opportunityCreditPage.ApprovedCreditDays() + " Approved Credit days");
//        System.out.printf(opportunityCreditPage.CreditAvialable() + " Credit Available");
//        System.out.printf(opportunityCreditPage.CreditDays() + " Credit days");
//        System.out.printf(opportunityCreditPage.CreditProgramName() + " Credit Program ");
//        System.out.printf(opportunityCreditPage.CreditRequired() + " Credit Requiredd");
//        System.out.printf(opportunityCreditPage.CreditUtilised() + " Credit utilised");
//        System.out.printf(opportunityCreditPage.BlockedLimiit() + " Blocked Available");
//        System.out.printf(opportunityCreditPage.CreditProgramPan() + " Program Credit");
//        System.out.printf(opportunityCreditPage.CreditAvialable() + " Credit Available");
//        opportunityCreditPage.SanctionedLimit();
//        opportunityCreditPage.CreditExpiryDate();
//        opportunityCreditPage.CreditProgramType();
//        opportunityCreditPage.PenalInterest();



//
//            accountPage.ApprovedCreditProgramButton();
//            String credit = "BNPL - Ankit-Credit";
//            System.out.println(" Aviable amount : " +approvedCreditPrograms.AvailableAmount(credit));
//        System.out.println(" Blocked amount : " +approvedCreditPrograms.BlockedAmount(credit));
//        System.out.println(" Credit amount : " +approvedCreditPrograms.CreditDueDays(credit));
//        System.out.println(" Sanctioned amount : " +approvedCreditPrograms.SanctionedAmount(credit));
//        System.out.println(" Usable amount : " +approvedCreditPrograms.UsableAmount(credit));
//        System.out.println(" Utilised amount : " +approvedCreditPrograms.UtilisedAmount(credit));
//        System.out.println(" CreditLimitBlock amount : " +approvedCreditPrograms.CreditLimitBlock(credit));
//        System.out.println(" CreditExpiry amount : " +approvedCreditPrograms.CreditExpiryDate(credit));
//        System.out.println(" Peanl amount : " +approvedCreditPrograms.PenalRate(credit));
//        System.out.println(" Due Days amount : " +approvedCreditPrograms.CreditDueDays(credit));
//
//        approvedCreditPrograms.CreditDetialsJSON(credit);



//        processOpportunity.processOpportunitybutton();
//        processOpportunity.editOpportunity();
//        processOpportunity.creditRequired();
//        processOpportunity.creditRequiredYes();
//        processOpportunity.creditProgramType();
//        String string = "Channel finance-Jsw One";
//        waitLocatedXpath("//div[@aria-label='Credit Program Type']");
//
//        processOpportunity.selectCreditProgram(string);


//        System.out.println("gap message =============================");
//        System.out.println("===============================");
//        // Filter and process console logs
//        for (LogEntry log : logs) {
//            String message = log.getMessage();
//            // Check if the log contains the desired data marker
//            if (message.contains("desired_data_marker")) {
//                // Process or print the log
//                System.out.println(message);
//            }
        }






    }
//
//    @Test(priority = 2)
//    public void reachOrder(){
//        driver.navigate().to("https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Opportunity/006Hz00000TjwaGIAR/view");
//        accountPage.filePage();
//        ;
//        System.out.println(accountPage.checkFIle("System_OS_JOO", accountPage.filesList()) + " file is present ?");
//    }

//    @Test
//    public void listcheck(){
//        List<String > list = new ArrayList<>();
//        list.add("Category PI request.pdf");
//        list.add("Seller PI-18042024-1549V1.pdf");
//        list.add("System_OS_JOO-NUJ7JPZY_2024-04-18_15:49:56.pdf");
//
//        System.out.println("before");
//
//        for(String web : list){
//            if(web.contains("System_OS_JOO")){
//                System.out.println("summary");
//            }
//
//        }
//
//        System.out.println("after");
//    }





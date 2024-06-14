package TestNGScript;

import Pages.*;
import Utils.Functionalities;
import io.cucumber.java.en_old.Ac;
import org.apache.poi.sl.draw.geom.GuideIf;
import org.openqa.selenium.By;
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
    @BeforeTest
    public void setup(){

        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();

        options.setExperimentalOption("prefs", prefs);

//        options.setCapability("goog:loggingPrefs", "{\"browser\": \"ALL\"}");
//        options.setCapability("goog:loggingPrefs", "{browser: ALL}");

        driver = new ChromeDriver(options);
        setConsoleReader(driver);
        driver.manage().window().maximize();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,10);
        PageFactory.initElements(factory,this);
        driver.get("https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Account/0019D00000RfTxDQAV/view");

//        driver.get("https://jswoneplatforms--prdreplica.sandbox.lightning.force.com/lightning/r/Order/801Hz000001ttDtIAI/view");

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);

        func = new Functionalities(driver);
        log = new LoginPage(driver);
        homePage = new HomePage(driver);
        accountPage = new AccountPage(driver);
        processOpportunity = new ProcessOpportunity(driver);
        awaitingPage = new PricingAwaitingPage(driver);
        opportunityPage = new OpportunityPage(driver);

    }



    @Test(priority = 1)
    public void login() {


    }

    @Test(priority = 2)
    public void setp(){



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





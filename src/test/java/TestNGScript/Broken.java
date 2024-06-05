package TestNGScript;

import Utils.Functionalities;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static Utils.Functionalities.*;

public class Broken {

    WebDriver driver;
    Actions actions;
    ExtentReports extent;
    ExtentTest test;

    String website = "https://qa-ssr.msme.jswone.in/";

    List<BrokenLink> brokenLinks = new ArrayList<>();

    @BeforeTest
    public void setup() {

        String reportPath = System.getProperty("user.dir") + "/reports/extentReport.html";
        File reportFile = new File(reportPath);


        File parentDir = reportFile.getParentFile();
        if (parentDir != null && !parentDir.exists()) {
            parentDir.mkdirs();
        }


        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(reportPath);
        htmlReporter.config().setTheme(Theme.STANDARD);
        htmlReporter.config().setDocumentTitle("Broken Link Report");
        htmlReporter.config().setReportName("Broken Link Test Report");

        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);

        test = extent.createTest("Broken Links Test");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        options.setAcceptInsecureCerts(true);

        driver = new ChromeDriver(options);
        setConsoleReader(driver);
        driver.manage().window().maximize();
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 10);
        PageFactory.initElements(factory, this);
        Functionalities functionalities = new Functionalities(driver);
        driver.get(website);

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        actions = new Actions(driver);
    }

    @Test(priority = 1)
    public void login() {
        waitLocatedXpath("//button[@id='login-cta']");
        xpathELem("//button[@id='login-cta']").click();

        waitLocatedXpath("//button[@id='login-via-otp']");
        xpathELem("//button[@id='login-via-otp']").click();

        waitLocatedXpath("//input[@id='email']");
        xpathELem("//input[@id='email']").sendKeys("v_ankit.sharma@jsw.in");

        waitLocatedXpath("//input[@id='password']");
        xpathELem("//input[@id='password']").sendKeys("@Ankit123");

        waitLocatedXpath("//button[@id='login-to-continue']");
        xpathELem("//button[@id='login-to-continue']").click();
    }

    @Test(priority = 2)
    public void website() throws InterruptedException, IOException {
        Thread.sleep(3000);
        List<WebElement> webElements = driver.findElements(By.xpath("//a"));

        for (WebElement web : webElements) {
            String link = web.getAttribute("href");

            if (link != null && link.startsWith("https:")) {
                checkLink(link);
            } else {
                System.out.println(web.getAttribute("class"));
            }
            System.out.println("===============");
        }
    }

    public void checkLink(String linkUrl) throws IOException {
        URL url = new URL(linkUrl);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        httpConn.setConnectTimeout(3000);
        httpConn.connect();

        int responseCode = httpConn.getResponseCode();
        String responseMessage = httpConn.getResponseMessage();

        if (responseCode >= 200 && responseCode <= 204) {
            test.log(Status.PASS, "URL: " + linkUrl + " - Response Code: " + responseCode);
        } else {
            BrokenLink brokenLink = new BrokenLink(linkUrl, responseCode, responseMessage);
            brokenLinks.add(brokenLink);
            test.log(Status.FAIL, brokenLink.toString());
            System.out.println(linkUrl + " - " + responseMessage + " - Broken link");
        }
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
        generateReport();
        extent.flush();
    }

    public void generateReport() {
        if (brokenLinks.isEmpty()) {
            test.log(Status.INFO, "No broken links found.");
        } else {
            test.log(Status.FAIL, "Broken Links Report:");
            for (BrokenLink brokenLink : brokenLinks) {
                test.log(Status.FAIL, brokenLink.toString());
            }
        }
    }
}

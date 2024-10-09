package AppHoocks;


import io.cucumber.java.*;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.File;
import java.io.IOException;

import static Utils.BrowsserSetup.getDriver;





public class ApplicationsHoocks {
    WebDriver driver = getDriver();



//    @Before
//    public void getBrowser() throws IOException {
//        setDriver(new ChromeDriver());
//        driver = getDriver();
//        driver.manage().window().maximize();
//
//    }
//    WebDriver driver = getDriver();



    @After
    public void takeScraenshotOnFailure(Scenario scenario) {
        if(scenario.isFailed()){
            System.out.println("after senario this happend");
            System.out.println("senario failed :" + scenario.getName());
            final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

    }

//    @After(order = )
//    public void teardown(){
//
//    }





}
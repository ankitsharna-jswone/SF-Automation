package Stepdefination.Ordercreation;

import org.openqa.selenium.WebDriver;

import static Utils.Functionalities.*;

public class SKUPage {
    WebDriver driver;

    public SKUPage(WebDriver driver){
        this.driver = driver;
    }

    public void opportunityPage(){
        waitLocatedXpath("//slot[contains(text(),'OP') and @lwc-47ngqe6rvah]");
        clickingTool(xpathELem("//slot[contains(text(),'OP') and @lwc-47ngqe6rvah]"));
    }
}

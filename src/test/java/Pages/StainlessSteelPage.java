package Pages;


import org.openqa.selenium.WebDriver;

import static Utils.Functionalities.*;

//Ador SUPERINOX 1C E308L-16 Stainless Steel Welding Electrode
public class StainlessSteelPage {
    WebDriver driver;
    public StainlessSteelPage(WebDriver driver){
        this.driver = driver;
    }

    public void setBoxsizes(String value,int index){
        waitLocatedXpaths("//label[text()= 'Box size (kg)']/following-sibling::div//input");
        xpathELems("//label[text()= 'Box size (kg)']/following-sibling::div//input").get(index).sendKeys(value);
    }
}

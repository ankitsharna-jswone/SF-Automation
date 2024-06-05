package Pages;

import org.openqa.selenium.WebDriver;

import static Utils.Functionalities.*;

public class GreenPopup {
    public GreenPopup(WebDriver driver) {
    }

    public void greenPopupChecker(String text){
        waitLocatedXpath("//span[@class='toastMessage forceActionsText' and text()='" + text + "']");
    }

}

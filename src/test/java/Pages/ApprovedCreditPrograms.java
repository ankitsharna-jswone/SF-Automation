package Pages;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static Utils.BrowsserSetup.*;
import static Utils.Functionalities.*;

public class ApprovedCreditPrograms {

    WebDriver driver = getDriver();

    public List<String> CreditProgramName(){
        waitLocatedXpath("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText']");
        List<WebElement> CreditPrograms =  xpathELems("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText']");

        List<String> CreditProgramsNames  = new ArrayList<>();

        for(WebElement element : CreditPrograms){
            CreditProgramsNames.add(element.getText());
        }

        return CreditProgramsNames;
    }

    public String CrdeitProgramName (String CreditName){
        waitLocatedXpath("//span[@slot='title' and text()='" + CreditName +"']");
        return xpathELem("//span[@slot='title' and text()='" + CreditName +"']").getText();
    }


    public String UsableLimitAmount(String CreditName){
        waitLocatedXpath("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='"+ CreditName  +"']" +
                "/following-sibling::div[@c-approvedcreditprogram_approvedcreditprogram]" +
                "/lightning-formatted-number[@c-approvedcreditprogram_approvedcreditprogram ]");
        return xpathELem("//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='"+ CreditName  +"']" +
                "/following-sibling::div[@c-approvedcreditprogram_approvedcreditprogram]" +
                "/lightning-formatted-number[@c-approvedcreditprogram_approvedcreditprogram ]").getText();
    }

    public String SanctionedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()=' Sanctioned']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()=' Sanctioned']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String UtilisedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Utilised']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Utilised']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String AvailableAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Available']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        JavaScriptScroll(xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Available']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number"));
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Available']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String BlockedAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Blocked']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Blocked']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String UsableAmount(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Usable']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Usable']" +
                "/following-sibling::td[@class ='boldText']//lightning-formatted-number").getText();
    }

    public String CreditExpiryDate(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Expires on']/following-sibling::td//lightning-formatted-date-time");
        String expiryDateString = xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Expires on']/following-sibling::td//lightning-formatted-date-time").getText();


        SimpleDateFormat inputFormat = new SimpleDateFormat("d/M/yyyy, hh:mm a");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {

            Date date = inputFormat.parse(expiryDateString);


            return outputFormat.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public String CreditDueDays(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td").getText();
    }

    public String PenalRate(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Penal Rate']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Due Days']/following-sibling::td").getText();
    }

    public String CreditLimitBlock(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block']/following-sibling::td").getText();
    }

    public String CreditLimitBlockReason(String CreditName){
        waitLocatedXpath("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block Reason']/following-sibling::td");
        return xpathELem("//div[@class='slds-card__header slds-grid' and .//span[@c-approvedcreditprogram_approvedcreditprogram and @class='largeText' and text()='" + CreditName + "']]" +
                "/following-sibling::div//td[text()='Credit Limit Block Reason']/following-sibling::td").getText();
    }

//    public void CreditDetialsJSON(String creditName){
//        Map<String, String> CreditDetials = new HashMap<>();
//        CreditDetials.put("CreditProgramName", CrdeitProgramName(creditName));
//        CreditDetials.put("UsableLimit", UsableLimitAmount(creditName));
//        CreditDetials.put("SanctionedAmount", SanctionedAmount(creditName));
//        CreditDetials.put("UtilisedAmount", UtilisedAmount(creditName));
//        CreditDetials.put("AvailableAmount", AvailableAmount(creditName));
//        CreditDetials.put("BlockedAmount", BlockedAmount(creditName));
//        CreditDetials.put("UsableAmount", UsableAmount(creditName));
//        CreditDetials.put("CreditExpiryDate", CreditExpiryDate(creditName));
//        CreditDetials.put("CreditDueDays", CreditDueDays(creditName));
//        CreditDetials.put("PenalRate", PenalRate(creditName));
//        CreditDetials.put("CreditLimitBlock", CreditLimitBlock(creditName));
//        CreditDetials.put("CreditLimitBlockReason", CreditLimitBlockReason(creditName));
//
//        Gson gson = new Gson();
//        String json = gson.toJson(CreditDetials);
//
//        String filePath = "src/test/resources/ApiResponse/ApprovedCreditProgram.json";
//        try (FileWriter writer = new FileWriter(filePath)) {
//            writer.write(json);
//            System.out.println("JSON file created: " + filePath);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


}

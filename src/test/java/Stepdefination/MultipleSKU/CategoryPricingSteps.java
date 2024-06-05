package Stepdefination.MultipleSKU;

import Pages.MultiProcessOpportunitypage;
import Pages.ProcessOpportunity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

import java.util.List;
import java.util.Map;

import static Utils.BrowsserSetup.getDriver;




public class CategoryPricingSteps {
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());
    MultiProcessOpportunitypage multiProcessOpportunitypage = new MultiProcessOpportunitypage(getDriver());


    @Given("User at the Opportunity page and clicks on the process opportunity")
    public void openProcessOpportunityForCategoryPricing(){
        processOpportunity.processOpportunitybutton();
    }

    @And("Gave Category pricing for each product")
    public void setCategoryPricingfromTable(DataTable dataTable){
        List<Map<String,String>> SellerData = dataTable.asMaps(String.class,String.class);
        List<String> names = multiProcessOpportunitypage.getProductsNames();

        for(int i=0;i<names.size();i++) {
            String name = names.get(i);
            for (int j = 0; j < names.size(); j++) {
                Map<String, String> seller = SellerData.get(j);
                System.out.println(seller.get("Product") + " procuct name is this ");
                if (name.contains(seller.get("Product"))) {
//                   System.out.println(seller.get("Seller") + " seller of the product is at index j " + j + " : product  is" + seller.get("Product") + " index of i is" + i) ;
                    multiProcessOpportunitypage.categoryPrices(seller.get("CategoryPrice"), i);
                    break;
                }
            }
        }
    }

    @And("Gave Customer Accepted pricing for each product")
    public void setCustomerAccptedPrice(DataTable dataTable){
        List<Map<String,String>> SellerData = dataTable.asMaps(String.class,String.class);
        List<String> names = multiProcessOpportunitypage.getProductsNames();

        for(int i=0;i<names.size();i++) {
            String name = names.get(i);
            for (int j = 0; j < names.size(); j++) {
                Map<String, String> seller = SellerData.get(j);
                if (name.contains(seller.get("Product"))) {
//                   System.out.println(seller.get("Seller") + " seller of the product is at index j " + j + " : product  is" + seller.get("Product") + " index of i is" + i) ;
                    multiProcessOpportunitypage.customerFinalPrices(seller.get("CustomerPrice"), i);
                    break;
                }
            }
        }

    }



}

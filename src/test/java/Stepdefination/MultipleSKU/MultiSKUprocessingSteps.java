package Stepdefination.MultipleSKU;

import Pages.MultiProcessOpportunitypage;
import Pages.StainlessSteelPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.en_scouse.An;
import io.cucumber.java.it.Ma;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Map;

import static Utils.BrowsserSetup.getDriver;

public class MultiSKUprocessingSteps {
      MultiProcessOpportunitypage multiProcessOpportunitypage = new MultiProcessOpportunitypage(getDriver());


  @Given("Sales team gives the seller for each product")
        public void chooseSellerPerProduct(DataTable data) throws InterruptedException {
          List<Map<String,String>> SellerData = data.asMaps(String.class,String.class);
          List<String> names = multiProcessOpportunitypage.getProductsNames();

         for(int i=0;i<names.size();i++){
           String name = names.get(i);
           for(int j =0 ;j<names.size();j++){
               Map<String,String> seller = SellerData.get(j);
               if(name.contains(seller.get("Product"))){
//                   System.out.println(seller.get("Seller") + " seller of the product is at index j " + j + " : product  is" + seller.get("Product") + " index of i is" + i) ;
                   multiProcessOpportunitypage.selectSourceSellers(seller.get("Seller"),i);
                   break;
               }
           }

         }

        }

        @And("Sales team give the cost price to the category")
        public void setCostPricing(DataTable dataTable){
            List<Map<String,String>> SellerData = dataTable.asMaps(String.class,String.class);
            List<String> names = multiProcessOpportunitypage.getProductsNames();

            for(int i=0;i<names.size();i++) {
                String name = names.get(i);
                for (int j = 0; j < names.size(); j++) {
                    Map<String, String> seller = SellerData.get(j);
                    if (name.contains(seller.get("Product"))) {
//                   System.out.println(seller.get("Seller") + " seller of the product is at index j " + j + " : product  is" + seller.get("Product") + " index of i is" + i) ;
                        multiProcessOpportunitypage.editCostPrices(seller.get("cost"), i);
                        break;
                    }
                }
            }
        }

        @And("Sales team selected the colour")
        public void select_the_colour(DataTable dataTable){
            List<Map<String,String>> SellerData = dataTable.asMaps(String.class,String.class);
            List<String> names = multiProcessOpportunitypage.getProductsNames();

            for(int i=0;i<names.size();i++) {
                String name = names.get(i);
                for (int j = 0; j < names.size(); j++) {
                    Map<String, String> seller = SellerData.get(j);
                    if (name.contains(seller.get("Product"))) {
//                   System.out.println(seller.get("Seller") + " seller of the product is at index j " + j + " : product  is" + seller.get("Product") + " index of i is" + i) ;
                        multiProcessOpportunitypage.selectColour(seller.get("colour"), i);
                        break;
                    }
                }
            }

        }

        @And("Fills the {string} box size for steel")
        public void setBoxSize(String size){
            StainlessSteelPage stainlessSteelPage = new StainlessSteelPage(getDriver());
                stainlessSteelPage.setBoxsizes(size,0);
        }
}

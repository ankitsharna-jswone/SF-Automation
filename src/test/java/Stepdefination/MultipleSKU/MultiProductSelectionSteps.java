package Stepdefination.MultipleSKU;

import Pages.MultipleSKUcreationPage;
import Pages.ProcessOpportunity;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import io.cucumber.java.it.Ma;

import javax.xml.transform.Source;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static Utils.BrowsserSetup.getDriver;

public class MultiProductSelectionSteps {
    ProcessOpportunity processOpportunity = new ProcessOpportunity(getDriver());
    MultipleSKUcreationPage multipleSKUcreationPage = new MultipleSKUcreationPage(getDriver());

    @And("Add multiple products in SKU according to given Data")
    public void addMultipleProduct(DataTable products) throws InterruptedException {
        List<Map<String, String>> productsData = products.asMaps(String.class, String.class);


        for(int i=0;i<productsData.size();i++){
            processOpportunity.addButton();
        }
        int ind =0;
        int len =0;
        int dia =0;

        for(int i =0;i<productsData.size();i++){
            System.out.println(i);
            System.out.println(productsData.size());
            Map<String,String> Values = productsData.get(i);
            String name = Values.get("Product");

            if(name.contains("Coil")){
                String Quantity = Values.get("Quantity");
                String UOM     = Values.get("UOM");
                String Thickness = Values.get("Thickness");
                String Width = Values.get("Width");
                String Length = Values.get("Length");
                multipleSKUcreationPage.searchProducts(name,0);
                multipleSKUcreationPage.selectProduct(name);
                multipleSKUcreationPage.setQuantity(Quantity,ind);
                multipleSKUcreationPage.setThickness(Thickness);
                multipleSKUcreationPage.selectWidhts("1250",ind);
                ind++;
                System.out.println("For Coil data is " + Quantity + " - " + UOM + " - " + Thickness + " - " + Width + " - " + Length +  " ; ");
            } else if (name.contains("Sheet")) {
                String Quantity = Values.get("Quantity");
                String UOM     = Values.get("UOM");
                String Thickness = Values.get("Thickness");
                String Width = Values.get("Width");
                String Length = Values.get("Length");

                multipleSKUcreationPage.searchProducts(name,0);
                multipleSKUcreationPage.selectProduct(name);
                multipleSKUcreationPage.setQuantity(Quantity,ind);
                multipleSKUcreationPage.setThickness(Thickness);
                multipleSKUcreationPage.selectWidhts(Width,ind);
                multipleSKUcreationPage.setLengths(Length,len);
                len++;
                ind++;

                System.out.println("For Coil data is " + Quantity + " - " + UOM + " - " + Thickness + " - " + Width + " - " + Length +  " ; ");
            }
            else if (name.contains("Pipe")){
                String Quantity = Values.get("Quantity");
                String UOM     = Values.get("UOM");
                String Thickness = Values.get("Thickness");
                String Width = Values.get("Width");
                String Length = Values.get("Length");

                multipleSKUcreationPage.searchProducts(name,0);
                multipleSKUcreationPage.selectProduct(name);
                multipleSKUcreationPage.setQuantity(Quantity,ind);
                multipleSKUcreationPage.setThickness(Thickness);
                multipleSKUcreationPage.setLengths(Length,len);
                len++;
                ind++;
                System.out.println("For Coil data is " + Quantity + " - " + UOM + " - " + Thickness + " - " + Width + " - " + Length +  " ; ");
            } else if (name.contains("Stainless Steel")) {
                String Quantity = Values.get("Quantity");
                String UOM     = Values.get("UOM");
                String Thickness = Values.get("Thickness");
                String Length = Values.get("Length");
                String Width = Values.get("Width");
//                String Diameter = Values.get("Diameter");

                multipleSKUcreationPage.searchProducts(name,0);
                multipleSKUcreationPage.selectProduct(name);
                multipleSKUcreationPage.setQuantity(Quantity,ind);
                multipleSKUcreationPage.setThickness(Thickness);
                multipleSKUcreationPage.selectWidhts(Width,ind);
                multipleSKUcreationPage.setLengths(Length,len);
                ind++;
            }
        }
    }
}

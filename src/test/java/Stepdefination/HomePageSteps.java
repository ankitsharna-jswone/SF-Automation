package Stepdefination;

import Pages.HomePage;
import io.cucumber.java.en.Given;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @Given("User clicks on the App section of Salesforce")
    public void User_clicks_on_App_launcher(){
        homePage.Applauncher();
    }

    @Given("User searches for the {string} for work")
    public void user_searches_for_app(String string){
        homePage.AppSearchingBox(string);
    }

    @Given("User selects the {string}")
    public void user_selects_app( String string){
        homePage.SelectApp(string);
    }

}

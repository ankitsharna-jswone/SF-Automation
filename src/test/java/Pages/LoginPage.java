package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Utils.Functionalities.waitFor;


public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void usernameSF(String user){
        WebElement username = driver.findElement(By.cssSelector("input#username"));
        waitFor(username);
        username.sendKeys(user); //"v_ankit.sharma@jsw.in"
    }

    public void passwordSF(String pass){
        WebElement password = driver.findElement(By.cssSelector("input#password"));
        waitFor(password);
        password.sendKeys(pass); //"@Ankit123"
    }


    public void loginSF(){
        WebElement loginButton = driver.findElement(By.cssSelector("input#Login"));
        waitFor(loginButton);
        loginButton.click();
    }

}

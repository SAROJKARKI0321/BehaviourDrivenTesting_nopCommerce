package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Home extends  BasePage{



    @FindBy(xpath = "//a[normalize-space()=\"Log in\"]")
    WebElement loginButton;

    @FindBy(xpath = "//a[normalize-space()=\"Register\"]")
    WebElement registerButton;

    //nopCommerce demo store. Home page title

    public Login clickLogin(){
        waitforClickability(loginButton);
        loginButton.click();
        return new Login();

    }
    public  Register clickRegister(){
        waitforClickability(registerButton);
        registerButton.click();
        return new Register();
    }



}

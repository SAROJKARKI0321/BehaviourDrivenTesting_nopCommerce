package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login extends BasePage {



    @FindBy(xpath = "//input[@id=\"Email\"]")
    WebElement emailField;

    @FindBy(xpath = "//input[@id=\"Password\"]")
    WebElement passwordField;
    @FindBy(xpath = "//button[normalize-space()=\"Log in\"]")
    WebElement loginButton;

    public  Home login(String email,String password){
        waitForVisibility(emailField);
        emailField.clear();
        emailField.sendKeys(email);
        passwordField.clear();
        passwordField.sendKeys(password);
        loginButton.click();
        return new Home();


    }


}
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Register extends  BasePage {



    @FindBy(xpath ="//input[@id=\"FirstName\"]" )
    WebElement firstnameField;
    @FindBy(xpath = "//input[@id=\"LastName\"]")
    WebElement lastnameField;

    @FindBy(xpath = "//input[@id=\"Email\"]")
    WebElement emailField;
    @FindBy(xpath ="//input[@id=\"Password\"]" )
    WebElement passwordField;
    @FindBy(xpath ="//input[@id=\"ConfirmPassword\"]" )
    WebElement confirmPassowrdField;

    @FindBy(xpath = "//button[@id=\"register-button\"]")
    WebElement registerButton;

    public  void Register(String fname,String lname, String email, String password,String confirmPassword) {
        waitForVisibility(firstnameField);
        firstnameField.sendKeys(fname);
        lastnameField.sendKeys(lname);
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        confirmPassowrdField.sendKeys(confirmPassword);

    }
    public RegistrationSuccess clickRegister(){
        waitforClickability(registerButton);
        registerButton.click();

        return new RegistrationSuccess();
    }


}

package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationSuccess extends BasePage{
    boolean isVisible;


    @FindBy(xpath ="//a[normalize-space()=\"Continue\"]" )
    WebElement continueButton;

    private By sucessMessageLocator=By.xpath("//div[@class=\"result\"]");


    public  boolean isRegistrationSucessMessageDisplayed() {

        WebElement sucessMsg = driver.findElement(sucessMessageLocator);
        waitForVisibility(sucessMsg);
        return sucessMsg.getText().equalsIgnoreCase("Your registration completed");

    }
    public  Home clickContinue(){
        waitforClickability(continueButton);
        continueButton.click();
        return  new Home();








    }
}

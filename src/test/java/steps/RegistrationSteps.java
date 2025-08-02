package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Home;
import pages.Register;
import pages.RegistrationSuccess;
import utils.DriverManager;

public class RegistrationSteps {
    private WebDriver driver= DriverManager.getDriver();
    private Home homepage;
    private Register registerPage;
    private RegistrationSuccess registrationSuccessPage;

    @Given("I am on a registration page")
    public void i_am_on_a_registration_page() {
        homepage = new Home();
        homepage.openUrl("https://demo.nopcommerce.com/");
        registerPage = homepage.clickRegister();

    }

    @When("I enter my firstname {string}, lastname {string}, email {string}, password {string}, confirmpassword {string}")
    public void i_enter_my_registration_details(String fname, String lname, String email, String password, String confirmpassword) {
        registerPage.Register(fname, lname, email, password, confirmpassword);
    }
    @And("I click register")
        public void i_click_register(){
        registrationSuccessPage=registerPage.clickRegister();

        }
        @Then("I should see registration complete message")
    public void i_should_see_registration_complete_message() {
            Assert.assertTrue(registrationSuccessPage.isRegistrationSucessMessageDisplayed());

    }
}

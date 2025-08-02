package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.Home;
import pages.Login;
import utils.DriverManager;

public class LoginSteps {
    private WebDriver driver= DriverManager.getDriver();
    private Home homepage;
    private Login loginpage;

    @Given("I am on login page")
    public  void i_am_on_a_login_page(){
        homepage=new Home();
        homepage.openUrl("https://demo.nopcommerce.com/");
        loginpage=homepage.clickLogin();



    }
    @When("I login with {string} and {string}")
    public  void i_login_with_and(String username,String password){
       homepage= loginpage.login(username,password);

    }
    @Then("I should see home page")
    public void i_should_see_home_page(){
        String title= homepage.getPageTitle();
        Assert.assertTrue(title.toLowerCase().contains("nopcommerce"),"Home page not displayed");

    }

}

package hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp(){

        DriverManager.setDriver("chrome");
        WebDriver driver=DriverManager.getDriver();

       //use config files later on

    }
    @After
    public  void teardown(Scenario scenario){
        if(scenario.isFailed()){
            byte[] screenshot= ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png","Failed Screenshot");


        }
        DriverManager.quitDriver();
    }
}

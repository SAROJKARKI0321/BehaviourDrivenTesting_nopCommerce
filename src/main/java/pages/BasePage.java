package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(){
        this.driver= DriverManager.getDriver();
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    public String getPageTitle(){
        return driver.getTitle();

    }
    public void openUrl(String url) {
        driver.get(url);
    }
    public  void waitforClickability(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));

    }
    public  void waitForVisibility(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));

    }
    public void scrollIntoView(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);",element);
    }
    public  void jsClick(WebElement element){
        ((JavascriptExecutor)driver).executeScript("arguments[0].click();",element);

    }
    public String getScreenshot(String scenaironame){
        try {
            TakesScreenshot ts=(TakesScreenshot) driver;
            byte[] screenshot =ts.getScreenshotAs(OutputType.BYTES);
            String timestamp= LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss"));
            String fileName=scenaironame.trim().replace("_","")+"_"+timestamp+".png";
            String screenshotPath= ("target/screenshots/"+fileName);

            Path path= Paths.get(screenshotPath);
            Files.createDirectories(path.getParent());
            Files.write(Paths.get(screenshotPath), screenshot);
            return screenshotPath;

        } catch (IOException e) {
            throw new RuntimeException("Unable to save screenshot");
        }
    }
}

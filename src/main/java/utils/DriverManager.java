package utils;

import org.openqa.selenium.WebDriver;

public class DriverManager {
    private  static  final ThreadLocal<WebDriver> driverInstance=new ThreadLocal<>();

    public  static WebDriver getDriver(){
        return driverInstance.get();
    }
    public  static  void setDriver(String browser){
        WebDriver driver=DriverFactory.createInstance(browser);
        driverInstance.set(driver);
    }
    public  static  void quitDriver(){
        if(driverInstance.get()!=null){
            driverInstance.get().quit();
            driverInstance.remove();
        }
    }
}

package configuration;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.net.MalformedURLException;
import java.net.URL;


public class AppiumConfiguration {
    protected static AppiumDriver<MobileElement> driver;
    //appium driver hochet znat s chem on rabotaet
    //on mojet rabotat tolko s android elementami: AndroidElement/IOSElement/MobileElement

   protected Logger logger= LoggerFactory.getLogger(AppiumConfiguration.class);


    @BeforeSuite //doljno bit soedenenie s appiumom
    public void setUp() throws MalformedURLException {
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Nex");
        logger.info("device Nex");
        capabilities.setCapability("platformName", "Android");
        logger.info("platform Android");
        capabilities.setCapability("platformVersion","8.0");
        capabilities.setCapability("appPackage","com.example.svetlana.scheduler");
        capabilities.setCapability( "appActivity",".presentation.splashScreen.SplashScreenActivity");
        capabilities.setCapability("automationName","Appium");

        driver=new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }


    @AfterSuite
    public void tearDown() {
        driver.quit();
    }
}

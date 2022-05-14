package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.support.FindBy;

public class SplashScreen extends BaseScreen {


    public SplashScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
//nujno opisivat polia kot-e mi vidim
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/app_version_res']")
    // @FindBy (xpath = "//*[@id='com.example.svetlana.scheduler:id/app_version_res']")
    MobileElement versionTextView;//


    public String getCurrencyVersion(){//doljni vernit text
        return versionTextView.getText();
    }

    public LoginScreen checkVersion(String version){
       // shouldHave(versionTextView,10,version);//check version
        return new LoginScreen(driver);
    }

}

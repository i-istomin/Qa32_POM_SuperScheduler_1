package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Auth;
import org.openqa.selenium.support.FindBy;

public class LoginScreen extends BaseScreen {

    public LoginScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_email_input']")
    MobileElement emailEditText;

    @FindBy(xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/log_password_input']")
    MobileElement passwordEditText;

    @FindBy (xpath = "//*[@resource-id='com.example.svetlana.scheduler:id/login_btn']")
    MobileElement loginButton;

    public LoginScreen fillEmail(String email){
       pause(6000);
          should(emailEditText,60);// vizivaem metod poka ne poyavitsia moy element
        type(emailEditText,email);// type email
        return this; // return new LoginScreen(driver);
    }



    public LoginScreen fillPassword(String password){
      type(passwordEditText,password);
        return this;
    }

    public HomeScreen submitLogin(){
        driver.hideKeyboard();
        loginButton.click();//click
        return new HomeScreen(driver);
    }

    public HomeScreen complexLogin(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new HomeScreen(driver);
    }

    public WizardScreen complexRegistration(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
    }


    public WizardScreen complex(Auth auth){

        should(emailEditText,15);
        type(emailEditText,auth.getEmail());
        type(passwordEditText, auth.getPassword());
        driver.hideKeyboard();
        loginButton.click();

        return new WizardScreen(driver);
    }
}

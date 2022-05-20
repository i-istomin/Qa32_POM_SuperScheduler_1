package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.annotations.Test;
import screens.LoginScreen;

public class RegistrationTests extends AppiumConfiguration {


    @Test  //ira@gmail.com +  Iraa777!
    public void registrationSuccess() {

        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new LoginScreen(driver).
                complexRegistration(Auth.builder().email("ira"+i+"@gmail.com").password(" Iraa777!").build())
                .skipWizard()
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }

    @Test
    public void loginRegistrationSuccess(){

        new LoginScreen(driver)
                .complex(Auth.builder().email("ira09@gmail.com").password("Iraa777!").build())//kajdiy raz nujno meniat email
                .skipIfWizard2()
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }

}

package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.LoginScreen;

import java.lang.reflect.Method;

public class RegistrationTests extends AppiumConfiguration {

    @BeforeMethod
    public void precondition(Method m) {
        logger.info(("Start test" + m.getName()));
    }
    @Test  //ira@gmail.com +  Iraa777!
    public void registrationSuccess() {
      logger.info("Starting 'loginRegistrationSuccess' ");
        int i = (int)(System.currentTimeMillis()/1000)%3600;
        new LoginScreen(driver).
              //  complexRegistration(Auth.builder().email("ira"+i+"@gmail.com").password(" Iraa777!").build())
        complexRegistration(Auth.builder().email("noa"+i+"@gmail.com").password("Nnoa12345$").build())
                .skipWizard()
                .checkFabButtonPresent()
                .openMenu()
                .logout();

        logger.info("Test 'registrationSuccess' passed successfully");
    }

//    @Test
//    public void loginRegistrationSuccess(){
//        logger.info("Starting 'loginRegistrationSuccess' ");
//        new LoginScreen(driver)
//                .complex(Auth.builder().email("ira11@gmail.com").password("Iraa777!").build())//kajdiy raz nujno meniat email
//                .skipIfWizard2()
//                .checkFabButtonPresent()
//                .openMenu()
//                .logout();
//        logger.info("Test 'loginRegistrationSuccess' passed successfully");
//    }

}

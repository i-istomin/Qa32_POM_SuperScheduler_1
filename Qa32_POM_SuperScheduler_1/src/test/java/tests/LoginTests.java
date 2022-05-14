package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.LoginScreen;
import screens.SplashScreen;

public class LoginTests extends AppiumConfiguration {


    @Test
    public void loginSuccess() {
   //     boolean isFabButtonPresent =
           new SplashScreen(driver).checkVersion("0.0.3")
//        boolean isFabButtonPresent =new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin();
             //   .isFabPlusPresent();

        //Assert.assertTrue(isFabButtonPresent);


//        new HomeScreen(driver)
//                .openMenu()
//                .logout();


    }

    @Test
    public void loginSuccessHomeWork(){
       new SplashScreen(driver)
                .checkVersion("0.0.3")
      //  new LoginScreen(driver)
              //  .complexLogin(Auth.builder()
                        .email("noa@gmail.com")
                        .password("Nnoa12345$").build())
                .checkFabButtonPresent();
//                .openMenu()
//                .logout();

    }
    }


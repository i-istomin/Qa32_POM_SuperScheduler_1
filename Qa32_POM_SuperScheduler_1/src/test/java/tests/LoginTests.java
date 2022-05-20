package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

public class LoginTests extends AppiumConfiguration {

    @Test
    public void loginSuccess() {
//
//        boolean isFabButtonPresent = new SplashScreen(driver)
//                .checkVersion("0.0.3")
        boolean isFabButtonPresent = new LoginScreen(driver)
                .fillEmail("noa@gmail.com")
                .fillPassword("Nnoa12345$")
                .submitLogin()
                .isFabPlusPresent();

        Assert.assertTrue(isFabButtonPresent);


        new HomeScreen(driver)
                .openMenu()
                .logout();

    }


    @Test
    public void loginSuccessHomeWork() {
//        new SplashScreen(driver)
//                .checkVersion("0.0.3")
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .checkFabButtonPresent()
                .openMenu()
                .logout();
    }


    @Test
    public void loginSuccessHomeWork2() {
        logger.info("From 'loginSuccessHomeWork2' -> test start with data:");
        new LoginScreen(driver).
                complexLogin(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .checkFabButtonPresent()
              .openMenu()
              .logout();

    }


    @Test  /// wick@gmail.com Nnoa12345$  ---> wrong email or password
    //ira@gmail.com +  Iraa777!
    public void loginCheckErrorMessage() {

        new LoginScreen(driver)
//                .fillPassword("wick@gmail.com")
//                .fillEmail("Nnoa12345$")
                .fillEmail("ira@gmail.com")
                .fillPassword("Iraa777!")
                .submitLoginNegative()
                .checkErrorMessage("wrong email or password")
                .confirmErrorMessage();

    }

    @Test
    public void loginComplexErrorMessage() {
        boolean isLoginBtnPresent = new LoginScreen(driver)
                .complexLoginWithErrorException(Auth.builder()
                        .email("ira@gmail.com")//.email("wick@gmail.com").password("Nnoa12345$").
                        .password("Iraa777!")
                        .build())
                .checkErrorMessage("wrong email or password")
                .confirmErrorMessage()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginBtnPresent);
    }

    @AfterMethod(enabled = false)
    public void postCondition() {
        new HomeScreen(driver)
                .openMenu()
                .logout();
    }
}
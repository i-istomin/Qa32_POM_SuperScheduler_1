package tests;

import configuration.AppiumConfiguration;
import configuration.MyDataProvider;
import models.Auth;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

import java.lang.reflect.Method;

public class LoginTests extends AppiumConfiguration {
    @BeforeMethod
    public void precondition(Method m) {
        logger.info(("Start test" + m.getName()));
    }

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
        logger.info("Test 'loginSuccessNew' passed successfully");

    }


    @Test(dataProvider = "loginData", dataProviderClass = MyDataProvider.class)
    public void loginSuccessHomeWork(Auth auth) {
//        new SplashScreen(driver)
//                .checkVersion("0.0.3")
        logger.info("from login test:" + auth.toString());
        new LoginScreen(driver)
                // .complexLogin(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .complexLogin(auth)
                .checkFabButtonPresent()
                .openMenu()
                .logout();

        logger.info("Test 'loginSuccessHomeWork' passed successfully");
    }


    @Test(dataProvider = "loginDataCSV", dataProviderClass = MyDataProvider.class)
    public void loginSuccessHomeWork2(Auth auth) {
        logger.info("from login test:" + auth.toString());
        logger.info("From 'loginSuccessHomeWork2' -> starting test with data:");
        new LoginScreen(driver).
                complexLogin(auth)
                //.complexLogin(Auth.builder().email("noa@gmail.com").password("Nnoa12345$").build())
                .checkFabButtonPresent()
                .openMenu()
                .logout();
        logger.info("Test 'loginSuccessHomeWork2' passed successfully");
    }


    @Test  /// wick@gmail.com Nnoa12345$  ---> wrong email or password
    //ira@gmail.com +  Iraa777!
    public void loginCheckErrorMessage() {
        logger.info("Testing 'loginCheckErrorMessage' ");
        new LoginScreen(driver)
                .fillPassword("wick@gmail.com")
                .fillEmail("Nnoa12345$")
//                .fillEmail("ira@gmail.com")
//                .fillPassword("Iraa777!")
                .submitLoginNegative()
                .checkErrorMessage("wrong email or password")
                .confirmErrorMessage();
        logger.info("Test 'loginCheckErrorMessage' passed successfully");
    }

    @Test
    public void loginComplexErrorMessage() {
        logger.info("Testing 'loginComplexErrorMessage' ");
        boolean isLoginBtnPresent = new LoginScreen(driver)
                .complexLoginWithErrorException(Auth.builder()
                        // .email("ira@gmail.com")
                        // .password("Iraa777!")
                        .email("wick@gmail.com").
                        password("Nnoa12345$")
                        .build())
                .checkErrorMessage("wrong email or password")
                .confirmErrorMessage()
                .isLoginButtonPresent();

        Assert.assertTrue(isLoginBtnPresent);
        logger.info("Test 'loginComplexErrorMessage' passed successfully");
    }

    @AfterMethod(enabled = false)
    public void postCondition(Method m) {
        new HomeScreen(driver)
                .openMenu()
                .logout();
        logger.info("End of test" + m.getName());
    }
}
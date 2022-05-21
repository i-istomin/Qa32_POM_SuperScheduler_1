package tests;

import configuration.AppiumConfiguration;
import models.Auth;
import models.Event;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import screens.HomeScreen;
import screens.LoginScreen;

import java.lang.reflect.Method;

public class EventCreateTests extends AppiumConfiguration {

    @BeforeClass
    public void preConditions() {
        new LoginScreen(driver)
                .complexLogin(Auth.builder().email("wick@gmail.com").password("Ww12345$").build());

    }

    @BeforeMethod
    public void precondition(Method m) {
        logger.info(("Start test" + m.getName()));
    }

    @Test
    public void createNewEventsSuccess(Auth auth){
        logger.info("Test start with user -->  " + auth.toString());
        boolean isFabPlusPresent =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("TitleNew")
                        .type("NewType")
                        .breaks(3)
                        .wage(80).build())
                .isFabPlusPresent();
        Assert.assertTrue(isFabPlusPresent);

        logger.info("Test 'createNewEventsSuccess' passed successfully");


    }

    @Test
    public void createNewEventsSuccess2(Auth auth){
        logger.info("Test start with user -->  " + auth.toString());
        boolean isFabPlusPresent =  new HomeScreen(driver)
                .initCreationEvent()
                .createNewEvent(Event.builder()
                        .title("Party")
                        .type("Party type")
                        .breaks(2)
                        .wage(55).build())
                .isFabPlusPresent();
        Assert.assertTrue(isFabPlusPresent);

        logger.info("Test 'createNewEventsSuccess' passed successfully");
    }

    @AfterClass
    public void postConditions(Method m){
        new HomeScreen(driver)
                .openMenu()
                .logout();
        logger.info("End of test"+m.getName());
    }

}

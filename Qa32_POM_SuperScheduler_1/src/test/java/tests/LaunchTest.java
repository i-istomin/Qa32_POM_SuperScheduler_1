package tests;

import configuration.AppiumConfiguration;
import org.testng.Assert;
import org.testng.annotations.Test;
import screens.SplashScreen;

public class LaunchTest extends AppiumConfiguration {

    @Test//budet pustoy, bez koda
    public void launchTest() {
        String version = new SplashScreen(driver).getCurrencyVersion();//sozdaem perviy ekran
        Assert.assertEquals(version, "0.0.3");

    }
}

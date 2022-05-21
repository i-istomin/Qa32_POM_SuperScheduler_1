package configuration;

import com.google.common.io.Files;
import io.appium.java_client.events.api.general.AppiumWebDriverEventListener;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

//ne nasleduyutsie ot aapiuma, a implementiruetsia
//nujno vziat vse metodi, nevozmojno vibrat neskolko


public class MyListener implements AppiumWebDriverEventListener {

    Logger logger = LoggerFactory.getLogger(MyListener.class);


    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {

    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {

    }

    @Override
    public void afterNavigateBack(WebDriver driver) {

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {

    }

    @Override
    public void afterNavigateForward(WebDriver driver) {

    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {

    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("Before find by--->" + by);

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        logger.info("After find by--->" + by);

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {

    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {

    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {
        logger.info("You have a problem--->" + throwable.fillInStackTrace());
        //mi ne mohem vizvat na samom drivere screenshot.
        //mojno sdelat casting s pomoshiu  TakesScreenshot
        File tmp = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);//kajdiy raz zapisivaetsia noviy rezulatat v file. Kajdiy raz vitiraet proshliy raz
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        String path = "/home/i-istomin/TelRan/SYSTEMS/Qa32_POM_SuperScheduler_1/Qa32_POM_SuperScheduler_1/src/test/screenshots/screen-" + i + ".png";
        logger.info("screen with error by link--->" + path);


        File screen = new File(path);
        try {
            Files.copy(tmp,screen);//dobavili try/catch
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}

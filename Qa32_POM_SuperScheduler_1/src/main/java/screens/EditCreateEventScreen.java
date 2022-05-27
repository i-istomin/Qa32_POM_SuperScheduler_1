package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import models.Event;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public class EditCreateEventScreen extends BaseScreen {
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breaksPlusBtn;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;

    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='om.example.svetlana.scheduler:id/row_day_number_txt']")
    List<MobileElement> days;
    @FindBy(how = How.XPATH, using = "//*[@resource-id='com.example.svetlana.scheduler:id/row_month_txt']")
    List<MobileElement> months;


    public HomeScreen createNewEvent(Event event) {
        should(title, 10);//pust title otrisuetsia
        type(title, event.getTitle());//est obyekt u koy-go mojno vichetat pole i poluchit etot screen
        type(type, event.getType());
        driver.hideKeyboard();

        int breaks = event.getBreaks();

        if (breaks > 0 && breaks < 5) {
            for (int i = 0; i < breaks; i++) { //fori
                breaksPlusBtn.click();
            }
        }

        wageEdit.click();
        type(wageInput, String.valueOf(event.getWage())); //type s int a ne string
        wageSave.click();
        confirmCreation.click();
        return new HomeScreen(driver);
    }

    public EditCreateEventScreen actionData() {
        pause(3000);
        MobileElement elementDay = days.get(2);
        Rectangle rect = elementDay.getRect();

        logger.info("Width of last data element---> " + rect.getWidth());
        logger.info("Height of last data element---> " + rect.getHeight());
        logger.info(" 'X'  of last data element---> " + rect.getX());
        logger.info(" 'Y' of last data element---> " + rect.getY());

        logger.info("The width of screen--->" + driver.manage().window().getSize().getWidth());

        int xFrom = rect.getX() + rect.getWidth();
        int y = rect.getY() + rect.getHeight() / 2;
        int xTo = driver.manage().window().getSize().getWidth() / 2;

        TouchAction<?> touchAction = new TouchAction<>(driver);
        touchAction.longPress(PointOption.point(xFrom, y))
                .moveTo(PointOption.point(xTo, y))
                .release()//sobrat
                .perform();//vipolnit

        return this;
    }

    public EditCreateEventScreen selectData(String date) {//29/05/2022
        LocalDate inputDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy")); //29/05/2022
        LocalDate current = getLocalDate(days.get(0).getText(), months.get(0).getText());

        while (!inputDate.equals(current)) {
            actionData();
            pause(2000);
            current = getLocalDate(days.get(0).getText(), months.get(0).getText());
        }


        return this;
    }

    private LocalDate getLocalDate(String day, String month) {//24/MAY/2022--->m
        logger.info("To know that day--->" + days.get(0).getText());// --->24
        logger.info("To know that month--->" + months.get(0).getText());//---NAY
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MMMM/yyyy");


        // ofPattern("d/MMMM/yyyy"); MMMM-"May", "June"----"MAY"!="May";
        //month--->MAY--->May

        month=month.toLowerCase();//-->may
        month=month.substring(0,1).toUpperCase()+month.substring(1);//s kakogo chisla nachat, s kakogo zakonchit i iskluchit  pervoe chislo
//M+ay
        String m = day + "/" + month + "/" + "2022";//----> "24/MAY/2022"
        return LocalDate.parse(m, formatter);
    }
}

package screens;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import models.Event;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class EditCreateEventScreen extends BaseScreen{
    public EditCreateEventScreen(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_title_input']")
    MobileElement title;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_type_input']")
    MobileElement type;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_break_plus_btn']")
    MobileElement breaksPlusBtn;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_edit']")
    MobileElement wageEdit;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_input']")
    MobileElement wageInput;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_wage_save']")
    MobileElement wageSave;

    @FindBy(how = How.XPATH,using = "//*[@resource-id='com.example.svetlana.scheduler:id/info_save_btn']")
    MobileElement confirmCreation;


    public HomeScreen createNewEvent(Event event) {
        should(title,10);//pust title otrisuetsia
        type(title, event.getTitle());//est obyekt u koy-go mojno vichetat pole i poluchit etot screen
        type(type, event.getType());
        driver.hideKeyboard();

        int breaks=event.getBreaks();

        if (breaks>0 && breaks<5){
            for (int i = 0; i <breaks ; i++) { //fori
                breaksPlusBtn.click();
            }
        }

        wageEdit.click();
        type(wageInput,String.valueOf(event.getWage())); //type s int a ne string
        wageSave.click();
        confirmCreation.click();
        return new HomeScreen(driver);
    }
}

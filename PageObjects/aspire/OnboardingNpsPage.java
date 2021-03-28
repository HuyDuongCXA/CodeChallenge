package aspire;

import driverUltils.DriverUtils;
import org.openqa.selenium.StaleElementReferenceException;

public class OnboardingNpsPage extends GeneralPage {
    //locator
    private final String CONTINUE_BTN = "//button[@role='button']";
    private final String WE_ARE_ON_IT_LBL = "//div[@class='aspire-cta-screen__title q-mb-md text-weight-bolder text-h4']";

    //Methods
    public void clickContinueBtn(){
        DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
        try {

            for (int i=0;i<3;i++){
                String a = getElement(WE_ARE_ON_IT_LBL).getText().trim();
                if(a.equals("You are amazing and you know it")){
                    getElement(CONTINUE_BTN).click();
                }
                else{break;}
            }

        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            getElement(CONTINUE_BTN).click();
        }

    }

    public String getOnboardingText(){
      return  getElement(WE_ARE_ON_IT_LBL).getText().trim();    }

}

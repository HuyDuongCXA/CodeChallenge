package aspire;

import driverUltils.DriverUtils;
import org.openqa.selenium.ElementNotInteractableException;

public class EnterPhoneOtpPage extends LoginToAspirePage {
	
	//Locators
	private final String  RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
    private final String  OTP_TXT = "//input[@class='digit-input__input-real absolute']"; 
    
    // Methods
    public void enterPhoneOtp(UserInfo userInfo) {
        DriverUtils.waitForPageLoadedCompletely();
        DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);
  	    //getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());


        try {
            getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
        } catch (ElementNotInteractableException e) {
            getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
            e.printStackTrace();
        }
    }
}
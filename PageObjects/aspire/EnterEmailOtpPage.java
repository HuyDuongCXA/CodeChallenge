package aspire;

import driverUltils.DriverUtils;
import org.openqa.selenium.ElementNotInteractableException;

public class EnterEmailOtpPage extends GeneralPage {

		//Locators
		private final String  RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
	    private final String  OTP_TXT = "//input[@class='digit-input__input-real absolute']";
	    
	    // Methods
	    public void enterEmailOtp(UserInfo userInfo) {
	  	  //DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);
	  	  //getElement(OTP_TXT).sendKeys(userInfo.getEmailOtp());
			DriverUtils.waitForPageLoadedCompletely();
			DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);

			try {
				getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
			} catch (ElementNotInteractableException e) {
				getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
			}

	    }
}

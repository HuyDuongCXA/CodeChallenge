package aspire;

import driverUltils.DriverUtils;

public class EnterEmailOtpPage extends LoginToAspirePage {
	//Locators
	
		private final String  RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
	    private final String  OTP_TXT = "//input[@class='digit-input__input-real absolute']"; 
	    
	    // Methods
	    
	    public void enterEmailOtp(UserInfo userInfo) {
	  	  DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);
	  	  getElement(OTP_TXT).sendKeys(userInfo.getEmailOtp());
	    }
}

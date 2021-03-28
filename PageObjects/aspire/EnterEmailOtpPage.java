package aspire;

import driverUltils.DriverUtils;
import driver_wrapper.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

public class EnterEmailOtpPage extends GeneralPage {

		//Locators
		private final String  RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
	    private final String  OTP_TXT = "//input[@class='digit-input__input-real absolute']";
	    
	    // Methods
	    public void enterEmailOtp(UserInfo userInfo) {
			DriverUtils.waitForPageLoadedCompletely();
			DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);

			try {
				DriverManagement.getDriver().findElement(By.xpath(OTP_TXT)).sendKeys(userInfo.getEmailOtp());
			} catch (ElementNotInteractableException e) {
				DriverManagement.getDriver().findElement(By.xpath(OTP_TXT)).sendKeys(userInfo.getEmailOtp());
			}

	    }
}

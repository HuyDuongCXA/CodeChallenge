package aspire;

import driverUltils.DriverUtils;
import org.openqa.selenium.ElementNotInteractableException;

public class EnterPhoneOtpPage extends LoginToAspirePage {

    //Locators
    private final String RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
    private final String RESEND_OTP_IN_SECOND = "//p[@class='text-weight-medium text-subtitle2 text-grey-5']";
    private final String OTP_TXT = "//input[@class='digit-input__input-real absolute']";
    private final String UNFOCUSED_OTP_TXT = "//div[@class='digit-input__box flex justify-between no-wrap']";

    // Methods
    public void enterPhoneOtp(UserInfo userInfo) {
        DriverUtils.waitForPageLoadedCompletely();
        DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);

        try {
            getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
        } catch (ElementNotInteractableException e) {
            System.out.println("Phone OTP catch reached");
            getElement(RESEND_OTP_BTN).click();
            System.out.println("RESEND_OTP_BTN clicked");
            DriverUtils.waitForPageLoadedCompletely();
            DriverUtils.waitForElementDisplayed(RESEND_OTP_IN_SECOND);
            getElement(UNFOCUSED_OTP_TXT).click();
            System.out.println("UNFOCUSED_OTP_TXT clicked");
            getElement(OTP_TXT).sendKeys(userInfo.getPhoneOtp());
            System.out.println("Enter OTP successfully");
        }
    }
}
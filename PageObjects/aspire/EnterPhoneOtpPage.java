package aspire;

import driverUltils.DriverUtils;
import driver_wrapper.Driver;
import driver_wrapper.DriverManagement;
import element_wrapper.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;

public class EnterPhoneOtpPage extends GeneralPage {

    //Locators
    private final String RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
    private final String RESEND_OTP_IN_SECOND = "//p[@class='text-weight-medium text-subtitle2 text-grey-5']";
    private final String OTP_TXT = "//input[@class='digit-input__input-real absolute']";
    private final String UNFOCUSED_OTP_TXT = "//div[@class='digit-input__box flex justify-between no-wrap']";

    // Methods
    public void enterPhoneOtp(UserInfo userInfo) {
        DriverUtils.waitForPageLoadedCompletely();
        DriverUtils.waitForElementDisplayed(RESEND_OTP_BTN);
        DriverManagement.getDriver().findElement(By.xpath(OTP_TXT)).sendKeys(userInfo.getPhoneOtp());

        try {
            DriverManagement.getDriver().findElement(By.xpath(OTP_TXT)).sendKeys(userInfo.getPhoneOtp());
        } catch (ElementNotInteractableException e) {
            DriverManagement.getDriver().findElement(By.xpath(OTP_TXT)).sendKeys(userInfo.getPhoneOtp());

        }
    }
}
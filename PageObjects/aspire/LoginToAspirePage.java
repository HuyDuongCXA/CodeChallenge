package aspire;

import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;

import constant.Constant;
import driverUltils.DriverUtils;

public class LoginToAspirePage extends GeneralPage {
    UserInfo mobileInfo = new UserInfo();
    WebDriver driver;

    // Locators
    private final String COUNTRY_DROPDOWN = "//div[@class='q-field__append q-field__marginal row no-wrap items-center q-anchor--skip']";
    private final String PHONE_NUMBER_TXT = "//input[@data-cy='register-person-phone']";
    private final String LOGIN_BTN = "//button[@type='submit']";
    private final String RESEND_OTP_BTN = "//button[@data-cy='verify-otp-request-new']";
    private final String OTP_TXT = "//input[@class='digit-input__input-real absolute']";
    private final String FLAG_ICON = "//div[@class='q-img__content absolute-full']";
    private final String REGISTER_LINK = "//a[@class='text-primary text-bold login-step-start__register-link']";

    // Methods

    public void enterMobileNumber(UserInfo mobileInfo) {
        DriverUtils.waitForElementDisplayed(FLAG_ICON);
        getElement(PHONE_NUMBER_TXT).click();
        getElement(PHONE_NUMBER_TXT).sendKeys(mobileInfo.getPhoneNumber());
    }

    public void clickLoginBtn() {
        getElement(LOGIN_BTN).click();
    }

    public void clickRegisterLink() {
        DriverUtils.waitForElementDisplayed(FLAG_ICON);

        try {
            getElement(REGISTER_LINK).click();
        } catch (StaleElementReferenceException e) {
            Constant.WEBDRIVER.navigate().refresh();
            getElement(REGISTER_LINK).click();
        }

    }
}

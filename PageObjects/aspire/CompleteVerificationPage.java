package aspire;

import common.Common;
import constant.Constant;
import driverUltils.DriverUtils;
import driver_wrapper.DriverManagement;
import org.openqa.selenium.By;


public class CompleteVerificationPage extends GeneralPage {
    //Locators
    private final String UPLOAD_KTP_BTN = "(//input[@class='q-uploader__input overflow-hidden absolute-full'])[2]";
    private final String TEST = "//p[@class='q-mb-lg']";
    private final String CONTINUE_BTN = "//button[@role='button' and @isfixed='true']";
    private final String BEGIN_VERIFICATION_BTN = "//button[@role='button' and .='Begin Verification']";
    private final String GET_STARTED_BTN = "//button[@role='button' and .='Get Started']";
    private final String SELFIE_WITH_KTP_TEXT = "//div[@class='text-h5 text-bold']";
    private final String TAKE_A_SELFIE_BTN = "(//input[@class='q-uploader__input overflow-hidden absolute-full'])[2]";
    private final String TAKE_A_SELFIE_BTN2 = "//div[@class='aspire-card q-pa-md text-center q-card']//button[@role='button']";
    private final String SELFIE_CONTINUE_BTN = "//div[@class='q-page-sticky row flex-center aspire-cta-box aspire-cta fixed-bottom-right q-page-sticky--shrink aspire-cta-box--fixed']//button[@role='button']";
    private final String NEXT_PAGE_TEXT = "//div[@class='aspire-cta-screen__title q-mb-md text-weight-bolder text-h4']";

    //Methods
    public void UploadPhoto() {
        DriverManagement.getDriver().findElement(By.xpath(UPLOAD_KTP_BTN)).sendKeys(Common.getProjectPath() + "/Executables/Screenshot.png");
        //getElement(UPLOAD_KTP_BTN).sendKeys(Common.getProjectPath() + "/Executables/Screenshot.png");
    }

    public void clickBeginVerificationBtn() {
        DriverUtils.waitForElementDisplayed(GET_STARTED_BTN);
        getElement(GET_STARTED_BTN).click();

        DriverUtils.waitForElementDisplayed(BEGIN_VERIFICATION_BTN);
        getElement(BEGIN_VERIFICATION_BTN).click();
    }

    public void clickContinueBtn() {
        DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
        for (int i = 0; i < 3; i++) {
            String a = getElement(SELFIE_WITH_KTP_TEXT).getText().trim();
            if (a.equals("Front of KTP")) {
                getElement(CONTINUE_BTN).click();
            } else {
                break;
            }
        }
    }

    public void clickSelfieContinueBtn() {
        DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
        getElement(CONTINUE_BTN).click();
    }

    public String getSelfieWithKtpText() {
        DriverUtils.waitForElementDisplayed(SELFIE_WITH_KTP_TEXT);
        return getElement(SELFIE_WITH_KTP_TEXT).getText().trim();
    }

    public String getNextPageText() {
        DriverUtils.waitForElementDisplayed(SELFIE_WITH_KTP_TEXT);
        return getElement(NEXT_PAGE_TEXT).getText().trim();
    }

    public void uploadSelfiePhoto() {
        DriverManagement.getDriver().findElement(By.xpath(TAKE_A_SELFIE_BTN)).sendKeys(Common.getProjectPath() + "/Executables/Screenshot.png");
        //getElement(TAKE_A_SELFIE_BTN).sendKeys(Common.getProjectPath() + "/Executables/Screenshot.png");
    }
}

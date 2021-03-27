package aspire;

import common.Common;
import driverUltils.DriverUtils;


public class CompleteVerificationPage extends GeneralPage {
    //Locators
    private final String UPLOAD_KTP_BTN = "(//input[@class='q-uploader__input overflow-hidden absolute-full'])[2]";
    //private final String CONTINUE_BTN = "//button[@isfixed='true']";
    private String TEST = "//p[@class='q-mb-lg']";
    private final String CONTINUE_BTN = "//button[@role='button' and @isfixed='true']";
    private final String BEGIN_VERIFICATION_BTN = "//button[@role='button' and .='Begin Verification']";
    private final String GET_STARTED_BTN = "//button[@role='button' and .='Get Started']";
    private final String SELFIE_WITH_KTP_TEXT = "//div[@class='text-h5 text-bold']";

    //Methods
    public void UploadPhoto() {
        //DriverUtils.waitForElementDisplayed(UPLOAD_KTP_BTN);
        System.out.println("About to send photo ");
        getElement(UPLOAD_KTP_BTN).sendKeys(Common.getProjectPath() + "/Executables/Screenshot.png");
        System.out.println("Send photo successfully");
    }

    public void clickBeginVerificationBtn() {
        DriverUtils.waitForElementDisplayed(GET_STARTED_BTN);
        getElement(GET_STARTED_BTN).click();

        DriverUtils.waitForElementDisplayed(BEGIN_VERIFICATION_BTN);
        getElement(BEGIN_VERIFICATION_BTN).click();
        System.out.println("ClickVerifyButton successfully");
    }

    public void clickContinueBtn() {
        System.out.println("About to click continue button ");
        DriverUtils.waitForElementDisplayed(CONTINUE_BTN);
        for (int i=0;i<3;i++){
            String a = getElement(SELFIE_WITH_KTP_TEXT).getText().trim();
            if(a.equals("Front of KTP")){
                getElement(CONTINUE_BTN).click();
            }
            else{break;}
        }

    }

        public String getSelfieWithKtpText() {
            DriverUtils.waitForElementDisplayed(SELFIE_WITH_KTP_TEXT);
            return getElement(SELFIE_WITH_KTP_TEXT).getText().trim();
        }
    }

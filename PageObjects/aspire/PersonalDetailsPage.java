package aspire;

import driver_wrapper.Driver;
import driver_wrapper.DriverManagement;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import driverUltils.DriverUtils;
import utilities.Utilities;

public class PersonalDetailsPage extends LoginToAspirePage {


    //Locators
    private final String YES_CONTINUE_BTN = "//button[@class='q-btn q-btn-item non-selectable no-outline q-mt-md q-mb-md aspire-button q-btn--standard q-btn--rectangle bg-primary text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']";
    private final String STANDARD_GET_STARTED_BTN = "//button[@class='q-btn q-btn-item non-selectable no-outline aspire-button q-my-md q-btn--standard q-btn--rectangle bg-secondary text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']";
    private final String GET_STARTED_BTN = "//button[@class='q-btn q-btn-item non-selectable no-outline aspire-button aspire-button--cta q-btn--standard q-btn--rectangle bg-primary text-white q-btn--actionable q-focusable q-hoverable q-btn--wrap']";
    private final String YEAR_LBL = "//span[@class='block' and .='%s']";
    private final String WANTED_YEAR_LBL = "//span[@class='block' and .='%s']";
    private final String PREVIOUS_YEAR_ICON = "//i[@class='fas fa-chevron-left q-icon notranslate']";
    private final String MONTH_LBL = "//span[@class='block' and .='%s']";
    private final String WANTED_MONTH_LBL = "//span[@class='q-btn__content text-center col items-center q-anchor--skip justify-center row']//span[@class='block' and .='%s']";
    private final String WANTED_DAY_LBL = "//div[@class='q-date__calendar-days fit']//span[@class='block' and .='%s']";
    private final String DOB_CBB = "//input[@placeholder='Set your date of birth']";
    private final String ID_CARD_NUMBER_TXT = "//input[@placeholder='Provide your KTP number']";
    private final String NATIONALALITY_CBB = "//input[@placeholder='Select any of the following']";
    private final String NATION_LBL = "//div[@class='q-item__label' and .='%s']";
    private final String GENDER_CBB = "//input[@placeholder='Set your gender']";
    private final String GENDER_LBL = "//div[@class='q-item__label' and .='%s']";
    private final String INTEREST_DROPDOWN = "//div[@placeholder='Select your purpose of using Aspire']//i[@class='q-select__dropdown-icon fas fa-caret-down q-icon notranslate']";
    private final String INTEREST_DROPDOWN_REVERSE = "//div[@placeholder='Select your purpose of using Aspire']//i[@class='q-select__dropdown-icon rotate-180 fas fa-caret-down q-icon notranslate']";
    private final String INTEREST_CB = "//div[@class='q-item q-item-type row no-wrap q-item--clickable q-link cursor-pointer q-manual-focusable q-item--dense' and .='%s']//div[@role='checkbox']";
    private final String SUBMIT_BTN = "//button[@role='button']";

    // Methods
    public void clickYesContinueBtn() {
        //DriverUtils.waitForElementDisplayed(YES_CONTINUE_BTN);
        getElement(YES_CONTINUE_BTN).click();
    }

    public void clickStandardGetStartedBtn() {
        //DriverUtils.waitForElementDisplayed(STANDARD_GET_STARTED_BTN);
        getElement(STANDARD_GET_STARTED_BTN).click();
    }

    public void clickGetStartedBtn() {
        //DriverUtils.waitForElementDisplayed(GET_STARTED_BTN);
        getElement(GET_STARTED_BTN).click();
    }

    public void enterIdCard(UserInfo userInfo) {
        getElement(ID_CARD_NUMBER_TXT).sendKeys(userInfo.getIdCardNumber());
    }

    public void enterDob(UserInfo userInfo) {

        // Variables declaration
        String currentYear = Utilities.getCurrentYear();
        String currentMonth = Utilities.getCurrentMonth();
        String yearTemp = YEAR_LBL.format(YEAR_LBL, currentYear);
        String wantedYearTemp = WANTED_YEAR_LBL.format(WANTED_YEAR_LBL, userInfo.getYear());
        String monthTemp = MONTH_LBL.format(YEAR_LBL, currentMonth);
        String wantedMonthTemp = WANTED_MONTH_LBL.format(WANTED_YEAR_LBL, userInfo.getMonth());
        String wantedDayTemp = WANTED_DAY_LBL.format(WANTED_DAY_LBL, userInfo.getDay());

        // Click on DateOfBirth Combobox
        DriverUtils.waitForElementDisplayed(DOB_CBB);
        DriverManagement.getDriver().findElement(By.xpath(DOB_CBB)).click();
        //getElement(DOB_CBB).click();

        // Click on the current Year label
        DriverUtils.waitForElementDisplayed(yearTemp);
        DriverManagement.getDriver().findElement(By.xpath(yearTemp)).click();
        //getElement(yearTemp).click();
        DriverUtils.setLowImplicitlyWait();
        System.out.println("Set Implicit");
        //Driver.setLowImplicitlyWait();

        // Loop through the calendar to find the wanted Year
        for (int i = 0; i < 9; i++) {

            boolean a = isElementPresent(wantedYearTemp);
            System.out.println(a);
            if (a == false) {
                DriverManagement.getDriver().findElement(By.xpath(PREVIOUS_YEAR_ICON)).click();
                //getElement(PREVIOUS_YEAR_ICON).click();
            } else {
                break;
            }
        }
        // Then click on the wanted Year
        //DriverUtils.setImplicitlyWait();
        Driver.setImplicitlyWait();
        DriverManagement.getDriver().findElement(By.xpath(wantedYearTemp)).click();
        //getElement(wantedYearTemp).click();
        DriverManagement.getDriver().findElement(By.xpath(monthTemp)).click();
        //getElement(monthTemp).click();
        DriverManagement.getDriver().findElement(By.xpath(wantedMonthTemp)).click();
        //getElement(wantedMonthTemp).click();

        try {
            DriverManagement.getDriver().findElement(By.xpath(wantedDayTemp)).click();
            //getElement(wantedDayTemp).click();
        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            DriverManagement.getDriver().findElement(By.xpath(wantedDayTemp)).click();
            //getElement(wantedDayTemp).click();
        }
    }

    public void selectNationality(UserInfo userInfo) {
        String nation = NATION_LBL.format(NATION_LBL, userInfo.getNationality());
        getElement(NATIONALALITY_CBB).click();
        getElement(nation).click();
    }

    public void selectGender(UserInfo userInfo) {
        String gender = GENDER_LBL.format(GENDER_LBL, userInfo.getGender());
        getElement(GENDER_CBB).click();
        getElement(gender).click();
    }

    public void selectInterest(UserInfo userInfo) {
        String interest = INTEREST_CB.format(INTEREST_CB, userInfo.getInterest());
        getElement(INTEREST_DROPDOWN).click();
        getElement(interest).click();
        getElement(INTEREST_DROPDOWN_REVERSE).click();
    }

    public void fillPersonalInfo(UserInfo userInfo) {
        enterIdCard(userInfo);
        enterDob(userInfo);
        selectNationality(userInfo);
        selectGender(userInfo);
        selectInterest(userInfo);
    }

    public void clickSubmitBtn() {
        getElement(SUBMIT_BTN).click();
    }
}






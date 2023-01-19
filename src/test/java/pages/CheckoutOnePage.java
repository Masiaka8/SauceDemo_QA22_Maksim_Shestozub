package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CheckoutOnePage extends BasePage{
    @FindBy(css = "#first-name")
    private WebElement FIRST_NAME_INPUT_LOCATOR;
    @FindBy(css = "#last-name")
    private WebElement LAST_NAME_INPUT_LOCATOR;
    @FindBy(css = "#postal-code")
    private WebElement ZIP_CODE_INPUT_LOCATOR;
    @FindBy(css = "#continue")
    private WebElement CONTINUE_BUTTON;
    @FindBy(css = ".error-message-container")
    private WebElement ERROR_MESSAGE;

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public CheckoutOnePage setFirstName(String firstName) {
        logger.debug("Input firstName {}", firstName );
        FIRST_NAME_INPUT_LOCATOR.sendKeys(firstName);
        return this;
    }
    @Step
    public CheckoutOnePage setLastName(String lastName) {
        logger.debug("Input lastName {}", lastName );
        LAST_NAME_INPUT_LOCATOR.sendKeys(lastName);
        return this;
    }
    @Step
    public CheckoutOnePage setZipCode(String zipCode) {
        logger.debug("Input ZipCode {}", zipCode );
        ZIP_CODE_INPUT_LOCATOR.sendKeys(zipCode);
        return this;
    }
    @Step
    public CheckoutTwoPage clickContinueOverwiewButton() {
        logger.info("Clicking continue button");
        CONTINUE_BUTTON.click();
        return new CheckoutTwoPage(driver);
    }
    @Step
    public String getErrorMessageText() {
        logger.debug("Error message {}", getErrorMessageText());
        return ERROR_MESSAGE.getText();
    }
    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return CONTINUE_BUTTON.isDisplayed();
    }
}

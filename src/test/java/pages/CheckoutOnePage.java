package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutOnePage extends BasePage{

    private By FIRST_NAME_INPUT_LOCATOR = By.cssSelector("#first-name");
    private By LAST_NAME_INPUT_LOCATOR = By.cssSelector("#last-name");
    private By ZIP_CODE_INPUT_LOCATOR = By.cssSelector("#postal-code");
    private By CANCEL_BUTTON = By.cssSelector("#cancel");
    private By CONTINUE_BUTTON = By.cssSelector("#continue");
    private By ERROR_MESSAGE =By.cssSelector(".error-message-container");

    public CheckoutOnePage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }
    @Step
    public void setFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT_LOCATOR).sendKeys(firstName);
    }
    @Step
    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT_LOCATOR).sendKeys(lastName);
    }
    @Step
    public void setZipCode(String zipCode) {
        driver.findElement(ZIP_CODE_INPUT_LOCATOR).sendKeys(zipCode);
    }
    @Step
    public void clickContinueOverwiewButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }
    @Step
    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE).getText();
    }

}

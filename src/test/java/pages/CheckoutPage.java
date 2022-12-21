package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{

    private By FIRST_NAME_INPUT_LOCATOR = By.cssSelector("#first-name");
    private By LAST_NAME_INPUT_LOCATOR = By.cssSelector("#last-name");
    private By ZIP_CODE_INPUT_LOCATOR = By.cssSelector("#postal-code");
    private By CANCEL_BUTTON = By.cssSelector("#cancel");
    private By CONTINUE_BUTTON = By.cssSelector("#continue");

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void setFirstName(String firstName) {
        driver.findElement(FIRST_NAME_INPUT_LOCATOR).sendKeys(firstName);
    }
    public void setLastName(String lastName) {
        driver.findElement(LAST_NAME_INPUT_LOCATOR).sendKeys(lastName);
    }
    public void setZipCode(String zipCode) {
        driver.findElement(ZIP_CODE_INPUT_LOCATOR).sendKeys(zipCode);
    }

    public void clickContinueOverwiewButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

}

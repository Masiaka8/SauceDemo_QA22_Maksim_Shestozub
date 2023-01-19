package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    @FindBy(css = "#user-name")
    private WebElement USER_NAME_LOCATOR;
    @FindBy(css = "#password")
    private WebElement PASSWORD_INPUT_LOCATOR;
    @FindBy(css = "#login-button")
    private WebElement LOGIN_BUTTON_LOCATOR;
    @FindBy(css = ".error-message-container")
    private WebElement ERROR_MESSAGE_CONTAINER;

    public LoginPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public ProductsPage clickLoginButton() {
        logger.info("Clicking login button");
        LOGIN_BUTTON_LOCATOR.click();
        return new ProductsPage(driver);
    }

    @Step
    public LoginPage setUsername(String username) {
        logger.debug("Input Username %s", username );
        USER_NAME_LOCATOR.sendKeys(username);
        return this;
    }

    @Step
    public LoginPage setPassword(String password) {
        logger.debug("Input Password %s", password );
        PASSWORD_INPUT_LOCATOR.sendKeys(password);
        return this;
    }

    @Step
    public String getErrorMessageText() {
        return ERROR_MESSAGE_CONTAINER.getText();
    }

    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return LOGIN_BUTTON_LOCATOR.isDisplayed();
    }
}

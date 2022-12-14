package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{
    private final static By USER_NAME_LOCATOR= By.cssSelector("#user-name");
    private By PASSWORD_INPUT_LOCATOR = By.cssSelector("#password");
    private By LOGIN_BUTTON_LOCATOR = By.cssSelector("#login-button");
    private By ERROR_MESSAGE_CONTAINER = By.cssSelector(".error-message-container");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        driver.findElement(LOGIN_BUTTON_LOCATOR).click();
    }

    public void setUsername(String username) {
        driver.findElement(USER_NAME_LOCATOR).sendKeys(username);
    }

    public void setPassword(String password) {
        driver.findElement(PASSWORD_INPUT_LOCATOR).sendKeys(password);
    }

    public String getErrorMessageText() {
        return driver.findElement(ERROR_MESSAGE_CONTAINER).getText();
    }
}

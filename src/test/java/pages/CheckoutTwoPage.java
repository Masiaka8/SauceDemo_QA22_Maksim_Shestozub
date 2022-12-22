package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class CheckoutTwoPage extends BasePage{

    private final static By FINISH_BUTTON = By.cssSelector("#finish");
    private final static By CANCEL_BUTTON = By.cssSelector("#cancel");

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
    }

    public void clickFinishButton() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CANCEL_BUTTON).click();
    }

    public Boolean isFinishButtonPresent() {
        try {
            driver.findElement(FINISH_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}

package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutTwoPage extends BasePage{
    @FindBy(css = "#finish")
    private WebElement FINISH_BUTTON;
    @FindBy(css = "#cancel")
    private WebElement CANCEL_BUTTON;

    public CheckoutTwoPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public CheckoutTwoPage clickFinishButton() {
        logger.info("Clicking finish button");
        FINISH_BUTTON.click();
        return this;
    }

    public CheckoutOnePage clickCancelButton() {
        logger.info("Clicking cancel button");
        CANCEL_BUTTON.click();
        return new CheckoutOnePage(driver);
    }

    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return FINISH_BUTTON.isDisplayed();
    }
}

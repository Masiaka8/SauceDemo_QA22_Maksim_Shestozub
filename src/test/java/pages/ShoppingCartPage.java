package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ShoppingCartPage extends BasePage {
    @FindBy(css = "#continue-shopping")
    private WebElement CONTINUE_SHOPPING_BUTTON;
    @FindBy(css = "#checkout")
    private WebElement CHECKOUT_BUTTON;
    @FindBy(css = ".inventory_item_desc")
    private WebElement ITEM_DESCRIPTION;
    @FindBy(css = ".inventory_item_price")
    private WebElement ITEM_PRICE;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public ProductsPage clickContinueShoppingButton() {
        logger.info("Clicking continue button");
        CONTINUE_SHOPPING_BUTTON.click();
        return new ProductsPage(driver);
    }

    @Step
    public CheckoutOnePage clickCheckOutButton() {
        logger.info("Clicking checkout button");
        CHECKOUT_BUTTON.click();
        return new CheckoutOnePage(driver);
    }

    @Step
    public String getItemPrice(String itemName) {
        logger.debug("Get price %s", itemName );
        return ITEM_PRICE.getText();
    }

    @Step
    public String getItemDescription(String itemName) {
        logger.debug("Get description %s", itemName );
        return ITEM_DESCRIPTION.getText();
    }

    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return CHECKOUT_BUTTON.isDisplayed();
    }
}

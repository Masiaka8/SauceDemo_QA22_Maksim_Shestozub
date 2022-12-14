package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private final static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("#continue-shopping");
    private final static By CHECKOUT_BUTTON = By.cssSelector("#checkout");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_details_desc.large_size");
    private final static By ITEM_PRICE = By.cssSelector(".inventory_details_price");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    public void clickCancelButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }
}

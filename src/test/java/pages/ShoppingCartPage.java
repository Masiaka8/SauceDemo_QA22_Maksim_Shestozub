package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BasePage {

    private final static By CONTINUE_SHOPPING_BUTTON = By.cssSelector("#continue-shopping");
    private final static By CHECKOUT_BUTTON = By.cssSelector("#checkout");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_item_desc");
    private final static By  ITEM_PRICE = By.cssSelector(".inventory_item_price");

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public void clickContinueShoppingButton() {
        driver.findElement(CONTINUE_SHOPPING_BUTTON).click();
    }

    @Step
    public void clickCheckOutButton() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    @Step
    public String getItemPrice(String itemName) {
        return driver.findElement(ITEM_PRICE).getText();
    }

    @Step
    public String getItemDescription(String itemName) {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }

    @Step
    public Boolean isCheckoutButtonPresent() {
        try {
            driver.findElement(CHECKOUT_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }
}

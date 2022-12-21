package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePage{

    private final static By ITEM_NAME = By.cssSelector(".inventory_details_name.large_size");
    private final static By ITEM_DESCRIPTION = By.cssSelector(".inventory_details_desc.large_size");
    private final static By ITEM_PRICE = By.cssSelector(".inventory_details_price");

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    public String getItemPrice(String itemName) {
        return driver.findElement(ITEM_PRICE).getText();
    }

    public String getItemName(String itemName) {
        return driver.findElement(ITEM_NAME).getText();
    }

    public String getItemDescription(String itemName) {
        return driver.findElement(ITEM_DESCRIPTION).getText();
    }
}

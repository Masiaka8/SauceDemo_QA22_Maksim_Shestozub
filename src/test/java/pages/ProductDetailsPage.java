package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage extends BasePage{
    @FindBy(css = ".inventory_details_name.large_size")
    private WebElement ITEM_NAME;
    @FindBy(css = ".inventory_details_desc.large_size")
    private WebElement ITEM_DESCRIPTION;
    @FindBy(css = ".inventory_details_price")
    private WebElement ITEM_PRICE;
    @FindBy(css = "#back-to-products")
    private WebElement BACK_TO_PRODUCT_PAGE;

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public String getItemPrice(String itemName) {
        logger.debug("Get description %s", itemName );
        return ITEM_PRICE.getText();
    }

    public String getItemName(String itemName) {
        logger.debug("Get text from item name %s", itemName );
        return ITEM_NAME.getText();
    }

    @Step
    public String getItemDescription(String itemName) {
        logger.debug("Get text from description %s", itemName );
        return ITEM_DESCRIPTION.getText();
    }

    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return BACK_TO_PRODUCT_PAGE.isDisplayed();
    }
}

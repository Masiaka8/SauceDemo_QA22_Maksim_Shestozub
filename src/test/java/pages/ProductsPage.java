package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.stream.Collectors;


public class ProductsPage extends BasePage{
    @FindBy(css = ".shopping_cart_link")
    private  WebElement SHOPPING_CART_BUTTON;
    private final static String ITEM_CONTAINER_LOCATOR = ".//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']");
    private final static By ITEM_DESCRIPTION = By.xpath(".//div[@class='inventory_item_desc']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    @FindBy(css = "#react-burger-menu-btn")
    private  WebElement BURGER_MENU_BUTTON;
    @FindBy(css = "#logout_sidebar_link")
    private  WebElement LOGOUT_BUTTON;
    @FindBy(css = ".product_sort_container")
    private WebElement DROPDOWN_BUTTON;


    public ProductsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Step
    public ShoppingCartPage clickShoppingCartButton() {
        logger.info("Clicking ShoppingCart button");
        SHOPPING_CART_BUTTON.click();
        return new ShoppingCartPage(driver);
    }

    @Step
    public LoginPage clickLogoutButton() {
        logger.info("Clicking Logout button");
        LOGOUT_BUTTON.click();
        return new LoginPage(driver);
    }

    @Step
    public ProductsPage clickBurgerMenuButton() {
        logger.info("Clicking Burger Menu button");
        BURGER_MENU_BUTTON.click();
        return this;
    }

    @Step
    public void clickAddToCartButton (String itemName) {
        logger.debug("Clicking add item button {}", itemName );
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step
    public String getItemDescrtption (String itemName) {
        logger.debug("Get text from description {}", itemName );
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step
    public String getItemPrice (String itemName) {
        logger.debug("Get text from price {}", itemName );
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step
    public void openItem (String itemName) {
        logger.debug("Clicking item page button {}", itemName );
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    @Step
    private By getItemContainerByName (String itemName) {
        logger.debug("Find item {}", itemName );
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    @Step
    public ProductsPage selectSortingOrderOption (String optionName) {
        logger.debug("Selecting {}", optionName );
        Select select = new Select(driver.findElement(By.cssSelector(".product_sort_container")));
        select.selectByVisibleText(optionName);
        return this;
    }

    @Step
    public ProductsPage clickDropdownButton (){
        logger.info("Clicking dropdown button");
        DROPDOWN_BUTTON.click();
        return this;
    }

    @Step
    public List<String> getSortingListItemName (){
      List<WebElement> listItemName = driver.findElements(ITEM_BUTTON);
      List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
      return allListItemName;
    }

    @Override
    public boolean isPageOpened(){
        logger.info("Button is displayed");
        return SHOPPING_CART_BUTTON.isDisplayed();
    }
}

package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;


public class ProductsPage extends BasePage{
    private  final static By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    private final static String ITEM_CONTAINER_LOCATOR = ".//div[@class='inventory_item_name' and text()='%s']/ancestor::div[@class='inventory_item']";
    private final static By ADD_TO_CART_BUTTON = By.xpath(".//button[text()='Add to cart']");
    private final static By ITEM_BUTTON = By.xpath(".//div[@class='inventory_item_name']");
    private final static By ITEM_DESCRIPTION = By.xpath(".//div[@class='inventory_item_desc']");
    private final static By ITEM_PRICE = By.xpath(".//div[@class='inventory_item_price']");
    private  final static By BURGER_MENU_BUTTON = By.cssSelector("#react-burger-menu-btn");
    private  final static By LOGOUT_BUTTON = By.cssSelector("#logout_sidebar_link");
    private final static By DROPDOWN_BUTTON = By.cssSelector(".product_sort_container");


    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public Boolean isShoppingCartButtonPresent() {
        try {
            driver.findElement(SHOPPING_CART_BUTTON);
        } catch (NoSuchElementException ex) {
            return false;
        }
        return true;
    }

    @Step
    public void clickShoppingCartButton() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }

    @Step
    public void clickLogoutButton() {
        driver.findElement(LOGOUT_BUTTON).click();
    }

    @Step
    public void clickBurgerMenuButton() {
        driver.findElement(BURGER_MENU_BUTTON).click();
    }

    @Step
    public void clickAddToCartButton (String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ADD_TO_CART_BUTTON).click();
    }

    @Step
    public String getItemDescrtption (String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_DESCRIPTION).getText();
    }

    @Step
    public String getItemPrice (String itemName) {
        return driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_PRICE).getText();
    }

    @Step
    public void openItem (String itemName) {
        driver.findElement(getItemContainerByName(itemName)).findElement(ITEM_BUTTON).click();
    }

    @Step
    private By getItemContainerByName (String itemName) {
        return By.xpath(String.format(ITEM_CONTAINER_LOCATOR, itemName));
    }

    @Step
    public void selectSortingOrderOption (String optionName) {
        Select select = new Select(driver.findElement(DROPDOWN_BUTTON));
        select.selectByVisibleText(optionName);
    }

    @Step
    public void clickDropdownButton (){
        driver.findElement(DROPDOWN_BUTTON).click();
    }

    @Step
    public List<String> getSortingListItemName (){
      List<WebElement> listItemName = driver.findElements(ITEM_BUTTON);
      List<String> allListItemName = listItemName.stream().map(WebElement::getText).collect(Collectors.toList());
      return allListItemName;
    }
}

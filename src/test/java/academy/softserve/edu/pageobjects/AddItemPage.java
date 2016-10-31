package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.enums.add_item_page.SearchConditions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.AddItemPageLocators.*;

@Getter
public class AddItemPage extends PageObject<AddItemPage> {

    /**
     * resetButton is an unique element on the AddItemPage,
     * can be used as identification of page;
     */
    private final Button resetButton = new Button(driver, RESET_BUTTON);

    private final Link selectLastAddedItemLink = new Link(driver, SELECT_LAST_ADDED_ITEM_LINK);

    private final TextLabel itemTextField = new TextLabel(driver, ITEM_TEXT_FIELD);

    private final TextLabel itemPriceField = new TextLabel(driver, ITEM_PRICE_FIELD);

    private final TextInputField itemQuantityTextfield = new TextInputField(driver, ITEM_QUANTITY_INPUT);

    private final Dropdown itemDimensionDropdown = new Dropdown(driver, ITEM_DIMENSION_DROPDOWN);

    private final Button doneButton = new Button(driver, DONE_BUTTON);

    private final Dropdown searchForItemDropdown = new Dropdown(driver, SEARCH_FOR_ITEM_DROPDOWN);

    private final TextInputField searchForItemInput = new TextInputField(driver, SEARCH_FOR_ITEM_INPUT);

    private final Button searchForItemButton = new Button(driver, SEARCH_FOR_ITEM_BUTTON);

    public AddItemPage(final WebDriver driver) {
        super(driver);
    }

    public final AddItemPage selectLastAddedItem() {

        selectLastAddedItemLink.click();
        return this;
    }

    public final CreateNewOrderPage addItemToOrder() {

        doneButton.click();
        return new CreateNewOrderPage(driver);
    }

    public final AddItemPage setSearchText(final String searchText) {

        searchForItemInput.sendKeys(searchText);
        return this;
    }

    public final AddItemPage setItemQuantity(final String itemQuantity) {

        itemQuantityTextfield.sendKeys(itemQuantity);
        return this;
    }

    public final AddItemPage selectItemDimension(final String itemDimension) {

        itemDimensionDropdown.sendKeys(itemDimension);
        return this;
    }

    public final AddItemPage selectSearchCondition(final SearchConditions condition) {

        searchForItemDropdown.sendKeys(condition.toString());
        return this;
    }

    public final AddItemPage clickSearch() {

        searchForItemButton.click();
        return this;
    }

    public final AddItemPage searchForItem(final SearchConditions searchCondition, final String searchText) {

        return selectSearchCondition(searchCondition)
                .setSearchText(searchText)
                .clickSearch();
    }

}

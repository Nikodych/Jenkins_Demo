package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum AddItemPageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    SEARCH_FOR_ITEM_DROPDOWN("Search For Item Dropdown",
            LocatorsType.BY_ID,
            "searchProperty"),

    SEARCH_FOR_ITEM_INPUT("Search For Item Input",
            LocatorsType.BY_ID,
            "searchValue"),

    SEARCH_FOR_ITEM_BUTTON("Search For Item Button",
            LocatorsType.BY_XPATH,
            "//form[@id='model']/input[9]"),

    ITEM_TEXT_FIELD("Item Text Field",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[1]/td[2]"),

    ITEM_PRICE_FIELD("Item Price Field",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']//tr[3]/td[2]"),

    ITEM_QUANTITY_INPUT("Item Quantity Input",
            LocatorsType.BY_XPATH,
            "//form[@id='doneForm']/table/tbody/tr[4]/td[1]/following::input[1]"),

    ITEM_DIMENSION_DROPDOWN("Item Dimension Textfield",
            LocatorsType.BY_XPATH,
            "//select[@id='dimension']"),

    RESET_BUTTON("Reset Button",
            LocatorsType.BY_XPATH,
            "//form[@id='resetForm']/input[11]"),

    DONE_BUTTON("Done Button",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset/fieldset/table/tbody/tr/td[2]/input"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='cancelForm']/input[2]"),

    SELECT_LAST_ADDED_ITEM_LINK("Select Last Added Item Link",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/descendant::form[contains(@id, 'selectFrom')][1]/a");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    AddItemPageLocators(final String elementName,
                        final LocatorsType locatorType, final String locatorValue) {
        this.elementName = elementName;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    @Override
    public String getName() {
        return this.elementName;
    }

    @Override
    public By getBy() {
        By by;
        if (this.modifiedLocator == null) {
            by = this.locatorType.getBy(this.locatorValue);
        } else {
            by = this.locatorType.getBy(this.modifiedLocator);
        }
        return by;
    }

    @Override
    public AddItemPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

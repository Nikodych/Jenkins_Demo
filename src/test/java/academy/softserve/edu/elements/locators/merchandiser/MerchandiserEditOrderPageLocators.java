package academy.softserve.edu.elements.locators.merchandiser;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum MerchandiserEditOrderPageLocators implements ILocator {

    ORDER_STATUS_DROPDOWN("Order Status Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@name = 'orderStatus']"),

    SAVE_BUTTON("Save Button",
            LocatorsType.BY_XPATH,
            "//input[@type='button']"),

    SHOW_ITEMS_LINK("Edit Order",
            LocatorsType.BY_XPATH,
            "//a[@href='orderItemsResize.htm?orderId=1']"),

    CHOOSE_DATE_LINK("Choose date",
            LocatorsType.BY_XPATH,
            "//form[@id='merchandiserOrderEditForm']//a"),

    LAST_DAY_LINK("Last day",
            LocatorsType.BY_XPATH,
            "//table[@class = 'jCalendar']//tr[6]/td[last()]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    MerchandiserEditOrderPageLocators(final String elementName,
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
    public MerchandiserEditOrderPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
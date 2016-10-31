package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum CustomerOrderingPageLocators implements ILocator {

    CUSTOMER_ORDERING_LINK("Customer Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='order.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    CREATE_NEW_ORDER_LINK("Create New Order Link",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/a"),

    SEARCH_DROPDOWN("Search Dropdown",
            LocatorsType.BY_XPATH,
            "//select[@id='search']"),

    SEARCH_INPUT("Search Input",
            LocatorsType.BY_XPATH,
            "//input[@id='searchValue']"),

    APPLY_BUTTON("Apply Button",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//td[4]/input"),

    ORDER_STATUS("Order Status 1",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr/"
                    + "td[contains(text(), 'OrderName%s')]/following-sibling::td[4]"),

    EDIT_LINK("Edit link",
            LocatorsType.BY_XPATH,
            "(//div[@id='list']//tbody/tr[2]//a)[1]"),

    DELETE_LINK("Delete link",
            LocatorsType.BY_XPATH,
            "(//div[@id='list']//tbody/tr[2]//a)[2]"),

    ORDER_ROW("Order row",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table//tr[2]"),

    RESIZE_SHOW_ITEMS_LINK("Resize show items link",
            LocatorsType.BY_XPATH,
            "//form[@id='searchFilter']//a"),

    SEARCH_STATUS_RESULT("Search status result",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[2]/td[5]"),

    SEARCH_NAME_RESULT("Search name result",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr[2]/td[1]"),

    SEARCH_RESULT_ELEMENTS("Search status result",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody/tr"),

    ORDER_NAME_COLUMN_ELEMENTS("Order Name Column Elements",
            LocatorsType.BY_XPATH,
            "//div[@id='list']/table/tbody//td[1]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    CustomerOrderingPageLocators(final String elementName,
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
    public CustomerOrderingPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

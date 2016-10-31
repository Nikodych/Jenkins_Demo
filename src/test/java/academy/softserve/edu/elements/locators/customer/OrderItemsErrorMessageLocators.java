package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum OrderItemsErrorMessageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    CONTENT_TEXT("Content Text",
            LocatorsType.BY_ID,
            "content"),

    ORDER_ITEMS_ERROR_MESSAGE_TEXT("Order Items Error Message Text",
            LocatorsType.BY_XPATH,
            "//title[text() = 'Order Items']");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    OrderItemsErrorMessageLocators(final String elementName,
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
    public OrderItemsErrorMessageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

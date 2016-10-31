package academy.softserve.edu.elements.locators.supervisor;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum AddProductPageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    PRODUCT_NAME_INPUT("Product Name Input",
            LocatorsType.BY_ID,
            "name"),

    PRODUCT_DESCRIPTION_INPUT("Product Description Input",
            LocatorsType.BY_ID,
            "description"),

    PRODUCT_PRICE_INPUT("Product Price Input",
            LocatorsType.BY_ID,
            "price"),

    OK_BUTTON("OK Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[2]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[3]"),

    PRODUCT_NAME_ERROR_TEXT("Product Name Error Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/table/tbody/tr[1]/td[3]"),

    PRODUCT_DESCRIPTION_ERROR_TEXT("Product Description Error Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/table/tbody/tr[2]/td[3]"),

    PRODUCT_PRICE_ERROR_TEXT("Product Price Error Text",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/table/tbody/tr[3]/td[3]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    AddProductPageLocators(final String elementName,
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
    public AddProductPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

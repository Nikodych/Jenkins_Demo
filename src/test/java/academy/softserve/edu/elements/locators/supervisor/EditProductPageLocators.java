package academy.softserve.edu.elements.locators.supervisor;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum EditProductPageLocators implements ILocator {

    PRODUCT_NAME_TEXTFIELD("Product Name Textfield",
            LocatorsType.BY_ID,
            "name"),

    PRODUCT_DESCRIPTION_TEXTFIELD("Product Description Textfield",
            LocatorsType.BY_ID,
            "description"),

    PRODUCT_PRICE_TEXTFIELD("Product Price Textfield",
            LocatorsType.BY_ID,
            "price"),

    OK_BUTTON("OK Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[2]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='productModel']/input[3]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    EditProductPageLocators(final String elementName,
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
    public EditProductPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }

}


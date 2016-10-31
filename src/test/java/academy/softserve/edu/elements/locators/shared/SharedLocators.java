package academy.softserve.edu.elements.locators.shared;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum SharedLocators implements ILocator {

    LOG_OUT_BUTTON("Log Out Button",
            LocatorsType.BY_ID,
            "logout"),

    ENGLISH_SWITCH_LINK("English Switch Link",
            LocatorsType.BY_XPATH,
            "//a[@id='en_US']"),

    UKRAINIAN_SWITCH_LINK("Ukrainian Switch Link",
            LocatorsType.BY_XPATH,
            "//a[@id='uk_UA']");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;


    SharedLocators(final String elementName,
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
    public SharedLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

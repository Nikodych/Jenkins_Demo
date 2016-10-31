package academy.softserve.edu.elements.locators.userinfo;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum UserInfoPageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    USER_INFO_FIELDSET("User Info Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//legend"),

    FIRST_NAME_VALUE("First Name Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[1]/td[2]"),

    LAST_NAME_VALUE("Last Name Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[2]/td[2]"),

    CUSTOMER_TYPE_VALUE("Customer Type Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[3]/td[2]"),

    ROLE_VALUE("Role Value Text",
            LocatorsType.BY_XPATH,
            "//div[@id='content']//tr[4]/td[2]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    UserInfoPageLocators(final String elementName,
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
    public UserInfoPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}
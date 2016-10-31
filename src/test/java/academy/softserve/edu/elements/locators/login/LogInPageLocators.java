package academy.softserve.edu.elements.locators.login;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum LogInPageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//div[@id='nav']/li[1]/a"),

    LOGIN_FIELDSET("Login Fieldset",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']//legend"),

    LOGIN_ERROR_MESSAGE("Login Error Message",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']//font"),

    USER_NAME_INPUT("User Name Field",
            LocatorsType.BY_NAME,
            "j_username"),

    PASSWORD_INPUT("Password Field",
            LocatorsType.BY_NAME,
            "j_password"),

    REMEMBER_ME_CHECKBOX("Remember Me Checkbox",
            LocatorsType.BY_XPATH,
            "//div[@id='edit']//tr[3]//input"),

    LOG_IN_BUTTON("Log In Button",
            LocatorsType.BY_NAME,
            "submit"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_NAME,
            "reset");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    LogInPageLocators(String elementName,
                      LocatorsType locatorType, String locatorValue) {
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
    public LogInPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

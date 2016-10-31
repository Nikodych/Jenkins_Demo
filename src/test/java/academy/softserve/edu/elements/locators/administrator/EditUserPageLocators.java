package academy.softserve.edu.elements.locators.administrator;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.elements.LocatorsType;
import org.openqa.selenium.By;

public enum EditUserPageLocators implements ILocator {

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    FIRST_NAME_INPUT("First Name Input",
            LocatorsType.BY_ID,
            "firstName"),

    LAST_NAME_INPUT("Last Name Input",
            LocatorsType.BY_ID,
            "lastName"),

    NEW_PASSWORD_TEXT("New Password Text",
            LocatorsType.BY_XPATH,
            "//td[contains(., 'New password:')]"),

    NEW_PASSWORD_INPUT("New Password Input",
            LocatorsType.BY_ID,
            "password"),

    CONFIRM_PASSWORD_INPUT("Confirm Password Input",
            LocatorsType.BY_ID,
            "confirmPassword"),

    EMAIL_ADDRESS_INPUT("Email Address Input",
            LocatorsType.BY_ID,
            "email"),

    REGION_DROPDOWN("Region Dropdown",
            LocatorsType.BY_ID,
            "regionID"),

    ROLE_DROPDOWN("Role Dropdown",
            LocatorsType.BY_ID,
            "roleID"),

    SAVE_CHANGES_BUTTON("Save Changes Button",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']/input[5]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='userModel']/input[6]");


    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    EditUserPageLocators(final String elementName,
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
    public EditUserPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

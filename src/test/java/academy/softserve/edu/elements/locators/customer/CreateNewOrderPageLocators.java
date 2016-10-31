package academy.softserve.edu.elements.locators.customer;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum CreateNewOrderPageLocators implements ILocator {

    CUSTOMER_ORDERING_LINK("Ordering Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/descendant::a[@href='order.htm']"),

    USER_INFO_LINK("User Info Link",
            LocatorsType.BY_XPATH,
            "//ul[@id='nav']/li[2]/a"),

    ADD_ITEM_BUTTON("Add Item Button",
            LocatorsType.BY_XPATH,
            "//form[@id='addItem']/input[@value = 'Add Item']"),

    TOTALS_FIELDSET("Totals Fieldset",
            LocatorsType.BY_XPATH,
            "//legend[@id='legendHeight']/strong"),

    ORDER_NUMBER_TEXT("Order Number Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[1]/td[1]"),

    ORDER_NUMBER_FIELD("Order Number Field",
            LocatorsType.BY_ID,
            "orderNum"),

    STATUS_TEXT("Status Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[2]/td[1]"),

    STATUS_FIELD("Status Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[2]/td[2]"),

    TOTAL_PRICE_TEXT("Total Price Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[3]/td[1]"),

    TOTAL_PRICE_FIELD("Total Price Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[3]/td[2]"),

    TOTAL_NUMBER_OF_ITEMS_TEXT("Total Number Of Items Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[4]/td[1]"),

    TOTAL_NUMBER_OF_ITEMS_FIELD("Total Number Of Items Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[4]/td[2]"),

    DATE_OF_ORDERING_TEXT("Data Of Ordering Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[5]/td[1]"),

    DATE_OF_ORDERING_FIELD("Date Of Ordering Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[5]/td[2]"),

    PREFERABLE_DELIVERY_DATE_TEXT("Preferable Delivery Date Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[6]/td[1]"),

    PREFERABLE_DELIVERY_DATE_FIELD("Preferable Delivery Date Field",
            LocatorsType.BY_ID,
            "dateDays"),

    PREFERABLE_DELIVERY_DATE_CHOOSE_LINK("Preferable Delivery Date Choose Link",
            LocatorsType.BY_CLASS_NAME,
            "dp-choose-date"),

    VALID_DELIVERY_DATE_LINK("Valid Delivery Date Link",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']/div[3]/table/tbody/tr[5]/td[last()]"),

    DELIVERY_DATE_TEXT("Delivery Date Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[7]/td[1]"),

    DELIVERY_DATE_FIELD("Delivery Date Field",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[7]/td[2]"),

    ASSIGNEE_TEXT("Assignee Text",
            LocatorsType.BY_XPATH,
            "//form[@id='saveButton']//tr[8]/td[1]"),

    ASSIGNEE_DROPDOWN("Assignee Dropdown",
            LocatorsType.BY_ID,
            "assignee"),

    CARD_INFO_TEXT("Card Info Fieldset",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//legend/strong"),

    CREDIT_CARD_TYPE_TEXT("Credit Card Type Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[1]/td[1]//strong[1]"),

    CREDIT_CARD_TYPE_DROPDOWN("Credit Card Type Dropdown",
            LocatorsType.BY_ID,
            "cardTypes"),

    CREDIT_CARD_NUMBER_TEXT("Credit Card Number Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[2]/td[1]/strong"),

    CREDIT_CARD_NUMBER_TEXTFIELD("Credit Card Number Textfield",
            LocatorsType.BY_ID,
            "cardNum"),

    CVV2_TEXT("CVV2 Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[3]/td[1]/strong"),

    CVV2_INPUT("CVV2 Input",
            LocatorsType.BY_ID,
            "cvv2"),

    EXPIRY_DATE("Expiry Date",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[4]/td[1]/strong"),

    EXPIRY_DATE_MONTH_DROPDOWN("Expiry Date Month Dropdown",
            LocatorsType.BY_ID,
            "newCreditCardMonth"),

    EXPIRY_DATE_YEAR_DROPDOWN("Expiry Date Year Dropdown",
            LocatorsType.BY_ID,
            "newCreditCardYear"),

    START_DATE_MAESTRO_TEXT("Start Date Maestro Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[5]/td[1]/strong"),

    START_DATE_MAESTRO_INPUT("Start Date Maestro Input",
            LocatorsType.BY_ID,
            "startDate2"),

    ISSUE_NUMBER_MAESTRO_TEXT("Issue Number Maestro Text",
            LocatorsType.BY_XPATH,
            "//form[@id='form2']//tr[6]/td[1]/strong"),

    ISSUE_NUMBER_MAESTRO_INPUT("Issue Number Maestro Input",
            LocatorsType.BY_ID,
            "issueNumber2"),

    SAVE_BUTTON("Save Button",
            LocatorsType.BY_ID,
            "save"),

    ORDER_BUTTON("Order Button",
            LocatorsType.BY_XPATH,
            "//form[@id='orderButton']/input[2]"),

    CANCEL_BUTTON("Cancel Button",
            LocatorsType.BY_XPATH,
            "//form[@id='cancelButton']/input[2]"),

    NO_ITEMS_ERROR("No Items ERROR",
            LocatorsType.BY_ID,
            "totalsError"),

    FIRST_ITEM_NUMBER("First Item Number",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[1]"),

    FIRST_ITEM_NAME("First Item Name",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[2]"),

    FIRST_ITEM_DESCRIPTION("First Item Description",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[3]"),

    FIRST_ITEM_DIMENSION("First Item Dimension",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[4]"),

    FIRST_ITEM_PRICE("First Item Price",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[5]"),

    FIRST_ITEM_QUANTITY("First Item Quantity",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[6]"),

    FIRST_ITEM_PRICE_PER_LINE("First Item Price Per Line",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[7]"),

    FIRST_ITEM_EDIT_BUTTON("First Item Edit Button",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[8]//a"),

    FIRST_ITEM_DELETE_BUTTON("First Item Delete Button",
            LocatorsType.BY_XPATH,
            "//table[@id='orderItems']/tbody/tr[1]/td[9]//a"),

    ITEM_SELECTION_SECTION("Item Selection Section",
            LocatorsType.BY_XPATH,
            "//div[@id='content']/fieldset"),

    INCORRECT_CARD_ERROR("Incorrect Card Error",
            LocatorsType.BY_ID,
            "error"),

    CALENDAR_POPUP_ELEMENT("Calendar Popup Element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']"),

    CALENDAR_MONDAY_ELEMENT("Calendar monday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[1]/td[3]"),

    CALENDAR_TUESDAY_ELEMENT("Calendar tuesday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[2]/td[3]"),

    CALENDAR_WEDNESDAY_ELEMENT("Calendar wednesday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[3]/td[3]"),

    CALENDAR_THURSDAY_ELEMENT("Calendar thursday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[4]/td[3]"),

    CALENDAR_FRIDAY_ELEMENT("Calendar friday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[5]/td[3]"),

    CALENDAR_SATURDAY_ELEMENT("Calendar saturday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[6]/td[3]"),

    CALENDAR_SUNDAY_ELEMENT("Calendar sunday element",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tr[7]/td[3]"),

    CALENDAR_YEAR_BACKWARD_BUTTON("Calendar Year Backward Button",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']/div[1]/a[1]"),

    CALENDAR_MONTH_BACKWARD_BUTTON("Calendar Month Backward Button",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']/div[1]/a[2]"),

    CALENDAR_YEAR_FORWARD_BUTTON("Calendar Year Forward Button",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']/div[2]/a[1]"),

    CALENDAR_MONTH_FORWARD_BUTTON("Calendar Month Forward Button",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']/div[2]/a[2]"),

    DATA_LINK("Data link",
            LocatorsType.BY_XPATH,
            "//div[@id='dp-popup']//tbody/tr[3]/td[1]");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    CreateNewOrderPageLocators(final String elementName,
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
    public CreateNewOrderPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }
}

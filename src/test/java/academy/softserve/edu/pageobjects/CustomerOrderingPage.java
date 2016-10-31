package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.enums.customer_ordering_page.SearchConditions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.*;

@Getter
public class CustomerOrderingPage extends PageObject<CustomerOrderingPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    /**
     * createNewOrderLink is an unique element on the CustomerOrderingPage,
     * can be used as identification of page;
     */
    private final Link createNewOrderLink = new Link(driver, CREATE_NEW_ORDER_LINK);

    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button applyButton = new Button(driver, APPLY_BUTTON);

    private final Link resizeShowItemsLink = new Link(driver, RESIZE_SHOW_ITEMS_LINK);

    private final Link editLink = new Link(driver, EDIT_LINK);

    private final Link deleteLink = new Link(driver, DELETE_LINK);

    private final Element orderRow = new Element(driver, ORDER_ROW);

    private final Element searchStatusResult = new Element(driver, SEARCH_STATUS_RESULT);

    private final Element searchNameResult = new Element(driver, SEARCH_NAME_RESULT);

    private final Element searchResultElements = new Element(driver, SEARCH_RESULT_ELEMENTS);

    private final Element orderNameColumnElements = new Element(driver, ORDER_NAME_COLUMN_ELEMENTS);

    public final TextLabel getOrderStatusByNumber(final int orderNumber) {

        return new TextLabel(driver, ORDER_STATUS.modify(String.valueOf(orderNumber)));
    }

    public CustomerOrderingPage(WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage goToUserInfoPage() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final CreateNewOrderPage goToCreateNewOrderPage() {

        createNewOrderLink.click();
        return new CreateNewOrderPage(driver);
    }

    public final CustomerOrderingPage changeItemsPerPage() {

        resizeShowItemsLink.click();
        return this;
    }

    public final CustomerOrderingPage clickApply() {

        applyButton.click();
        return this;
    }

    public final CreateNewOrderPage editFirstOrder() {

        editLink.click();
        return new CreateNewOrderPage(driver);
    }

    public final CustomerOrderingPage deleteFirstOrder() {

        deleteLink.click();
        return this;
    }

    public final CustomerOrderingPage selectSearchCondition(final SearchConditions condition) {

        searchDropdown.sendKeys(condition.toString());
        return this;
    }

    public final CustomerOrderingPage setSearchText(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

    public final CustomerOrderingPage searchForOrder(final SearchConditions searchCondition, final String searchText) {

        return selectSearchCondition(searchCondition)
                .setSearchText(searchText)
                .clickApply();
    }

}

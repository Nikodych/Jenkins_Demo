package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.enums.merchandiser_ordering_page.SearchConditions;
import academy.softserve.edu.enums.merchandiser_ordering_page.SortConditions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserOrderingPage extends PageObject<MerchandiserOrderingPage> {

    /**
     * searchByText is an unique element on the MerchandiserOrderingPage,
     * can be used as identification of page;
     */
    private final TextLabel searchByText = new TextLabel(driver, SEARCH_BY_TEXT);

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown searchDropdown = new Dropdown(driver, SEARCH_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button applyButton = new Button(driver, APPLY_BUTTON);

    private final Link deleteCellLink = new Link(driver, DELETE_CELL_LINK);

    private final Button orderNameHeaderButton = new Button(driver, ORDER_NAME_HEADER_LINK);

    private final Button totalPriceHeaderButton = new Button(driver, TOTAL_PRICE_HEADER_LINK);

    private final Button maxDiscountHeaderButton = new Button(driver, MAX_DISCOUNT_HEADER_LINK);

    private final Button statusHeaderButton = new Button(driver, STATUS_HEADER_LINK);

    private final Button forwardButton = new Button(driver, FORWARD_NAVIGATION_BUTTON);

    private final Button backwardButton = new Button(driver, BACKWARD_NAVIGATION_BUTTON);

    private final Button firstButton = new Button(driver, FIRST_NAVIGATION_BUTTON);

    private final Button lastButton = new Button(driver, LAST_NAVIGATION_BUTTON);

    private final Link orderNameFirstCellLink = new Link(driver, ORDER_NAME_CELL_VALUE);

    private final Element orderNameColumnLink = new Element(driver, ORDER_NAME_COLUMN);

    private final Element totalPriceColumnLink = new Element(driver, TOTAL_PRICE_COLUMN);

    private final Element maxDiscountColumnLink = new Element(driver, MAX_DISCOUNT_COLUMN);

    private final Element statusColumnLink = new Element(driver, STATUS_COLUMN);

    private final Link numberOfGridPages = new Link(driver, PAGE_NUMBER_TEXT);

    private final Link pageCount = new Link(driver, PAGE_COUNT_TEXT);

    private final Link resizeOrdersListLink = new Link(driver, RESIZE_ORDERS_LIST_LINK);

    private final Link showItemsLink = new Link(driver, SHOW_ITEMS_LINK);

    public final Link getOrderLinkByNumber(final int editOrderNumber) {

        return new Link(driver, EDIT_CELL_LINK.modify(String.valueOf(editOrderNumber)));
    }

    public final Link getOrderStatusByNumber(final int statusNumber) {

        return new Link(driver, STATUS_CELL.modify(String.valueOf(statusNumber)));
    }

    public final TextLabel getOrderNameByCellId(final int cellId) {

        return new TextLabel(driver, ORDER_NAME_CELL.modify(String.valueOf(cellId)));
    }

    public MerchandiserOrderingPage(final WebDriver driver) {
        super(driver);
    }

    public final MerchandiserEditOrderPage editOrder(final Link editOrderLink) {

        editOrderLink.click();
        return new MerchandiserEditOrderPage(driver);
    }

    public final MerchandiserOrderingPage showItems() {

        showItemsLink.click();
        return this;
    }

    public final UserInfoPage goToUserInfoPage() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final MerchandiserOrderingPage clickApply() {

        applyButton.click();
        return this;
    }

    public final MerchandiserOrderingPage sortTableBy(final SortConditions condition) {

        switch (condition) {

            case ORDER_NAME:
                orderNameHeaderButton.click();
                break;
            case TOTAL_PRICE:
                totalPriceHeaderButton.click();
                break;
            case MAX_DISCOUNT:
                maxDiscountHeaderButton.click();
                break;
            case STATUS:
                statusHeaderButton.click();
                break;
        }

        return this;
    }

    public final MerchandiserOrderingPage navigateTableForward() {

        forwardButton.click();
        return this;
    }

    public final MerchandiserOrderingPage navigateTableBackward() {

        backwardButton.click();
        return this;
    }

    public final MerchandiserOrderingPage navigateTableToLastPage() {

        lastButton.click();
        return this;
    }

    public final MerchandiserOrderingPage navigateTableToFirstPage() {

        firstButton.click();
        return this;
    }

    public final MerchandiserOrderingPage changeItemsPerPage() {

        resizeOrdersListLink.click();
        return this;
    }

    public final MerchandiserOrderingPage deleteFirstOrder() {

        deleteCellLink.click();
        return this;
    }

    public final MerchandiserOrderingPage selectSearchCondition(final SearchConditions condition) {

        searchDropdown.sendKeys(condition.toString());
        return this;
    }

    public final MerchandiserOrderingPage setSearchText(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

    public final MerchandiserOrderingPage searchForOrder(final SearchConditions searchCondition, final String searchText) {

        return selectSearchCondition(searchCondition)
                .setSearchText(searchText)
                .clickApply();
    }

}

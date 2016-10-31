package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.enums.item_management_page.SearchConditions;
import academy.softserve.edu.enums.item_management_page.SortConditions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;


import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.*;
import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.PAGE_COUNT_TEXT;
import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.PAGE_NUMBER_TEXT;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class ItemManagementPage extends PageObject<ItemManagementPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown searchFieldFilterDropdown = new Dropdown(driver, SEARCH_FIELD_FILTER_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button searchButton = new Button(driver, SEARCH_BUTTON);

    private final Link addProductLink = new Link(driver, ADD_PRODUCT_LINK);

    /**
     * searchByFieldSet is an unique element on the ItemManagementPage,
     * can be used as identification of page;
     */
    private final TextLabel searchByFieldSet = new TextLabel(driver, SEARCH_BY_FIELDSET);

    private final Link createReportLink = new Link(driver, CREATE_REPORT_LINK);

    private final TextLabel recordsCountText = new TextLabel(driver, RECORDS_COUNT_TEXT);

    private final Link deleteProductLink = new Link(driver, DELETE_PRODUCT_LINK);

    private final Link firstProductNameCellLink = new Link(driver, NAME_PRODUCT_CELL_LINK);

    private final Link firstDescriptionProductCellLink = new Link(driver, DESCRIPTION_CELL_LINK);

    private final Link editFirstProductCellLink = new Link(driver, EDIT_PRODUCT_CELL_LINK);

    private final Link deleteFirstProductCellLink = new Link(driver, DELETE_PRODUCT_CELL_LINK);

    private final Button resizeProductsListButton = new Button(driver, RESIZE_PRODUCTS_LIST_LINK);

    private final Link quantityOfTablePages = new Link(driver, PAGE_COUNT_TEXT);

    private final Link numberOfTablePage = new Link(driver, PAGE_NUMBER_TEXT);

    private final Link quantityOfProducts = new Link(driver, RECORDS_COUNT_TEXT);

    private final Element NameCellColumn = new Element(driver, NAME_PRODUCT_CELL_COLUMN);

    private final Element descriptionCellColumn = new Element(driver, DESCRIPTION_CELL_COLUMN);

    private final Element priceCellColumn = new Element(driver, PRICE_CELL_COLUMN);

    private final Button nameHeaderButton = new Button(driver, NAME_HEADER_LINK);

    private final Button descriptionHeaderButton = new Button(driver, DESCRIPTION_HEADER_LINK);

    private final Button priceHeaderButton = new Button(driver, PRICE_HEADER_LINK);

    private final Button forwardNavigationButton = new Button(driver, FORWARD_NAVIGATION_BUTTON);

    private final Button backwardNavigationButton = new Button(driver, BACKWARD_NAVIGATION_BUTTON);

    private final Button lastNavigationButton = new Button(driver, LAST_NAVIGATION_BUTTON);

    private final Button firstNavigationButton = new Button(driver, FIRST_NAVIGATION_BUTTON);


    public final Link getEditProductLinkById(final int productId) {

        return new Link(driver, EDIT_PRODUCT_LINK.modify(String.valueOf(productId)));
    }

    public final Link getDeleteProductLinkById(final int productId) {

        return new Link(driver, DELETE_PRODUCT_LINK.modify(String.valueOf(productId)));
    }

    public ItemManagementPage(final WebDriver driver) {
        super(driver);
    }

    public final UserInfoPage goToUserInfoPage() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final SupervisorCreateReportPage goToCreateReportPage() {

        createReportLink.click();
        return new SupervisorCreateReportPage(driver);
    }

    public final EditProductPage editProductById(final int productId) {

        getEditProductLinkById(productId).click();
        return new EditProductPage(driver);
    }

    public final ItemManagementPage deleteProductById(final int productId) {

        getDeleteProductLinkById(productId).click();
        return this;
    }

    public final ItemManagementPage changeItemsPerPage() {

        resizeProductsListButton.click();
        return this;
    }

    public final ItemManagementPage sortTableBy(final SortConditions condition) {

        switch (condition) {

            case NAME:
                nameHeaderButton.click();
                break;
            case DESCRIPTION:
                descriptionHeaderButton.click();
                break;
            case PRICE:
                priceHeaderButton.click();
                break;
        }

        return this;
    }

    public final ItemManagementPage navigateTableForward() {

        forwardNavigationButton.click();
        return this;
    }

    public final ItemManagementPage navigateTableBackward() {

        backwardNavigationButton.click();
        return this;
    }

    public final ItemManagementPage navigateTableToLastPage() {

        lastNavigationButton.click();
        return this;
    }

    public final ItemManagementPage navigateTableToFirstPage() {

        firstNavigationButton.click();
        return this;
    }

    public final AddProductPage goToAddProductPage() {

        getAddProductLink().click();
        return new AddProductPage(driver);
    }

    public final ItemManagementPage clickSearch() {

        searchButton.click();
        return this;
    }

    public final ItemManagementPage setSearchText(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

    public final ItemManagementPage selectSearchCondition(final SearchConditions condition) {

        searchFieldFilterDropdown.sendKeys(condition.toString());
        return this;
    }

    public final ItemManagementPage searchForProduct(final SearchConditions searchCondition, final String searchText) {

        return selectSearchCondition(searchCondition)
                .setSearchText(searchText)
                .clickSearch();
    }

}

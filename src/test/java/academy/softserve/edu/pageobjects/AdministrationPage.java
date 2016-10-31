package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators;
import academy.softserve.edu.elements.wrappers.*;
import academy.softserve.edu.enums.administration_page.ColumnFilters;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import academy.softserve.edu.enums.administration_page.SortConditions;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.*;

@Getter
public class AdministrationPage extends PageObject<AdministrationPage> {

    private final Link administrationLink = new Link(driver, ADMINISTRATION_LINK);

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown searchFieldFilterDropdown = new Dropdown(driver, SEARCH_FIELD_FILTER_DROPDOWN);

    private final Dropdown searchConditionDropdown = new Dropdown(driver, SEARCH_CONDITION_DROPDOWN);

    private final TextInputField searchInput = new TextInputField(driver, SEARCH_INPUT);

    private final Button searchButton = new Button(driver, SEARCH_BUTTON);

    /**
     * foundUsersTextLabel is an unique element on the AdministratorPage,
     * can be used as identification of page;
     */
    private final TextLabel foundUsersTextLabel = new TextLabel(driver, FOUND_USERS_TEXT_LABEL);

    private final Link deleteFirstUserCellLink = new Link(driver, DELETE_USER_CELL_LINK);

    private final Link createReportLink = new Link(driver, CREATE_REPORT_LINK);

    private final Link createUserLink = new Link(driver, CREATE_USER_LINK);

    private final Link editUserLink = new Link(driver, EDIT_USER_LINK);

    private final Link editFirstUserCellLink = new Link(driver, EDIT_USER_CELL_LINK);

    private final Button firstNameHeaderButton = new Button(driver, FIRST_NAME_HEADER_LINK);

    private final Button lastNameHeaderButton = new Button(driver, LAST_NAME_HEADER_LINK);

    private final Button loginHeaderButton = new Button(driver, LOGIN_HEADER_LINK);

    private final Button roleHeaderButton = new Button(driver, ROLE_HEADER_LINK);

    private final Button regionHeaderButton = new Button(driver, REGION_HEADER_LINK);

    private final Link firstNameFirstCellLink = new Link(driver, FIRST_NAME_CELL);

    private final Link lastNameFirstCellLink = new Link(driver, LAST_NAME_CELL);

    private final Link roleFirstCellLink = new Link(driver, ROLE_CELL);

    private final Link regionFirstCellLink = new Link(driver, REGION_CELL);

    private final Link pageCountText = new Link(driver, PAGE_COUNT_TEXT);

    private final Link pageNumberText = new Link(driver, PAGE_NUMBER_TEXT);

    private final Link quantityOfFoundUsers = new Link(driver, QUANTITY_OF_FOUND_USERS);

    private final Link showQuantityOfItems = new Link(driver, RESIZE_USERS_LIST_LINK);

    private final Button firstNavigationButton = new Button(driver, FIRST_NAVIGATION_BUTTON);

    private final Button lastNavigationButton = new Button(driver, LAST_NAVIGATION_BUTTON);

    private final Button forwardNavigationButton = new Button(driver, FORWARD_NAVIGATION_BUTTON);

    private final Button backwardNavigationButton = new Button(driver, BACKWARD_NAVIGATION_BUTTON);

    private final Element firstNameColumn = new Element(driver, FIRST_NAME_COLUMN);

    private final Element lastNameColumn = new Element(driver, AdministrationPageLocators.LAST_NAME_COLUMN);

    private final Element loginColumn = new Element(driver, AdministrationPageLocators.LOGIN_COLUMN);

    private final Element roleColumn = new Element(driver, AdministrationPageLocators.ROLE_COLUMN);

    private final Element regionColumn = new Element(driver, AdministrationPageLocators.REGION_COLUMN);

    public final Link getLogInCellLink(final int statusNumber) {

        return new Link(driver, LOGIN_CELL.modify(String.valueOf(statusNumber)));
    }

    public AdministrationPage(final WebDriver driver) {
        super(driver);
    }

    public final Link editUserById(final int userId) {

        return new Link(driver, EDIT_USER_LINK.modify(String.valueOf(userId)))
                .click();
    }

    public final AdministrationPage setSearchText(final String searchText) {

        searchInput.sendKeys(searchText);
        return this;
    }

    public final AdministrationPage clickSearch() {

        searchButton.click();
        return this;
    }

    public final AdministrationPage showQuantityOfItems() {

        showQuantityOfItems.click();
        return this;
    }

    public final AdministrationPage sortTableBy(final SortConditions condition) {

        switch (condition) {

            case FIRST_NAME:
                firstNameHeaderButton.click();
                break;
            case LAST_NAME:
                lastNameHeaderButton.click();
                break;
            case LOGIN:
                loginHeaderButton.click();
                break;
            case ROLE:
                roleHeaderButton.click();
                break;
            case REGION:
                regionHeaderButton.click();
                break;
        }

        return this;
    }

    public final AdministrationPage navigateTableForward() {

        forwardNavigationButton.click();
        return this;
    }

    public final AdministrationPage navigateTableBackward() {

        backwardNavigationButton.click();
        return this;
    }

    public final AdministrationPage navigateTableToLastPage() {

        lastNavigationButton.click();
        return this;
    }

    public final AdministrationPage navigateTableToFirstPage() {

        firstNavigationButton.click();
        return this;
    }

    public final CreateNewUserPage goToCreateUserPage() {

        createUserLink.click();
        return new CreateNewUserPage(driver);
    }

    public final UserInfoPage goToUserInfoPage() {

        userInfoLink.click();
        return new UserInfoPage(driver);
    }

    public final AdministrationPage deleteFirstUser() {

        deleteFirstUserCellLink.click();
        return this;
    }

    public final CreateReportPage goToCreateReportPage() {

        createReportLink.click();
        return new CreateReportPage(driver);
    }

    public final AdministrationPage selectSearchColumnFilter(final String columnFilter) {

        searchFieldFilterDropdown.sendKeys(columnFilter);
        return this;
    }

    public final AdministrationPage selectSearchCondition(final String condition) {

        searchConditionDropdown.sendKeys(condition);
        return this;
    }

    public final AdministrationPage searchForUser(final ColumnFilters columnFilter,
                                                  final SearchConditions searchCondition,
                                                  final String searchText) {

        return selectSearchColumnFilter(columnFilter.toString())
                .selectSearchCondition(searchCondition.toString())
                .setSearchText(searchText)
                .clickSearch();
    }

}

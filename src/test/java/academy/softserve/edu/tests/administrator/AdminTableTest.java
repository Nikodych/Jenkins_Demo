package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.ColumnFilters;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import academy.softserve.edu.enums.administration_page.SortConditions;
import academy.softserve.edu.utils.*;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;
import static academy.softserve.edu.enums.administration_page.SortConditions.*;

public class AdminTableTest extends TestRunner {

    @BeforeMethod
    public final void setAdminTableTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        // after if logIn failure;
        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

        administrationPage = userInfoPage.goToAdministrationPage();
    }

    // To check Admin table is enable or not. And Edit and Delete function is available
    @Test
    final public void testAdminTableIsEnable() {

        assertThat(administrationPage.getEditFirstUserCellLink())
                .isDisplayed();

        assertThat(administrationPage.getDeleteFirstUserCellLink())
                .isDisplayed();
    }

    // To check searching function in Admin Table with first filter All Columns.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForAllColumnsFilter")
    public final void testSearchForAllColumnsFilter(final SearchConditions secondSearchFilter,
                                                    final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.ALL_COLUMNS, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getRoleFirstCellLink())
                .textEquals(comparisonValue);
    }

    // To check searching function in Admin Table with first filter First Name.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForFirstNameFilter")
    public final void testSearchForFirstNameFilter(final SearchConditions secondSearchFilter,
                                                   final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.FIRST_NAME, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getFirstNameFirstCellLink())
                .textEquals(comparisonValue);
    }

    // To check searching function in Admin Table with first filter Last Name
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLastNameFilter")
    public final void testSearchForLastNameFilter(final SearchConditions secondSearchFilter,
                                                  final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.LAST_NAME, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getLastNameFirstCellLink())
                .textEquals(comparisonValue);
    }

    // To check searching function in Admin Table with first filter Login.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForLoginFilter")
    public final void testSearchForLoginFilter(final SearchConditions secondSearchFilter,
                                               final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.LOGIN, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getLogInCellLink(1))
                .textEquals(comparisonValue);
    }

    // To check searching function in Admin Table with first filter Role.
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRoleFilter")
    public final void testSearchForRoleFilter(final SearchConditions secondSearchFilter,
                                              final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.ROLE, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getRoleFirstCellLink())
                .textEquals(comparisonValue);
    }

    // To check searching function in Admin Table with first filter Region
    @Test(dataProviderClass = DataProviders.class, dataProvider = "testSearchingForRegionFilter")
    public final void testSearchForRegionFilter(final SearchConditions secondSearchFilter,
                                                final String searchingValue, final String comparisonValue) {

        administrationPage.searchForUser(ColumnFilters.REGION, secondSearchFilter, searchingValue);

        assertThat(administrationPage.getRegionFirstCellLink())
                .textEquals(comparisonValue);
    }

    //Check how many users shows in the Admin Table, after click on the Show 5 or Show 10 buttons.
    @Test
    public final void testVisibleUsersInTable() {

        assertThat(administrationPage.getQuantityOfFoundUsers())
                .isParseIntQuantityMoreThan(5);

        administrationPage.showQuantityOfItems();

        assertThat(administrationPage.getFirstNameColumn())
                .isQuantityMoreThan(5);

        assertThat(administrationPage.getFirstNameColumn())
                .isQuantityLessOrEqualsThan(10);

        administrationPage.showQuantityOfItems();

        assertThat(administrationPage.getFirstNameColumn())
                .isQuantityEqualTo(5);
    }

    //To check is number of found users displays the actual number of users for this criterion.
    @Test
    public final void testRealSearchResult() {

        DBHelper.createValidUserInDB();

        administrationPage.searchForUser(ColumnFilters.LOGIN, SearchConditions.EQUALS, "justlogin");

        assertThat(administrationPage.getLoginColumn())
                .isQuantityEqualTo(1);

        DBHandler.deleteUser(DBHandler.getLastUser()
                .getId());
    }

    //To check is sorting function is available for First Name column in the Admin Grid.
    @Test
    public final void testSortingFirstNameColumn() {

        assertThat(administrationPage.getLogInCellLink(2))
                .isDisplayed();

        administrationPage.sortTableBy(FIRST_NAME);

        final boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage.getFirstNameColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Last Name column in the Admin Table.
    @Test
    public final void testSortingLastNameColumn() {

        assertThat(administrationPage.getLogInCellLink(2))
                .isDisplayed();

        administrationPage.sortTableBy(LAST_NAME);

        final boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage.getLastNameColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Login column in the Admin Table.
    @Test
    public final void testSortingLoginColumn() {

        assertThat(administrationPage.getLogInCellLink(2))
                .isDisplayed();

        administrationPage.sortTableBy(LOGIN);

        final boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage.getLoginColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Role column in the Admin Table.
    @Test
    public final void testSortingRoleColumn() {

        assertThat(administrationPage.getLogInCellLink(2))
                .isDisplayed();

        administrationPage.sortTableBy(ROLE);

        final boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage.getRoleColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    //To check is sorting function is available for Region column in the Admin Table.
    @Test
    public final void testSortingRegionColumn() {

        assertThat(administrationPage.getLogInCellLink(2))
                .isDisplayed();

        administrationPage.sortTableBy(REGION);

        final boolean isSortedByAscent = SortUtil
                .isListSortedByAsc(administrationPage.getRegionColumn()
                        .getElements());

        assertThat(isSortedByAscent).isTrue();
    }

    @Test
    public final void testAdminTableNavigation() {

        final int quantityOfGridsPages = Integer.parseInt(administrationPage.getPageCountText()
                .getText());

        assertThat(administrationPage.getPageCountText())
                .isParseIntQuantityMoreThan(1);

        assertThat(administrationPage.getFirstNavigationButton())
                .isDisabled();

        assertThat(administrationPage.getBackwardNavigationButton())
                .isDisabled();

        administrationPage.navigateTableForward();

        assertThat(administrationPage.getPageNumberText())
                .isParseIntQuantityEqualTo(2);

        administrationPage.navigateTableBackward();

        assertThat(administrationPage.getPageNumberText())
                .isParseIntQuantityEqualTo(1);

        administrationPage.navigateTableToLastPage();

        assertThat(administrationPage.getPageNumberText())
                .isParseIntQuantityEqualTo(quantityOfGridsPages);

        administrationPage.navigateTableToFirstPage();

        assertThat(administrationPage.getPageNumberText())
                .isParseIntQuantityEqualTo(1);
    }

}

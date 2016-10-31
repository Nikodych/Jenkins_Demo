package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.ColumnFilters;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoAdministrationButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final ColumnFilters COLUMN_FILTER = ColumnFilters.ROLE;
        final SearchConditions ROLE_FILTER = SearchConditions.CONTAINS;
        final String TEXT = "A";

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        administrationPage.searchForUser(COLUMN_FILTER, SearchConditions.CONTAINS, TEXT);

        administrationPage.goToUserInfoPage();

        userInfoPage.goToAdministrationPage();

        assertThat(administrationPage.getSearchFieldFilterDropdown())
                .selectedDropdownEqualsIgnoreCase(COLUMN_FILTER.toString());

        assertThat(administrationPage.getSearchConditionDropdown())
                .selectedDropdownEqualsIgnoreCase(ROLE_FILTER.toString());

        assertThat(administrationPage.getSearchInput())
                .valueEquals(TEXT);
    }
}

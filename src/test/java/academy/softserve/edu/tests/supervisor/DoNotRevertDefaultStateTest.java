package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.item_management_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoItemManagementButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getItemManagementLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final SearchConditions fieldFilter = SearchConditions.DESCRIPTION;
        final String fieldFilterValue = "Fruits";

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.goToItemManagementPage();

        itemManagementPage.searchForProduct(fieldFilter, fieldFilterValue)
                .goToUserInfoPage();

        userInfoPage.goToItemManagementPage();

        assertThat(itemManagementPage.getSearchFieldFilterDropdown())
                .selectedDropdownEqualsIgnoreCase(fieldFilter.toString());

        assertThat(itemManagementPage.getSearchInput())
                .valueEquals(fieldFilterValue);
    }
}

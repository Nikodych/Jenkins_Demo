package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.merchandiser_ordering_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoOrderingButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getMerchandiserOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final SearchConditions searchOrders = SearchConditions.STATUS;
        final String searchOrdersValue = "Ordered";

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        merchandiserOrderingPage = userInfoPage.goToMerchandiserOrderingPage();

        merchandiserOrderingPage.searchForOrder(searchOrders, searchOrdersValue)
                .goToUserInfoPage();

        userInfoPage.goToMerchandiserOrderingPage();

        assertThat(merchandiserOrderingPage.getSearchDropdown())
                .selectedDropdownEqualsIgnoreCase(searchOrders.toString());

        assertThat(merchandiserOrderingPage.getSearchInput())
                .valueEquals(searchOrdersValue);
    }

}

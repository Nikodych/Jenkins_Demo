package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.customer_ordering_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class DoNotRevertDefaultStateTest extends TestRunner {

    @Test
    public void testUserInfoButtonsDisplayed() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testDoNotRevertDefaultState() {

        final SearchConditions searchOrders = SearchConditions.STATUS;
        final String searchOrdersValue = "Ordered";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        customerOrderingPage.searchForOrder(searchOrders, searchOrdersValue);

        customerOrderingPage.goToUserInfoPage();

        userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getSearchDropdown())
                .selectedDropdownEqualsIgnoreCase(searchOrders.toString());

        assertThat(customerOrderingPage.getSearchInput())
                .valueEquals(searchOrdersValue);
    }
}

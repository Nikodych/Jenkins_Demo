package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.customer_ordering_page.SearchConditions;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class SearchTest extends TestRunner {

    @Test
    public void testStatusSearch() {

        final SearchConditions dropdownStatus = SearchConditions.STATUS;
        final String textFieldValueByStatus = "Created";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        customerOrderingPage.searchForOrder(dropdownStatus, textFieldValueByStatus);

        assertThat(customerOrderingPage.getSearchStatusResult())
                .isDisplayed();
    }

    @Test
    public void testNameSearch() {

        final SearchConditions dropdownName = SearchConditions.ORDER_NAME;
        final String textFieldValueByName = "OrderName3";

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        customerOrderingPage.searchForOrder(dropdownName, textFieldValueByName);

        assertThat(customerOrderingPage.getSearchNameResult())
                .isDisplayed();
    }

    @Test
    public void testElementsSearch() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(5);

        customerOrderingPage.changeItemsPerPage();

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityMoreThan(5);

        assertThat(customerOrderingPage.getOrderNameColumnElements())
                .isQuantityLessOrEqualsThan(10);
    }

}

package academy.softserve.edu.tests.customer;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest extends TestRunner {

    @Test
    public void testDefaultUserInfoPage() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public void testUserInfoButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();
    }

    @Test
    public void testOrderingButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        assertThat(userInfoPage.getCustomerOrderingLink())
                .isDisplayed();
    }

    @Test
    public void testActiveOrderingPage() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();
    }

    @Test
    public void testSwitchTabsUserOrdering() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);

        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();

        assertThat(customerOrderingPage.getCreateNewOrderLink())
                .isDisplayed();

        customerOrderingPage.goToUserInfoPage();

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }
}

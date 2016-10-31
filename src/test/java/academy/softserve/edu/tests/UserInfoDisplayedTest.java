package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DataProviders;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class UserInfoDisplayedTest extends TestRunner {

    @Test(dataProvider = "testDataForAllUsersRole", dataProviderClass = DataProviders.class)
    public void testUserInfoDisplayed(final Roles role) {

        userInfoPage = logInPage.logInAs(role);

        assertThat(userInfoPage.getFirstNameValue())
                .isTextNotEmpty();

        assertThat(userInfoPage.getLastNameValue())
                .isTextNotEmpty();

        assertThat(userInfoPage.getCustomerTypeValue())
                .isTextNotEmpty();

        assertThat(userInfoPage.getRoleValue())
                .isTextNotEmpty();
    }

}

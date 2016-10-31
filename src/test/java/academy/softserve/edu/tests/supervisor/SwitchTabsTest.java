package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest extends TestRunner {

    @Test
    public void testDefaultUserInfoPage() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public void testUserInfoButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();
    }

    @Test
    public void testOrderingButtonCheck() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getItemManagementLink())
                .isDisplayed();
    }

    @Test
    public void testActiveOrderingPage() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.goToItemManagementPage();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();
    }

    @Test
    public void testSwitchTabsUserOrdering() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.goToItemManagementPage();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        itemManagementPage.goToUserInfoPage();

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }
}

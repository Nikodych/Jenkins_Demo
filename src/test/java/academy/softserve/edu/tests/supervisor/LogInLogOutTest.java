package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class LogInLogOutTest extends TestRunner {

    @Test
    public final void testLogIn() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public final void testLogOutButtonVisibility() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

        assertThat(userInfoPage.getLogOutButton())
                .isDisplayed();

        itemManagementPage = userInfoPage.goToItemManagementPage();

        // we have to check switching between pages, has the same issue with logIn check;
        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        assertThat(itemManagementPage.getLogOutButton())
                .isDisplayed();
    }

    @Test
    public final void testLogOut() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.goToItemManagementPage();

        itemManagementPage.doLogOut();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }
}

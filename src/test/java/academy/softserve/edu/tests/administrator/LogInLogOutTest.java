package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class LogInLogOutTest extends TestRunner {

    @Test
    public final void testLogIn() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public final void testLogOutButtonVisibility() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

        assertThat(userInfoPage.getLogOutButton())
                .isDisplayed();

        administrationPage = userInfoPage.goToAdministrationPage();
        // we have to check switching between pages, has the same issue with logIn check;
        assertThat(administrationPage.getFoundUsersTextLabel())
                .isDisplayed();

        assertThat(administrationPage.getLogOutButton())
                .isDisplayed();
    }

    @Test
    public final void testLogOut() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);
        administrationPage = userInfoPage.goToAdministrationPage();
        administrationPage.doLogOut();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }
}

package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class LogInLogOutTest extends TestRunner {

    @Test
    public final void testLogIn() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @Test
    public final void testLogOutButtonVisibility() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);
        // below we have to check if logIn was successful because every page has
        // logOut button with same locator and we could get false positive result
        // after logIn failure;
        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

        assertThat(userInfoPage.getLogOutButton())
                .isDisplayed();

        merchandiserOrderingPage = userInfoPage.goToMerchandiserOrderingPage();
        // we have to check switching between pages, has the same issue with logIn check;
        assertThat(merchandiserOrderingPage.getSearchByText())
                .isDisplayed();

        assertThat(merchandiserOrderingPage.getLogOutButton())
                .isDisplayed();
    }

    @Test
    public final void testLogOut() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        merchandiserOrderingPage = userInfoPage.goToMerchandiserOrderingPage();

        merchandiserOrderingPage.doLogOut();

        assertThat(logInPage.getLogInButton())
                .isDisplayed();
    }
}

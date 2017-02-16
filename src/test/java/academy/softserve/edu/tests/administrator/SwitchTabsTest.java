package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest extends TestRunner {

    //  This test checks if Administrator user can see the following tabs: вЂAdministrationвЂ™ and вЂUser InfoвЂ™(default),
    //  test checks if Administrator user can switch between tabs.

    @Test
    public final void testSwitchingBetweenTabs() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();

        administrationPage = userInfoPage.goToAdministrationPage();

        assertThat(administrationPage.getUserInfoLink())
                .isDisplayed();

        assertThat(administrationPage.getAdministrationLink())
                .isDisplayed();

        administrationPage.goToUserInfoPage();

        assertThat(userInfoPage.getUserInfoLink())
                .isDisplayed();

        assertThat(userInfoPage.getAdministrationLink())
                .isDisplayed();

        userInfoPage.doLogOut();
    }
}

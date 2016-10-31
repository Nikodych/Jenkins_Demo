package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.repos.UserRepo;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class CreatedUserLogInTest extends TestRunner {

    private static final User newUser = UserRepo.getValidUser();

    @Test(priority = 1)
    public void testTabsExist() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        assertThat(administrationPage.getCreateUserLink())
                .isDisplayed();
    }


    @Test(priority = 2)
    public void testCreateUserPageExist() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        createNewUserPage = administrationPage.goToCreateUserPage();

        assertThat(createNewUserPage.getPageInfoText())
                .isDisplayed();
    }

    @Test(priority = 3)
    public void testCreatedUserExist() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        createNewUserPage = administrationPage.goToCreateUserPage();

        createNewUserPage.setUserFields(newUser)
                .createUser();

        assertThat(DBHandler.getUserByLogin(newUser.getLogin()))
                .isNotNull();
    }

    @Test(priority = 4)
    public void testCreatedUserLogIn() {

        userInfoPage = logInPage.logInAs(newUser.getLogin(), newUser.getPassword());

        assertThat(userInfoPage.getUserInfoFieldSet())
                .isDisplayed();
    }

    @AfterClass
    public final void deleteTestUser() {

        DBHandler.deleteUser(DBHandler.getUserByLogin(newUser.getLogin())
                .getId());
    }
}

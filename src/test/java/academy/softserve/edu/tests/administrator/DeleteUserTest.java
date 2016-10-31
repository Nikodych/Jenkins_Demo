package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.ColumnFilters;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class DeleteUserTest extends TestRunner {

    private User testUser;

    @BeforeClass
    public final void createTestUser() {

        final int testUserId = DBHelper.createValidUserInDB();
        testUser = DBHandler.getUserById(testUserId);
    }

    @BeforeMethod
    public final void setUpTests() {

        final ColumnFilters FILTER_DROPDOWN = ColumnFilters.LOGIN;
        final SearchConditions CONDITION_DROPDOWN = SearchConditions.EQUALS;

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage();

        administrationPage.searchForUser(FILTER_DROPDOWN, CONDITION_DROPDOWN, testUser.getLogin());

    }

    @Test
    public final void testDeleteUserAndClickCancel() {

        administrationPage.deleteFirstUser()
                .dismissAlert();

        assertThat(DBHandler.getUserByLogin(testUser.getLogin()))
                .isUserActive();
    }

    @Test
    public final void testDeleteUserAndClickConfirm() {

        administrationPage.deleteFirstUser()
                .acceptAlert();

        administrationPage.refreshPage();

        assertThat(DBHandler.getUserByLogin(testUser.getLogin()))
                .isUserInactive();
    }

    @AfterClass
    public final void deleteTestUser() {
        DBHandler.deleteUser(DBHandler.getUserByLogin(testUser.getLogin())
                .getId());
    }
}

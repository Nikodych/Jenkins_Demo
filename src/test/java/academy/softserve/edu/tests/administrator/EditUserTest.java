package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.EditUserPage;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditUserTest extends TestRunner {

    private User testUser;
    private int testUserId;

    @BeforeClass
    public final void createTestUser() {

        testUserId = DBHelper.createValidUserInDB();
        testUser = DBHandler.getUserById(testUserId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.ADMINISTRATOR);

        administrationPage = userInfoPage.goToAdministrationPage()
                .navigateTableToLastPage();

        administrationPage.editUserById(testUserId);

        editUserPage = new EditUserPage(driver);
    }

    @Test
    public final void testAreEditFieldsFilledCorrectly() {

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        assertThat(editUserPage.getFirstNameInput())
                .valueEquals(testUser.getFirstName());

        assertThat(editUserPage.getLastNameInput())
                .valueEquals(testUser.getLastName());

        assertThat(editUserPage.getNewPasswordInput())
                .isValueEmpty();

        assertThat(editUserPage.getConfirmPasswordInput())
                .isValueEmpty();

        assertThat(editUserPage.getEmailAddressInput())
                .valueEquals(testUser.getEmail());

        assertThat(editUserPage.getRoleDropdown())
                .selectedDropdownEqualsIgnoreCase(testUser.getRoleName());

        assertThat(editUserPage.getRegionDropdown())
                .selectedDropdownEqualsIgnoreCase(testUser.getRegionName());
    }

    @Test
    public final void testEditUserAndClickSave() {

        final String NEW_USER_LAST_NAME = "Tsoni";
        final String NEW_USER_PASSWORD = "1qaz2wsx";
        final Regions NEW_REGION = Regions.WEST;

        testUser.setLastName(NEW_USER_LAST_NAME);
        testUser.setPassword(NEW_USER_PASSWORD);
        testUser.setRegionReference(NEW_REGION.ordinal() + 1);

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage.setUserFields(testUser)
                .editUser();

        testUser = DBHandler.getUserById(testUserId);

        assertThat(testUser).lastNameEquals(NEW_USER_LAST_NAME);

        assertThat(testUser).passwordEquals(NEW_USER_PASSWORD);

        assertThat(testUser).regionNameEquals(NEW_REGION.toString());

        assertThat(administrationPage.getFoundUsersTextLabel())
                .isDisplayed();
    }

    @Test
    public final void testEditUserAndClickCancel() {

        final String OLD_USER_LASTNAME = testUser.getLastName();
        final String NEW_USER_LASTNAME = "newLastName";

        testUser.setLastName(NEW_USER_LASTNAME);

        assertThat(editUserPage.getNewPasswordText())
                .isDisplayed();

        editUserPage.setUserFields(testUser)
                .cancelEditingUser();

        assertThat(DBHandler.getUserById(testUserId))
                .lastNameEquals(OLD_USER_LASTNAME);

        assertThat(administrationPage.getFoundUsersTextLabel())
                .isDisplayed();
    }

    @AfterClass
    public final void deleteTestUser() {
        DBHandler.deleteUser(testUserId);
    }
}

package academy.softserve.edu.pageobjects;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.wrappers.Button;
import academy.softserve.edu.elements.wrappers.Dropdown;
import academy.softserve.edu.elements.wrappers.TextInputField;
import academy.softserve.edu.elements.wrappers.TextLabel;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.CreateUserPageLocators.*;

@Getter
public class CreateNewUserPage extends PageObject<CreateNewUserPage> {

    public CreateNewUserPage(WebDriver driver) {
        super(driver);
    }

    /**
     * pageInfoText is an unique element on the CreateNewUserPage,
     * can be used as identification of page;
     */
    private final TextLabel pageInfoText = new TextLabel(driver, PAGE_INFO_TEXT);

    private final TextInputField logInNameInput = new TextInputField(driver, LOGIN_NAME_INPUT);

    private final TextInputField firstNameInput = new TextInputField(driver, FIRST_NAME_INPUT);

    private final TextInputField lastNameInput = new TextInputField(driver, LAST_NAME_INPUT);

    private final TextInputField passwordInput = new TextInputField(driver, PASSWORD_INPUT);

    private final TextInputField confirmPasswordInput = new TextInputField(driver, CONFIRM_PASSWORD_INPUT);

    private final TextInputField emailInput = new TextInputField(driver, EMAIL_INPUT);

    private final Dropdown regionDropdown = new Dropdown(driver, REGION_DROPDOWN);

    private final Dropdown roleDropdown = new Dropdown(driver, ROLE_DROPDOWN);

    private final Button createButton = new Button(driver, CREATE_BUTTON);

    private final Button cancelButton = new Button(driver, CANCEL_BUTTON);

    public final CreateNewUserPage setLoginName(final String login) {

        logInNameInput.sendKeys(login);
        return this;
    }

    public final CreateNewUserPage setFirstName(final String firstName) {

        firstNameInput.sendKeys(firstName);
        return this;
    }

    public final CreateNewUserPage setLastName(final String lastName) {

        lastNameInput.sendKeys(lastName);
        return this;
    }

    public final CreateNewUserPage setPassword(final String password) {

        passwordInput.sendKeys(password);
        return this;
    }

    public final CreateNewUserPage setConfirmPassword(final String password) {

        confirmPasswordInput.sendKeys(password);
        return this;
    }

    public final CreateNewUserPage setEmail(final String email) {

        emailInput.sendKeys(email);
        return this;
    }

    public final CreateNewUserPage selectRegion(final Regions region) {

        regionDropdown.sendKeys(region.toString());
        return this;
    }

    public final CreateNewUserPage selectRole(final Roles role) {

        roleDropdown.sendKeys(role.toString());
        return this;
    }

    public final CreateNewUserPage setUserFields(final User newUser) {

        return setLoginName(newUser.getLogin())
                .setFirstName(newUser.getFirstName())
                .setLastName(newUser.getLastName())
                .setPassword(newUser.getPassword())
                .setConfirmPassword(newUser.getPassword())
                .setEmail(newUser.getEmail())
                .selectRegion(Regions.valueOf(newUser.getRegionName()))
                .selectRole(Roles.valueOf(newUser.getRoleName()));
    }

    public final AdministrationPage createUser() {

        createButton.click();
        return new AdministrationPage(driver);
    }

}

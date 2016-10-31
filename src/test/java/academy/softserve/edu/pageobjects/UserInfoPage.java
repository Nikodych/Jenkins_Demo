package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Link;
import academy.softserve.edu.elements.wrappers.TextLabel;
import academy.softserve.edu.enums.Languages;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.AdministrationPageLocators.ADMINISTRATION_LINK;
import static academy.softserve.edu.elements.locators.customer.CustomerOrderingPageLocators.CUSTOMER_ORDERING_LINK;
import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserOrderingPageLocators.MERCHANDISER_ORDERING_LINK;
import static academy.softserve.edu.elements.locators.shared.SharedLocators.ENGLISH_SWITCH_LINK;
import static academy.softserve.edu.elements.locators.shared.SharedLocators.UKRAINIAN_SWITCH_LINK;
import static academy.softserve.edu.elements.locators.supervisor.ItemManagementPageLocators.ITEM_MANAGEMENT_LINK;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.*;

@Getter
public class UserInfoPage extends PageObject<UserInfoPage> {

    private final Link administrationLink = new Link(driver, ADMINISTRATION_LINK);

    private final Link itemManagementLink = new Link(driver, ITEM_MANAGEMENT_LINK);

    private final Link customerOrderingLink = new Link(driver, CUSTOMER_ORDERING_LINK);

    private final Link merchandiserOrderingLink = new Link(driver, MERCHANDISER_ORDERING_LINK);

    private final Link ukrainianSwitchLink = new Link(driver, UKRAINIAN_SWITCH_LINK);

    private final Link englishSwitchLink = new Link(driver, ENGLISH_SWITCH_LINK);

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    /**
     * userInfoFieldSet is an unique element on the UserInfoPage,
     * can be used as identification of page;
     */
    private final TextLabel userInfoFieldSet = new TextLabel(driver, USER_INFO_FIELDSET);

    private final TextLabel firstNameValue = new TextLabel(driver, FIRST_NAME_VALUE);

    private final TextLabel lastNameValue = new TextLabel(driver, LAST_NAME_VALUE);

    private final TextLabel customerTypeValue = new TextLabel(driver, CUSTOMER_TYPE_VALUE);

    private final TextLabel roleValue = new TextLabel(driver, ROLE_VALUE);

    public UserInfoPage(final WebDriver driver) {
        super(driver);
    }

    public final AdministrationPage goToAdministrationPage() {

        administrationLink.click();
        return new AdministrationPage(driver);
    }

    public final CustomerOrderingPage goToCustomerOrderingPage() {

        customerOrderingLink.click();
        return new CustomerOrderingPage(driver);
    }

    public final ItemManagementPage goToItemManagementPage() {

        itemManagementLink.click();
        return new ItemManagementPage(driver);
    }

    public final MerchandiserOrderingPage goToMerchandiserOrderingPage() {

        merchandiserOrderingLink.click();
        return new MerchandiserOrderingPage(driver);
    }

    public final UserInfoPage changeLanguageTo(final Languages language) {

        switch (language) {

            case UA:
                ukrainianSwitchLink.click();
                break;
            case EN:
                englishSwitchLink.click();
                break;
        }

        return this;
    }
}

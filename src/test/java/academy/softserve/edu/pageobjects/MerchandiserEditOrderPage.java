package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.*;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.merchandiser.MerchandiserEditOrderPageLocators.*;
import static academy.softserve.edu.elements.locators.userinfo.UserInfoPageLocators.USER_INFO_LINK;

@Getter
public class MerchandiserEditOrderPage extends PageObject<MerchandiserEditOrderPage> {

    private final Link userInfoLink = new Link(driver, USER_INFO_LINK);

    private final Dropdown orderStatusDropdown = new Dropdown(driver, ORDER_STATUS_DROPDOWN);

    private final Link showItems = new Link(driver, SHOW_ITEMS_LINK);

    private final Button saveButton = new Button(driver, SAVE_BUTTON);

    private final Link chooseDateLink = new Link(driver, CHOOSE_DATE_LINK);

    private final Link lastDateLink = new Link(driver, LAST_DAY_LINK);

    public MerchandiserEditOrderPage(final WebDriver driver) {
        super(driver);
    }

    public final MerchandiserEditOrderPage changeOrderStatusTo(final String status) {

        orderStatusDropdown.selectByValue(status);
        return this;
    }

    public final MerchandiserOrderingPage saveOrder() {

        saveButton.click();
        return new MerchandiserOrderingPage(driver);
    }

    public final MerchandiserEditOrderPage showItems() {

        showItems.click();
        return this;
    }

    public final MerchandiserEditOrderPage clickChooseDate() {

        chooseDateLink.click();
        return this;
    }

    public final MerchandiserEditOrderPage clickLastDate() {

        lastDateLink.click();
        return this;
    }

    public final MerchandiserEditOrderPage chooseValidDeliveryDate() {

        return clickChooseDate().clickLastDate();
    }

}
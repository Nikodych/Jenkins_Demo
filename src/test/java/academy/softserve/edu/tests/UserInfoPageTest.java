package academy.softserve.edu.tests;

import academy.softserve.edu.enums.Languages;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;
import static academy.softserve.edu.enums.Languages.EN;
import static academy.softserve.edu.enums.Languages.UA;

public class UserInfoPageTest extends TestRunner {

    //To check English by default
    @Test
    public final void testDefaultEnglish() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getMerchandiserOrderingLink())
                .textEquals("Ordering");
    }

    //To check switch to Ukrainian language from default English language
    @Test
    public final void testSwitchToUkrainian() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage.changeLanguageTo(UA);

        assertThat(userInfoPage.getMerchandiserOrderingLink())
                .textEquals("Замовлення");
    }

    //To check switch to English from Ukrainian
    @Test
    public final void testSwitchToEnglish() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage.changeLanguageTo(UA)
                .changeLanguageTo(EN);

        assertThat(userInfoPage.getMerchandiserOrderingLink())
                .textEquals("Ordering");
    }

    //To check English button is bold or not, when enabled English
    @Test
    public final void testEnglishButtonBold() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        assertThat(userInfoPage.getEnglishSwitchLink())
                .isTextBold();
    }

    //To check Ukrainian button is bold or not, when enabled Ukrainian
    @Test
    public final void testUkrainianButtonBold() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        userInfoPage.changeLanguageTo(UA);

        assertThat(userInfoPage.getUkrainianSwitchLink())
                .isTextBold();
    }
}
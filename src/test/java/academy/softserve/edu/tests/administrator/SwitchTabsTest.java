package academy.softserve.edu.tests.administrator;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.pageobjects.AdministrationPage;
import academy.softserve.edu.pageobjects.LogInPage;
import academy.softserve.edu.pageobjects.UserInfoPage;
import academy.softserve.edu.utils.PropertiesReader;
/*import academy.softserve.edu.utils.TestRunner;*/
import lombok.Getter;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class SwitchTabsTest /*extends TestRunner*/ {

//***************************************************************


    public static final String HOME_URL = PropertiesReader.getDefaultProperty("login.url");
    public static final String PATH_TO_CHROME_DRIVER = PropertiesReader.getDefaultProperty("path.webdriver.chrome.linux");
    public static final int TIMEOUT = 30;

    @Getter
    protected WebDriver driver;

    protected UserInfoPage userInfoPage;
    protected LogInPage logInPage;
    protected AdministrationPage administrationPage;


    @BeforeMethod
    public final void setUp() {

        System.setProperty("webdriver.chrome.driver", PATH_TO_CHROME_DRIVER);

        driver = new ChromeDriver();

        Dimension dimension = new Dimension(1920, 1080);

        driver.manage()
                .window()
                .setSize(dimension);

        driver.manage().timeouts().implicitlyWait(TIMEOUT, TimeUnit.SECONDS);

        driver.get(HOME_URL);

        logInPage = new LogInPage(driver);

    }


//***************************************************************


    //  This test checks if Administrator user can see the following tabs: ‘Administration’ and ‘User Info’(default),
    //  test checks if Administrator user can switch between tabs.

    @Test
    final public void testSwitchingBetweenTabs() {

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

//*******************************************************************
    @AfterMethod
    public final void tearDown() {

        driver.quit();
    }
//*******************************************************************
}

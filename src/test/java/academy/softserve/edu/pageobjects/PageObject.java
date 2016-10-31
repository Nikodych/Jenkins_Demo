package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Button;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.shared.SharedLocators.LOG_OUT_BUTTON;

@Getter
public abstract class PageObject<T> {

    protected WebDriver driver;

    private Button logOutButton;

    public PageObject(final WebDriver driver) {

        this.driver = driver;
        logOutButton = new Button(driver, LOG_OUT_BUTTON);
    }

    public final void clickLogOut() {

        logOutButton.click();
    }

    public final LogInPage doLogOut() {

        clickLogOut();
        acceptAlert();
        return new LogInPage(driver);

    }

    public final void acceptAlert() {

        driver.switchTo()
                .alert()
                .accept();
    }

    public final void dismissAlert() {

        driver.switchTo()
                .alert()
                .dismiss();
    }

    public final T refreshPage() {

        driver.navigate()
                .refresh();
        return (T) this;
    }
}

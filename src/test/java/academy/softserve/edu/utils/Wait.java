package academy.softserve.edu.utils;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//TODO re-do waits - https://ssu-jira.softserveinc.com/browse/IFATQCZZ-90
public class Wait {

    private WebDriver driver;
    private ILocator locator;
    final private int timeout = 200;

    public Wait(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
    }

    public final WebElement waitUntilElementIsPresent() {

        return new WebDriverWait(driver, timeout)
                //TODO replace StaleElementReferenceException with NoSuchElement
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.presenceOfElementLocated(locator.getBy()));
    }

    public final WebElement waitUntilElementIsClickable() {

        return new WebDriverWait(driver, timeout)
                //TODO replace StaleElementReferenceException with NoSuchElement
                .ignoring(StaleElementReferenceException.class)
                .until(ExpectedConditions.elementToBeClickable(locator.getBy()));
    }
}

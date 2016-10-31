package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Wait;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class AbstractElement<T> {

    protected WebDriver driver;
    protected ILocator locator;
    final protected Wait wait;

    AbstractElement(final WebDriver driver, final ILocator locator) {

        this.driver = driver;
        this.locator = locator;
        wait = new Wait(driver, locator);
    }

    final public String getLocatorName() {
        return locator.getName();
    }

    final public By getLocatorValue() {
        return locator.getBy();
    }

    final public WebElement getElement() {
        return wait.waitUntilElementIsPresent();
    }

    final public boolean isDisplayed() {
        return wait.waitUntilElementIsPresent().isDisplayed();
    }

    final public boolean isEnabled() {
        return wait.waitUntilElementIsPresent().isEnabled();
    }

    final public String getText() {
        return wait.waitUntilElementIsPresent().getText();
    }

    final public List<WebElement> getElements() {

        wait.waitUntilElementIsPresent();
        return driver.findElements(locator.getBy());
    }

    final public String getId() {
        return wait.waitUntilElementIsPresent().getAttribute("id");
    }

    final public String getValue() {
        return wait.waitUntilElementIsPresent().getAttribute("value");
    }

}

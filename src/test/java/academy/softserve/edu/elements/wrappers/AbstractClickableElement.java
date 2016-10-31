package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;

public abstract class AbstractClickableElement<T> extends AbstractElement {

    AbstractClickableElement(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public T click() {

        wait.waitUntilElementIsClickable().click();
        Logger.logInfo("<font color='black'>Clicked On "
                + "<b>" + locator.getName() + "</b></font>");
        return (T) this;
    }
}

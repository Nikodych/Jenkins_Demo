package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import academy.softserve.edu.utils.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Dropdown extends AbstractClickableElement<Dropdown> {

    public Dropdown(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

    final public Dropdown selectByValue(final String valueOfElement) {

        new Select(wait.waitUntilElementIsClickable()).selectByValue(valueOfElement);
        return this;
    }

    final public void sendKeys(final String inputText) {

        wait.waitUntilElementIsClickable().sendKeys(inputText);
        Logger.logInfo("<font color='black'>Selected by value: " + inputText + " into " + "<b>"
                + locator.getName() + "</b></font>");
    }

}

package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class Element extends AbstractElement<Element> {

    public Element(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

}

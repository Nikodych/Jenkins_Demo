package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class Link extends AbstractClickableElement<Link> {

    public Link(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }
}

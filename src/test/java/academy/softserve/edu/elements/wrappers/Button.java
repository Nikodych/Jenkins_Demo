package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class Button extends AbstractClickableElement<Button> {

    public Button(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

}

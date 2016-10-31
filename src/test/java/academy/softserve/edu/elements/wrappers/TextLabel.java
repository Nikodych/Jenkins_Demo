package academy.softserve.edu.elements.wrappers;

import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.WebDriver;

public class TextLabel extends AbstractElement<TextLabel> {

    public TextLabel(final WebDriver driver, final ILocator locator) {
        super(driver, locator);
    }

}

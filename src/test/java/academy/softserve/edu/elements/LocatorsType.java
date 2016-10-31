package academy.softserve.edu.elements;

import org.openqa.selenium.By;

public enum LocatorsType {

    BY_CLASS_NAME {
        @Override
        public By getBy(final String locator) {
            return By.className(locator);
        }
    },

    BY_ID {
        @Override
        public By getBy(final String locator) {
            return By.id(locator);
        }
    },

    BY_NAME {
        @Override
        public By getBy(final String locator) {
            return By.name(locator);
        }
    },

    BY_XPATH {
        @Override
        public By getBy(final String locator) {
            return By.xpath(locator);
        }
    };

    public abstract By getBy(final String locator);

}

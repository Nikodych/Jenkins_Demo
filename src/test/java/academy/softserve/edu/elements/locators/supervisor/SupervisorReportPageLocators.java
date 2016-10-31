package academy.softserve.edu.elements.locators.supervisor;

import academy.softserve.edu.elements.LocatorsType;
import academy.softserve.edu.elements.interfaces.ILocator;
import org.openqa.selenium.By;

public enum SupervisorReportPageLocators implements ILocator {

    REPORT_PAGE_EXISTS("Report Page Exists",
            LocatorsType.BY_ID,
            "grid");

    protected String elementName;
    protected LocatorsType locatorType;
    protected String locatorValue;
    private String modifiedLocator;

    SupervisorReportPageLocators(final String elementName,
                                 final LocatorsType locatorType, final String locatorValue) {
        this.elementName = elementName;
        this.locatorType = locatorType;
        this.locatorValue = locatorValue;
    }

    @Override
    public String getName() {
        return this.elementName;
    }

    @Override
    public By getBy() {
        By by;
        if (this.modifiedLocator == null) {
            by = this.locatorType.getBy(this.locatorValue);
        } else {
            by = this.locatorType.getBy(this.modifiedLocator);
        }
        return by;
    }

    @Override
    public SupervisorReportPageLocators modify(final String parameter) {
        this.modifiedLocator = String.format(this.locatorValue, parameter);
        return this;
    }

}
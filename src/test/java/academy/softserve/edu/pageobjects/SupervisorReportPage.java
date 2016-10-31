package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.locators.supervisor.SupervisorReportPageLocators;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

@Getter
public class SupervisorReportPage extends PageObject<SupervisorReportPage> {

    private final TextLabel reportPageExists = new TextLabel(driver, SupervisorReportPageLocators.REPORT_PAGE_EXISTS);

    public SupervisorReportPage(final WebDriver driver) {
        super(driver);
    }

}
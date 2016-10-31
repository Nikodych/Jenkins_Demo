package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Link;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.supervisor.SupervisorCreateReportPageLocators.SAVE_REPORT_LINK;

@Getter
public class SupervisorCreateReportPage extends PageObject<SupervisorCreateReportPage> {

    private final Link saveReportLink = new Link(driver, SAVE_REPORT_LINK);

    public SupervisorCreateReportPage(final WebDriver driver) {
        super(driver);
    }

    public final SupervisorReportPage saveReport() {

        saveReportLink.click();
        return new SupervisorReportPage(driver);
    }
}
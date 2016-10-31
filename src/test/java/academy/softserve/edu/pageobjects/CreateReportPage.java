package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Link;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.administrator.CreateReportPageLocators.SAVE_REPORT_LINK;

@Getter
public class CreateReportPage extends PageObject<CreateReportPage> {

    private final Link saveReportLink = new Link(driver, SAVE_REPORT_LINK);

    public CreateReportPage(final WebDriver driver) {
        super(driver);
    }

    public final ReportPage saveReport() {

        saveReportLink.click();
        return new ReportPage(driver);
    }
}

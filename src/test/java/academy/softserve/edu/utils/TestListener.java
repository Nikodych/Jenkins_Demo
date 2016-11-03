package academy.softserve.edu.utils;

import academy.softserve.edu.tests.administrator.SwitchTabsTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.io.IOException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestListener extends TestListenerAdapter {

    @Override
    public void onTestFailure(final ITestResult result) {

        final Object currentClass = result
                .getInstance();

        final WebDriver driver = ((/*TestRunner*/SwitchTabsTest) currentClass)
                .getDriver();

        final Date currentDate = new Date();
        final Format formatter = new SimpleDateFormat("dd.MM.yyyy_HH-mm - ");

        final File screenShotFile = ((TakesScreenshot) driver)
                .getScreenshotAs(OutputType.FILE);

        try {

            FileUtils.copyFile(screenShotFile, new File("test-output//html//screenshots//"
                    + formatter.format(currentDate) + result.getName() + ".png"));
            Logger.logFail("<a target='_top' href='" + "screenshots/"
                    + formatter.format(currentDate) + result.getName()
                    + ".png'><b><font size='2' color='orange'> Screenshot</font></b></a>");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

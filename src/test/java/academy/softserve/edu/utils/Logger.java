package academy.softserve.edu.utils;

import org.testng.Reporter;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class Logger {

    private Logger() {

    }

    private final static Date currentLogDate = new Date();
    private final static Format logFormatter = new SimpleDateFormat("HH:mm:ss - ");

    public static void logInfo(final String value) {
        Reporter.log("<p>" + logFormatter.format(currentLogDate)
                + "<b> <font size='1' color='blue'>" + "INFO" + "</font></b>" + " - " + value + "</p>");
    }

    public static void logPass(final String value) {
        Reporter.log("<p>" + logFormatter.format(currentLogDate)
                + "<b> <font size='1' color='green'>" + "PASS" + "</font></b>" + " - " + value + "</p>");
    }

    public static void logFail(final String value) {
        Reporter.log("<p>" + logFormatter.format(currentLogDate)
                + "<b> <font size='1' color='red'>" + "FAIL" + "</font></b>" + " - " + value + "</p>");
    }
}

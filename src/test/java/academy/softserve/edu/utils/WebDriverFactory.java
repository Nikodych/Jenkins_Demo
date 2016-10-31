package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Browsers;
import lombok.Getter;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
//TODO improve System Property configuration
public class WebDriverFactory {

    @Getter
    private WebDriver driver;

    void setDriver(final String browser, final String version) throws MalformedURLException {

        final DesiredCapabilities capabilities = new DesiredCapabilities();

        final String remote = PropertiesReader.getDefaultProperty("remote");
        final String propertyBrowser = PropertiesReader.getDefaultProperty("browser");
        final String platform = PropertiesReader.getDefaultProperty("platform");

        final String webDriverChrome = PropertiesReader.getDefaultProperty("webdriver.chrome");
        final String webDriverIe = PropertiesReader.getDefaultProperty("webdriver.ie");

        final String pathWebDriverChromeMac = PropertiesReader.getDefaultProperty("path.webdriver.chrome.mac");
        final String pathWebDriverChromeWin = PropertiesReader.getDefaultProperty("path.webdriver.chrome.win");
        final String pathWebDriverIe = PropertiesReader.getDefaultProperty("path.webdriver.ie");

        final String remoteWebDriverUrl = PropertiesReader.getDefaultProperty("remote.webdriver.url");

        final Browsers propertyBrowserTypeEnum = Browsers.valueOf(propertyBrowser.toUpperCase());

        final Browsers cmdBrowserTypeEnum = Browsers.valueOf(browser.toUpperCase());

        final boolean isRemote = Boolean.valueOf(remote);

        if (!isRemote) {

            if ("default".equals(browser)) {

                switch (propertyBrowserTypeEnum) {

                    case CHROME_MAC:
                        System.setProperty(webDriverChrome, pathWebDriverChromeMac);
                        driver = new ChromeDriver();
                        break;

                    case CHROME:
                        System.setProperty(webDriverChrome, pathWebDriverChromeWin);
                        driver = new ChromeDriver();
                        break;

                    case EXPLORER:
                        System.setProperty(webDriverIe, pathWebDriverIe);
                        driver = new InternetExplorerDriver();
                        break;

                    case FIREFOX:
                    default:
                        driver = new FirefoxDriver();
                        break;
                }
            } else {

                switch (cmdBrowserTypeEnum) {
                    case CHROME_MAC:
                        System.setProperty(webDriverChrome, pathWebDriverChromeMac);
                        driver = new ChromeDriver();
                        break;

                    case CHROME:
                        System.setProperty(webDriverChrome, pathWebDriverChromeWin);
                        driver = new ChromeDriver();
                        break;

                    case EXPLORER:
                        System.setProperty(webDriverIe, pathWebDriverIe);
                        driver = new InternetExplorerDriver();
                        break;

                    case FIREFOX:
                    default:
                        driver = new FirefoxDriver();
                        break;
                }
            }
        } else {

            capabilities
                    .setPlatform(Platform.valueOf(platform.toUpperCase()));

            capabilities
                    .setBrowserName(String.valueOf(browser));

            capabilities
                    .setVersion(version);

            driver = new RemoteWebDriver(new URL(remoteWebDriverUrl), capabilities);
        }

    }
}

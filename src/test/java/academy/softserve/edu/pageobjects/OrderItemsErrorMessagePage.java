package academy.softserve.edu.pageobjects;

import academy.softserve.edu.elements.wrappers.Element;
import academy.softserve.edu.elements.wrappers.TextLabel;
import lombok.Getter;
import org.openqa.selenium.WebDriver;

import static academy.softserve.edu.elements.locators.customer.OrderItemsErrorMessageLocators.CONTENT_TEXT;
import static academy.softserve.edu.elements.locators.customer.OrderItemsErrorMessageLocators.ORDER_ITEMS_ERROR_MESSAGE_TEXT;

@Getter
public class OrderItemsErrorMessagePage extends PageObject<OrderItemsErrorMessagePage> {

    public OrderItemsErrorMessagePage(WebDriver driver) {
        super(driver);
    }

    /**
     * orderItemsErrorMessageText is an unique element on the OrderItemsErrorMessagePage,
     * can be used as identification of page;
     */
    private final Element orderItemsErrorMessageText = new Element(driver, ORDER_ITEMS_ERROR_MESSAGE_TEXT);

    private final TextLabel contentText = new TextLabel(driver, CONTENT_TEXT);
}

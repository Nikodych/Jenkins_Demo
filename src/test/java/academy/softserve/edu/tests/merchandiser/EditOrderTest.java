package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.*;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;

public class EditOrderTest extends TestRunner {

    private boolean isChangedToStandardValues;
    private int testOrderId;
    private int testProduct;
    private int testOrderItem;

    @BeforeClass
    public final void createDataInDB() {

        testOrderId = DBHelper.createValidOrderInDB();
        testProduct = DBHelper.createActiveProductInDB();
        testOrderItem = DBHelper.createOrderItemInDB();
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);

        merchandiserOrderingPage = userInfoPage.goToMerchandiserOrderingPage()
                .showItems();
    }

    @Test
    public final void testEditFieldsChangingCorrectly() {

        merchandiserEditOrderPage =
                merchandiserOrderingPage.editOrder(merchandiserOrderingPage.getOrderLinkByNumber(8));

        merchandiserEditOrderPage.changeOrderStatusTo("Ordered")
                .chooseValidDeliveryDate()
                .saveOrder();

        assertThat(merchandiserOrderingPage.getOrderStatusByNumber(8))
                .textEquals("Ordered");

        isChangedToStandardValues = true;
    }

    @Test
    public final void testShowItemsChanging() {

        merchandiserEditOrderPage =
                merchandiserOrderingPage.editOrder(merchandiserOrderingPage.getOrderLinkByNumber(8));

        assertThat(merchandiserEditOrderPage.getShowItems())
                .isDisplayed();

        assertThat(merchandiserEditOrderPage.getShowItems())
                .isEnabled();

        assertThat(merchandiserEditOrderPage.getShowItems())
                .textEquals("Show 10 items");

        merchandiserEditOrderPage.showItems();

        assertThat(merchandiserEditOrderPage.getShowItems())
                .isDisplayed();

        assertThat(merchandiserEditOrderPage.getShowItems())
                .isEnabled();

        assertThat(merchandiserEditOrderPage.getShowItems())
                .textEquals("Show 5 items");

        isChangedToStandardValues = false;
    }

    @AfterMethod
    public final void changeToStandardValues() {

        if (isChangedToStandardValues) {

            merchandiserEditOrderPage =
                    merchandiserOrderingPage.editOrder(merchandiserOrderingPage.getOrderLinkByNumber(8));

            merchandiserEditOrderPage.changeOrderStatusTo("Created")
                    .saveOrder();
        }
    }

    @AfterClass
    public final void deleteTestOrder() {

        DBHandler.deleteOrderById(testOrderId);
        DBHandler.deleteProduct(testProduct);
        DBHandler.deleteOrderItemById(testOrderItem);
    }
}

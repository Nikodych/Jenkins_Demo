package academy.softserve.edu.tests.merchandiser;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.merchandiser_ordering_page.SearchConditions;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;
import static academy.softserve.edu.asserts.OrderAssert.assertThat;
import static academy.softserve.edu.enums.merchandiser_ordering_page.SearchConditions.ORDER_NAME;

public class DeleteOrderTest extends TestRunner {

    private Order testOrder;
    private int testOrderId;
    private int testOrderItem;

    @BeforeMethod
    public final void setUpTests() {

        testOrderId = DBHelper.createValidOrderInDB();
        testOrder = DBHandler.getOrderById(testOrderId);
        testOrderItem = DBHelper.createOrderItemInDB();
        userInfoPage = logInPage.logInAs(Roles.MERCHANDISER);
        merchandiserOrderingPage = userInfoPage.goToMerchandiserOrderingPage();
    }

    @Test
    public final void testOrdersElementsPresence() {

        // checks if there is valid order name and if delete order button is displayed
        merchandiserOrderingPage.searchForOrder(ORDER_NAME, testOrder.getOrderName());

        assertThat(merchandiserOrderingPage.getOrderNameByCellId(2))
                .textEquals(testOrder.getOrderName());

        assertThat(merchandiserOrderingPage.getDeleteCellLink())
                .isDisplayed();
    }

    @Test
    public final void testDeleteOrderAndConfirm() {

        merchandiserOrderingPage.searchForOrder(ORDER_NAME, testOrder.getOrderName())
                .deleteFirstOrder()
                .acceptAlert();

        merchandiserOrderingPage.refreshPage();

        assertThat(DBHandler.getOrderByNumber(testOrder.getOrderNumber()))
                .isNull();
    }


    @Test
    public final void testDeleteOrderAndCancelConfirmation() {

        merchandiserOrderingPage.searchForOrder(ORDER_NAME, testOrder.getOrderName())
                .deleteFirstOrder()
                .dismissAlert();

        assertThat(DBHandler.getOrderByNumber(testOrder.getOrderNumber()))
                .orderNumberEquals(testOrder.getOrderNumber());
    }

    @AfterMethod
    public final void deleteTestOrder() {
        DBHandler.deleteOrderById(testOrderId);
        DBHandler.deleteOrderItemById(testOrderItem);
    }
}

package academy.softserve.edu.tests.customer;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.AbstractElementAssert.assertThat;

public class AddItemToOrderTest extends TestRunner {

    private Product testProduct;
    private int testProductId;

    @BeforeClass
    public final void createTestProduct() {

        testProductId = DBHelper.createActiveProductInDB();
        testProduct = DBHandler.getProductById(testProductId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.CUSTOMER);
        customerOrderingPage = userInfoPage.goToCustomerOrderingPage();
        createNewOrderPage = customerOrderingPage.goToCreateNewOrderPage();
    }

    @Test
    public final void testElementsVisibility() {

        assertThat(createNewOrderPage.getCVV2Text())
                .isDisplayed();

        assertThat(createNewOrderPage.getItemSelectionSection())
                .isDisplayed();

        addItemPage = createNewOrderPage.goToAddItemPage();

        assertThat(addItemPage.getResetButton())
                .isDisplayed();
    }

    @Test
    public final void testAddItemToOrderAbility() {

        addItemPage = createNewOrderPage.goToAddItemPage();

        addItemPage.selectLastAddedItem();

        final String quantityOfItem = "3";
        final String dimensionOfItem = "Box";

        addItemPage.selectItemDimension(dimensionOfItem)
                .setItemQuantity(quantityOfItem);

        assertThat(addItemPage.getItemTextField())
                .textEquals(testProduct.getProductName());

        assertThat(addItemPage.getItemPriceField())
                .textEquals(String.valueOf(testProduct.getProductPrice()));

        addItemPage.addItemToOrder();

        assertThat(createNewOrderPage.getFirstItemNumber())
                .textEquals(String.valueOf(testProduct.getId()));

        assertThat(createNewOrderPage.getFirstItemName())
                .textEquals(testProduct.getProductName());

        assertThat(createNewOrderPage.getFirstItemDescription())
                .textEquals(testProduct.getProductDescription());

        assertThat(createNewOrderPage.getFirstItemDimension())
                .textEquals(dimensionOfItem);

        assertThat(createNewOrderPage.getFirstItemPrice())
                .textEquals(String.valueOf(testProduct.getProductPrice()));

        assertThat(createNewOrderPage.getFirstItemQuantity())
                .textEquals(quantityOfItem);

        // if dimensionOfItem == "Item" - set multiplier = 1,
        // if == "Box" - set 5, if == "Package" - set 10;
        final int multiplierOfItem = 5;

        assertThat(createNewOrderPage.getFirstItemPricePerLine())
                .textEquals(String.valueOf(testProduct.getProductPrice() *
                        multiplierOfItem * Integer.parseInt(quantityOfItem)));
    }

    @AfterClass
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}

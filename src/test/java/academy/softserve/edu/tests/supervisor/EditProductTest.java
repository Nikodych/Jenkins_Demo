package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.item_management_page.SearchConditions;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.DBHelper;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;
import static academy.softserve.edu.enums.item_management_page.SearchConditions.NAME;

public class EditProductTest extends TestRunner {

    private int testProductId;
    private Product testProduct;

    @BeforeClass
    public final void createTestProduct() {

        testProductId = DBHelper.createActiveProductInDB();
        testProduct = DBHandler.getProductById(testProductId);
    }

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);

        itemManagementPage = userInfoPage.goToItemManagementPage();

        itemManagementPage.searchForProduct(NAME, testProduct.getProductName());

        editProductPage = itemManagementPage.editProductById(testProductId);
    }

    @Test
    public final void testEditProductAndClickOk() {

        assertThat(editProductPage.getProductNameInput())
                .isValueNotEmpty();

        final String testProductName = "someName";
        final String testProductDescription = "someProductDescription";
        final String testProductPrice = "100";

        testProduct.setProductName(testProductName);
        testProduct.setProductDescription(testProductDescription);
        testProduct.setProductPrice(Double.parseDouble(testProductPrice));

        editProductPage.setProductFields(testProduct)
                .editProduct();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        testProduct = DBHandler.getProductById(testProductId);

        assertThat(testProduct).nameEquals(testProductName);

        assertThat(testProduct).descriptionEquals(testProductDescription);

        assertThat(testProduct).priceEquals(testProductPrice);
    }

    @Test
    public final void testEditProductAndClickCancel() {

        assertThat(editProductPage.getProductNameInput())
                .isValueNotEmpty();

        testProduct.setProductDescription("AnotherDesc");

        editProductPage.setProductFields(testProduct)
                .cancelEditingProduct();

        assertThat(itemManagementPage.getSearchByFieldSet())
                .isDisplayed();

        assertThat(DBHandler.getProductById(testProductId))
                .nameNotEqual(testProduct.getProductDescription());
    }

    @AfterClass
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}

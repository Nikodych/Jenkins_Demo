package academy.softserve.edu.tests.supervisor;

import academy.softserve.edu.domains.Product;
import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.item_management_page.SearchConditions;
import academy.softserve.edu.utils.DBHandler;
import academy.softserve.edu.utils.TestRunner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static academy.softserve.edu.asserts.FluentAssertions.assertThat;
import static academy.softserve.edu.enums.item_management_page.SearchConditions.NAME;
import static academy.softserve.edu.repos.ProductRepo.getInvalidProduct;
import static academy.softserve.edu.repos.ProductRepo.getValidProduct;

public class AddNewProductTest extends TestRunner {

    private int testProductId;
    private Product testProduct;
    private final Product validProduct = getValidProduct();

    @BeforeMethod
    public final void setUpTests() {

        userInfoPage = logInPage.logInAs(Roles.SUPERVISOR);
        itemManagementPage = userInfoPage.goToItemManagementPage();
        addProductPage = itemManagementPage.goToAddProductPage();
    }

    @Test
    public final void testElementsVisibility() {

        assertThat(addProductPage.getProductNameInput())
                .isTextEmpty();
        assertThat(addProductPage.getProductDescriptionInput())
                .isTextEmpty();
        assertThat(addProductPage.getProductPriceInput())
                .isTextEmpty();
        assertThat(addProductPage.getOkButton())
                .isEnabled();
        assertThat(addProductPage.getCancelButton())
                .isEnabled();
    }

    @Test
    public final void testAddingProduct() {

        addProductPage.setProductFields(validProduct)
                .createProduct();

        testProduct = DBHandler.getLastProduct();
        testProductId = testProduct.getId();

        assertThat(itemManagementPage.getSearchInput())
                .isTextEmpty();

        itemManagementPage.searchForProduct(NAME, validProduct.getProductName());

        assertThat(itemManagementPage.getEditProductLinkById(testProductId))
                .isDisplayed();

        assertThat(testProduct).nameEquals(validProduct.getProductName());

        assertThat(testProduct).descriptionEquals(validProduct.getProductDescription());

        assertThat(testProduct).priceEquals(String.valueOf(validProduct.getProductPrice()));
    }

    @Test
    public final void testCancelAddingProduct() {

        addProductPage.setProductFields(validProduct)
                .cancelCreatingProduct();

        testProduct = DBHandler.getLastProduct();

        assertThat(itemManagementPage.getSearchInput())
                .isTextEmpty();

        itemManagementPage.searchForProduct(NAME, validProduct.getProductName());

        assertThat(itemManagementPage.getRecordsCountText())
                .textEquals("0");

        assertThat(testProduct).nameNotEqual(validProduct.getProductName());

        assertThat(testProduct).descriptionNotEqual(validProduct.getProductDescription());

        assertThat(testProduct).priceNotEqual(String.valueOf(validProduct.getProductPrice()));
    }

    @Test
    public final void testInvalidAttributes() {

        final String invalidLowBoundName = "PN";
        final Product invalidProduct = getInvalidProduct();

        addProductPage.createProduct();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Please enter product name!");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .isTextEmpty();
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter product price!");

        addProductPage.setProductFields(invalidProduct)
                .createProduct();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Enter value in range: 3-13");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .textEquals("Enter less then 25 letters");
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter double value!");

        invalidProduct.setProductName(invalidLowBoundName);

        addProductPage.setProductFields(invalidProduct)
                .createProduct();

        assertThat(addProductPage.getProductNameErrorText())
                .textEquals("Enter value in range: 3-13");
        assertThat(addProductPage.getProductDescriptionErrorText())
                .textEquals("Enter less then 25 letters");
        assertThat(addProductPage.getProductPriceErrorText())
                .textEquals("Please enter double value!");
    }

    @AfterMethod
    public final void deleteTestProduct() {
        DBHandler.deleteProduct(testProductId);
    }
}

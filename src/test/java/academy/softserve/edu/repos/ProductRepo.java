package academy.softserve.edu.repos;

import academy.softserve.edu.domains.Product;

public final class ProductRepo {

    private ProductRepo() {

    }

    public static Product getValidProduct() {

        return Product.newBuilder()
                .setId(0)
                .setProductActive(1)
                .setProductDescription("Original Irish Cream")
                .setProductName("Baileys")
                .setProductPrice(500.0)
                .build();
    }

    public static Product getInvalidProduct() {

        return Product.newBuilder()
                .setId(0)
                .setProductActive(1)
                .setProductDescription("InvalidProductDescription6")
                .setProductName("NewProductName")
                .setProductPrice(Double.parseDouble("12345678901234"))
                .build();
    }
}

package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.Product;

public interface ProductDao {

    int createProduct(final Product product);

    Product getLastProduct();

    Product getProductById(final int productId);

    void deleteProduct(final int productId);
}

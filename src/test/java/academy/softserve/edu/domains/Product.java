package academy.softserve.edu.domains;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class Product {

    private int id;
    private int productActive;
    private String productDescription;
    private String productName;
    private double productPrice;

    private Product() {

    }

    public static FirstIdStep newBuilder() {
        return new Builder();
    }

    public interface FirstIdStep {
        ProductActiveStep setId(final int id);
    }

    public interface ProductActiveStep {
        ProductDescriptionStep setProductActive(final int productActive);
    }

    public interface ProductDescriptionStep {
        ProductNameStep setProductDescription(final String productDescription);
    }

    public interface ProductNameStep {
        ProductPriceStep setProductName(final String productName);
    }

    public interface ProductPriceStep {
        BuildStep setProductPrice(final double productPrice);
    }

    public interface BuildStep {
        Product build();
    }

    private static class Builder implements FirstIdStep, ProductActiveStep,
            ProductDescriptionStep, ProductNameStep, ProductPriceStep,
            BuildStep {

        private int id;
        private int productActive;
        private String productDescription;
        private String productName;
        private double productPrice;

        @Override
        public final ProductActiveStep setId(final int id) {
            this.id = id;
            return this;
        }

        @Override
        public final ProductDescriptionStep setProductActive(final int productActive) {
            this.productActive = productActive;
            return this;
        }

        @Override
        public final ProductNameStep setProductDescription(final String productDescription) {
            this.productDescription = productDescription;
            return this;
        }

        @Override
        public final ProductPriceStep setProductName(final String productName) {
            this.productName = productName;
            return this;
        }

        @Override
        public final BuildStep setProductPrice(final double productPrice) {
            this.productPrice = productPrice;
            return this;
        }

        @Override
        public final Product build() {

            final Product product = new Product();

            product.setId(id);
            product.setProductActive(productActive);
            product.setProductDescription(productDescription);
            product.setProductName(productName);
            product.setProductPrice(productPrice);

            return product;
        }
    }

    @Override
    public final String toString() {

        return "Product {" +
                "ID=" + id +
                ", IsProductActive=" + productActive +
                ", ProductDescription=" + productDescription +
                ", ProductName=" + productName +
                ", ProductPrice=" + productPrice +
                "}";
    }

}

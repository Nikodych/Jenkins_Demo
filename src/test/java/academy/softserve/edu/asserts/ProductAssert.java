package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.Product;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class ProductAssert extends AbstractAssert<ProductAssert, Product> {

    ProductAssert(final Product actual) {
        super(actual, ProductAssert.class);
    }

    public static final ProductAssert assertThat(final Product actual) {
        return new ProductAssert(actual);
    }

    public final ProductAssert productEquals(final Product condition) {

        isNotNull();

        if (!condition.equals(actual)) {

            logFail("Product {" + actual + "} \n should equal \n {" + condition + "} !");
            failWithMessage("Product {%s} \n should equal \n {%s} !",
                    actual, condition);
        } else {
            logPass("Products are equal");
        }
        return this;
    }

    public final ProductAssert isInactive() {

        isNotNull();

        if (actual.getProductActive() != 0) {

            logFail("Product {" + actual + "} \n should be inactive !");
            failWithMessage("Product {%s} \n should be inactive !", actual);
        } else {
            logPass("Products is inactive");
        }
        return this;
    }

    public final ProductAssert nameEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getProductName())) {

            logFail("Product's {id=" + actual.getId() + "} name {" + actual.getProductName() +
                    "} should equal {" + condition + "} !");
            failWithMessage("Product's {id=%s} name {%s} should equal {%s} !",
                    actual.getId(), actual.getProductName(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} name equals {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert descriptionEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getProductDescription())) {

            logFail("Product's {id=" + actual.getId() + "} description {" + actual.getProductDescription() +
                    "} should equal {" + condition + "} !");
            failWithMessage("Product's {id=%s} description {%s} should equal {%s} !",
                    actual.getId(), actual.getProductDescription(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} description equals {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert priceEquals(final String condition) {

        isNotNull();

        if (Double.parseDouble(condition) != actual.getProductPrice()) {

            logFail("Product's {id=" + actual.getId() + "} price {" + actual.getProductPrice() +
                    "} should equal {" + condition + "} !");
            failWithMessage("Product's {id=%s} price {%s} should equal {%s} !",
                    actual.getId(), actual.getProductPrice(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} price equals {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert nameNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getProductName())) {

            logFail("Product's {id=" + actual.getId() + "} name {" + actual.getProductName() +
                    "} equals {" + condition + "} !");
            failWithMessage("Product's {id=%s} name {%s} equals {%s} !",
                    actual.getId(), actual.getProductName(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} name not equal {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert descriptionNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getProductDescription())) {

            logFail("Product's {id=" + actual.getId() + "} description {" + actual.getProductDescription() +
                    "} equals {" + condition + "} !");
            failWithMessage("Product's {id=%s} description {%s} equals {%s} !",
                    actual.getId(), actual.getProductDescription(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} description not equal {" + condition + "}");
        }
        return this;
    }

    public final ProductAssert priceNotEqual(final String condition) {

        isNotNull();

        if (Double.parseDouble(condition) == actual.getProductPrice()) {

            logFail("Product's {id=" + actual.getId() + "} price {" + actual.getProductPrice() +
                    "} equals {" + condition + "} !");
            failWithMessage("Product's {id=%s} price {%s} equals {%s} !",
                    actual.getId(), actual.getProductPrice(), condition);
        } else {
            logPass("Product's {id=" + actual.getId() + "} price not equal {" + condition + "}");
        }
        return this;
    }

    @Override
    public final ProductAssert isNotNull() {

        if (actual == null) {

            logFail("Required product should be not null !");
            failWithMessage("Required product should be not null !");
        }
        return this;
    }

    public final void isNull() {

        if (actual != null) {

            failWithMessage("Required product should be null !");
            logFail("Required product should be null !");
        }
    }
}

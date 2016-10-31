package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.Order;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class OrderAssert extends AbstractAssert<OrderAssert, Order> {

    OrderAssert(final Order actual) {
        super(actual, OrderAssert.class);
    }

    public static final OrderAssert assertThat(final Order actual) {
        return new OrderAssert(actual);
    }

    public final OrderAssert orderNumberEquals(final int condition) {

        isNotNull();

        if (condition != actual.getOrderNumber()) {

            logFail("Order {id=" + actual.getId() + "} numbers {" + actual.getOrderNumber() +
                    "} should equal {" + condition + "} !");
            failWithMessage("Order {id=%s} numbers {%s} should equal {%s} !",
                    actual.getId(), actual.getOrderNumber(), condition);
        } else {
            logPass("Order {id=" + actual.getId() + "} numbers equal {" + condition + "}");
        }
        return this;
    }

    public final OrderAssert statusNameEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getOrderStatusName())) {

            logFail("Order {№" + actual.getOrderNumber() + "} status {" + actual.getOrderStatusName() +
                    "} should equal {" + condition + "} !");
            failWithMessage("Order {№%s} status {%s} should equal {%s} !",
                    actual.getOrderNumber(), actual.getOrderStatusName(), condition);
        } else {
            logPass("Order {№" + actual.getOrderNumber() + "} status equals {" + condition + "}");
        }
        return this;
    }

    @Override
    public final OrderAssert isNotNull() {

        if (actual == null) {

            logFail("Required order should be not null !");
            failWithMessage("Required order should be not null !");
        }
        return this;
    }

}

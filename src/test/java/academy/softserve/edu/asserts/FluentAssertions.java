package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.domains.Product;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.elements.wrappers.AbstractElement;

public class FluentAssertions {

    public static final AbstractElementAssert assertThat(final AbstractElement actual) {
        return new AbstractElementAssert(actual);
    }

    public static final UserAssert assertThat(final User actual) {
        return new UserAssert(actual);
    }

    public static final OrderAssert assertThat(final Order actual) {
        return new OrderAssert(actual);
    }

    public static final ProductAssert assertThat(final Product actual) {
        return new ProductAssert(actual);
    }

    public static final CommonAssert assertThat(final Boolean actual) {
        return new CommonAssert(actual);
    }

}
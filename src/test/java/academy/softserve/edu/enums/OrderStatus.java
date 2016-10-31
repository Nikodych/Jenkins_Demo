package academy.softserve.edu.enums;

import java.util.Arrays;

public enum OrderStatus {

    CREATED,
    PENDING,
    ORDERED,
    DELIVERED;

    public static final String getOrderStatusNameByReference(final int orderStatus) {

        return Arrays.stream(OrderStatus.values())
                .filter(status -> (status.ordinal() + 1) == orderStatus)
                .findFirst()
                .get()
                .toString();
    }
}

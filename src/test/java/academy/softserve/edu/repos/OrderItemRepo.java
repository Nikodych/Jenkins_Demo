package academy.softserve.edu.repos;

import academy.softserve.edu.domains.OrderItem;

public final class OrderItemRepo {

    private OrderItemRepo() {

    }

    public static OrderItem getValidOrderItem() {

        return OrderItem.newBuilder()
                .setId(0)
                .setCost(7500.0)
                .setItemPrice(500.0)
                .setQuantity(3)
                .setDimensionReference(2)
                .setOrderReference(7)
                .setProductReference(6)
                .build();
    }
}

package academy.softserve.edu.repos;

import academy.softserve.edu.domains.Order;
import academy.softserve.edu.domains.Product;

public final class OrderRepo {

    private OrderRepo() {

    }

    public static Order getValidOrder() {

        return Order.newBuilder()
                .setId(0)
                .setDeliveryDate(null)
                .setGift(0)
                .setMaxDiscount(0)
                .setOrderDate("2016-11-15 23:25:00")
                .setOrderName("NewOrderName")
                .setOrderNumber(7)
                .setPreferableDeliveryDate("2016-11-14 19:10:00")
                .setTotalPrice(7500.0)
                .setAssignee(8)
                .setCustomer(13)
                .setOrderStatusReference(1)
                .build();
    }
}

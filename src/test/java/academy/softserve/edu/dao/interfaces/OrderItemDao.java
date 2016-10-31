package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.OrderItem;

public interface OrderItemDao {

    int createOrderItem(final OrderItem orderItem);

    OrderItem getLastOrderItem();

    void deleteOrderItemById(final int orderItemId);

    void deleteOrderItemByOrderRef(final int orderRef);

}


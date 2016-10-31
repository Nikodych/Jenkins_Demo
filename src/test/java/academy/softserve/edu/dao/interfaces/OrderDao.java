package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.Order;

import java.sql.SQLException;

public interface OrderDao {

    int createOrder(final Order order);

    Order getOrderById(final int orderId);

    Order getOrderByNumber(final int orderNumber) throws SQLException;

    void deleteOrderById(final int orderId);

    void deleteOrderByNumber(final int orderNumber);
}

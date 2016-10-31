package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.OrderItemDao;
import academy.softserve.edu.domains.OrderItem;
import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class MySQLOrderItemDao implements OrderItemDao {

    private static final String CREATE_ORDER_ITEM_QUERY = "INSERT INTO OrderItems (Cost," +
            " ItemPrice, Quantity, DimensionRef, OrderRef, ProductRef) VALUES (?, ?, ?, ?, ?, ?);";
    private static final String GET_LAST_ORDER_ITEM_QUERY = "SELECT ID, Cost, ItemPrice, Quantity," +
            " DimensionRef, OrderRef, ProductRef FROM OrderItems ORDER BY ID DESC LIMIT 1;";
    private static final String DELETE_ORDER_ITEM_BY_ID_QUERY = "DELETE FROM OrderItems WHERE ID = ?;" +
            " ALTER TABLE OrderItems auto_increment=0;";
    private static final String DELETE_ORDER_ITEM_BY_ORDER_REF_QUERY = "DELETE FROM OrderItems WHERE OrderRef = ?;" +
            " ALTER TABLE OrderItems auto_increment=0;";

    private final Connection connection;

    @Override
    public final int createOrderItem(final OrderItem orderItem) {

        int orderItemId = 0;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(CREATE_ORDER_ITEM_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setDouble(1, orderItem.getCost());
            preparedStatement.setDouble(2, orderItem.getItemPrice());
            preparedStatement.setInt(3, orderItem.getQuantity());
            preparedStatement.setInt(4, orderItem.getDimensionReference());
            preparedStatement.setInt(5, orderItem.getOrderReference());
            preparedStatement.setInt(6, orderItem.getProductReference());
            preparedStatement.execute();

            final ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                orderItemId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemId;
    }

    @Override
    public final OrderItem getLastOrderItem() {

        OrderItem orderItem = null;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(GET_LAST_ORDER_ITEM_QUERY)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                orderItem = OrderItem.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setCost(resultSet.getDouble("Cost"))
                        .setItemPrice(resultSet.getDouble("ItemPrice"))
                        .setQuantity(resultSet.getInt("Quantity"))
                        .setDimensionReference(resultSet.getInt("DimensionRef"))
                        .setOrderReference(resultSet.getInt("OrderRef"))
                        .setProductReference(resultSet.getInt("ProductRef"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    @Override
    public final void deleteOrderItemById(final int orderItemId) {

        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_ORDER_ITEM_BY_ID_QUERY)) {

            preparedStatement.setInt(1, orderItemId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final void deleteOrderItemByOrderRef(final int orderRef) {

        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_ORDER_ITEM_BY_ORDER_REF_QUERY)) {

            preparedStatement.setInt(1, orderRef);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package academy.softserve.edu.utils;

import academy.softserve.edu.dao.MySQLDaoFactory;
import academy.softserve.edu.dao.interfaces.*;
import academy.softserve.edu.domains.Order;
import academy.softserve.edu.domains.OrderItem;
import academy.softserve.edu.domains.Product;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;

import java.sql.Connection;
import java.sql.SQLException;

public final class DBHandler {

    private DBHandler() {

    }

    public static final int createUser(final User user) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        int userId = 0;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            userId = userDao.createUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    public static final User getUserById(final int userId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getUserById(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final User getUserByLogin(final String userLogin) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getUserByLogin(userLogin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final User getUserByRole(final Roles role) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getUserByRole(role);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final User getLastUser() {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;
        User user = null;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            user = userDao.getLastUser();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static final void deleteUser(final int userId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final UserDao userDao;

        try (final Connection connection = daoFactory.getConnection()) {
            userDao = daoFactory.getUserDao(connection);
            userDao.deleteUser(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final int createProduct(final Product product) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final ProductDao productDao;
        int productId = 0;

        try (final Connection connection = daoFactory.getConnection()) {
            productDao = daoFactory.getProductDao(connection);
            productId = productDao.createProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productId;
    }

    public static final Product getLastProduct() {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final ProductDao productDao;
        Product product = null;

        try (final Connection connection = daoFactory.getConnection()) {
            productDao = daoFactory.getProductDao(connection);
            product = productDao.getLastProduct();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static final Product getProductById(final int productId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final ProductDao productDao;
        Product product = null;

        try (final Connection connection = daoFactory.getConnection()) {
            productDao = daoFactory.getProductDao(connection);
            product = productDao.getProductById(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }

    public static final void deleteProduct(final int productId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final ProductDao productDao;

        try (final Connection connection = daoFactory.getConnection()) {
            productDao = daoFactory.getProductDao(connection);
            productDao.deleteProduct(productId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final int createOrder(final Order order) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderDao orderDao;
        int orderId = 0;

        try (final Connection connection = daoFactory.getConnection()) {
            orderDao = daoFactory.getOrderDao(connection);
            orderId = orderDao.createOrder(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }

    public static final Order getOrderById(final int orderId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderDao orderDao;
        Order order = null;

        try (final Connection connection = daoFactory.getConnection()) {
            orderDao = daoFactory.getOrderDao(connection);
            order = orderDao.getOrderById(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static final Order getOrderByNumber(final int orderNumber) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderDao orderDao;
        Order order = null;

        try (final Connection connection = daoFactory.getConnection()) {
            orderDao = daoFactory.getOrderDao(connection);
            order = orderDao.getOrderByNumber(orderNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return order;
    }

    public static final void deleteOrderById(final int orderId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderDao orderDao;

        try (final Connection connection = daoFactory.getConnection()) {
            orderDao = daoFactory.getOrderDao(connection);
            orderDao.deleteOrderById(orderId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final void deleteOrderByNumber(final int orderNumber) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderDao orderDao;

        try (final Connection connection = daoFactory.getConnection()) {
            orderDao = daoFactory.getOrderDao(connection);
            orderDao.deleteOrderByNumber(orderNumber);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final int createOrderItem(final OrderItem orderItem) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderItemDao orderItemDao;
        int orderItemId = 0;

        try (final Connection connection = daoFactory.getConnection()) {
            orderItemDao = daoFactory.getOrderItemDao(connection);
            orderItemId = orderItemDao.createOrderItem(orderItem);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItemId;
    }

    public static final OrderItem getLastOrderItem() {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderItemDao orderItemDao;
        OrderItem orderItem = null;

        try (final Connection connection = daoFactory.getConnection()) {
            orderItemDao = daoFactory.getOrderItemDao(connection);
            orderItem = orderItemDao.getLastOrderItem();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderItem;
    }

    public static final void deleteOrderItemById(final int orderItemId) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderItemDao orderItemDao;

        try (final Connection connection = daoFactory.getConnection()) {
            orderItemDao = daoFactory.getOrderItemDao(connection);
            orderItemDao.deleteOrderItemById(orderItemId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static final void deleteOrderItemByOrderRef(final int orderRef) {

        final DaoFactory daoFactory = new MySQLDaoFactory();
        final OrderItemDao orderItemDao;

        try (final Connection connection = daoFactory.getConnection()) {
            orderItemDao = daoFactory.getOrderItemDao(connection);
            orderItemDao.deleteOrderItemByOrderRef(orderRef);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.*;
import academy.softserve.edu.utils.PropertiesReader;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLDaoFactory implements DaoFactory {

    private final String username = PropertiesReader.getDefaultProperty("oms.username");
    private final String password = PropertiesReader.getDefaultProperty("oms.password");
    private final String omsDbUrl = PropertiesReader.getDefaultProperty("oms.db.url");

    public MySQLDaoFactory() {

        try {
            final Driver driver = new com.mysql.jdbc.Driver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public final Connection getConnection() throws SQLException {
        return DriverManager.getConnection(omsDbUrl, username, password);
    }

    @Override
    public final UserDao getUserDao(final Connection connection) {
        return new MySQLUserDao(connection);
    }

    @Override
    public final ProductDao getProductDao(final Connection connection) {
        return new MySQLProductDao(connection);
    }

    @Override
    public final OrderDao getOrderDao(final Connection connection) {
        return new MySQLOrderDao(connection);
    }

    @Override
    public final OrderItemDao getOrderItemDao(final Connection connection) {
        return new MySQLOrderItemDao(connection);
    }

}

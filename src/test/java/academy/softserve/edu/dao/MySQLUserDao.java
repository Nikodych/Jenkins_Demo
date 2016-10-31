package academy.softserve.edu.dao;

import academy.softserve.edu.dao.interfaces.UserDao;
import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;
import lombok.RequiredArgsConstructor;

import java.sql.*;

@RequiredArgsConstructor
public class MySQLUserDao implements UserDao {

    private static final String GET_USER_BY_ID_QUERY = "SELECT ID, IsUserActive, Balance, Email," +
            " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef FROM Users WHERE ID = ?;";
    private static final String GET_USER_BY_ROLE_QUERY = "SELECT ID, IsUserActive, Balance, Email," +
            " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef FROM Users WHERE RoleRef = ? LIMIT 1;";
    private static final String GET_LAST_USER_QUERY = "SELECT ID, IsUserActive, Balance, Email," +
            " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef FROM Users ORDER BY ID DESC LIMIT 1;";
    private static final String CREATE_USER_QUERY = "INSERT INTO Users (IsUserActive, Balance, Email," +
            " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef) VALUES(?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?,  ?); ";
    private static final String DELETE_USER_QUERY = "DELETE FROM Users WHERE ID = ?;" +
            " ALTER TABLE Users auto_increment=0;";
    private static final String GET_USER_BY_LOGIN_QUERY = "SELECT ID, IsUserActive, Balance, Email," +
            " FirstName, LastName, Login, Password, CustomerTypeRef, RegionRef," +
            " RoleRef FROM Users WHERE Login = ?;";

    private final Connection connection;

    @Override
    public final int createUser(final User user) {

        int userId = 0;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, user.getUserActive());
            preparedStatement.setInt(2, user.getBalance());
            preparedStatement.setString(3, user.getEmail());
            preparedStatement.setString(4, user.getFirstName());
            preparedStatement.setString(5, user.getLastName());
            preparedStatement.setString(6, user.getLogin());
            preparedStatement.setString(7, user.getPassword());
            preparedStatement.setInt(8, user.getCustomerTypeReference());
            preparedStatement.setInt(9, user.getRegionReference());
            preparedStatement.setInt(10, user.getRoleReference());
            preparedStatement.execute();

            final ResultSet resultSet = preparedStatement.getGeneratedKeys();

            while (resultSet.next()) {
                userId = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userId;
    }

    @Override
    public final User getUserById(final int userId) {

        User user = null;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(GET_USER_BY_ID_QUERY)) {

            preparedStatement.setInt(1, userId);

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                user = User.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setUserActive(resultSet.getInt("IsUserActive"))
                        .setBalance(resultSet.getInt("Balance"))
                        .setEmail(resultSet.getString("Email"))
                        .setFirstName(resultSet.getString("FirstName"))
                        .setLastName(resultSet.getString("LastName"))
                        .setLogin(resultSet.getString("Login"))
                        .setPassword(resultSet.getString("Password"))
                        .setCustomerTypeReference(resultSet.getInt("CustomerTypeRef"))
                        .setRegionReference(resultSet.getInt("RegionRef"))
                        .setRoleReference(resultSet.getInt("RoleRef"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public final User getUserByLogin(final String userLogin) {

        User user = null;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(GET_USER_BY_LOGIN_QUERY)) {

            preparedStatement.setString(1, userLogin);

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                user = User.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setUserActive(resultSet.getInt("IsUserActive"))
                        .setBalance(resultSet.getInt("Balance"))
                        .setEmail(resultSet.getString("Email"))
                        .setFirstName(resultSet.getString("FirstName"))
                        .setLastName(resultSet.getString("LastName"))
                        .setLogin(resultSet.getString("Login"))
                        .setPassword(resultSet.getString("Password"))
                        .setCustomerTypeReference(resultSet.getInt("CustomerTypeRef"))
                        .setRegionReference(resultSet.getInt("RegionRef"))
                        .setRoleReference(resultSet.getInt("RoleRef"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public final User getUserByRole(final Roles role) {

        User user = null;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(GET_USER_BY_ROLE_QUERY)) {

            preparedStatement.setInt(1, (role.ordinal() + 1));

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                user = User.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setUserActive(resultSet.getInt("IsUserActive"))
                        .setBalance(resultSet.getInt("Balance"))
                        .setEmail(resultSet.getString("Email"))
                        .setFirstName(resultSet.getString("FirstName"))
                        .setLastName(resultSet.getString("LastName"))
                        .setLogin(resultSet.getString("Login"))
                        .setPassword(resultSet.getString("Password"))
                        .setCustomerTypeReference(resultSet.getInt("CustomerTypeRef"))
                        .setRegionReference(resultSet.getInt("RegionRef"))
                        .setRoleReference(resultSet.getInt("RoleRef"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public final User getLastUser() {

        User user = null;
        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(GET_LAST_USER_QUERY)) {

            final ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                user = User.newBuilder()
                        .setId(resultSet.getInt("ID"))
                        .setUserActive(resultSet.getInt("IsUserActive"))
                        .setBalance(resultSet.getInt("Balance"))
                        .setEmail(resultSet.getString("Email"))
                        .setFirstName(resultSet.getString("FirstName"))
                        .setLastName(resultSet.getString("LastName"))
                        .setLogin(resultSet.getString("Login"))
                        .setPassword(resultSet.getString("Password"))
                        .setCustomerTypeReference(resultSet.getInt("CustomerTypeRef"))
                        .setRegionReference(resultSet.getInt("RegionRef"))
                        .setRoleReference(resultSet.getInt("RoleRef"))
                        .build();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public final void deleteUser(final int userId) {

        try (final PreparedStatement preparedStatement =
                     connection.prepareStatement(DELETE_USER_QUERY)) {

            preparedStatement.setInt(1, userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

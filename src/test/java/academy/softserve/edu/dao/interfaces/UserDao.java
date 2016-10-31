package academy.softserve.edu.dao.interfaces;

import academy.softserve.edu.domains.User;
import academy.softserve.edu.enums.Roles;

public interface UserDao {

    int createUser(final User user);

    User getUserById(final int userId);

    User getUserByLogin(final String userLogin);

    User getUserByRole(final Roles role);

    User getLastUser();

    void deleteUser(final int userId);

}

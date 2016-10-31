package academy.softserve.edu.enums;

import java.util.Arrays;

public enum Roles {

    ADMINISTRATOR,
    MERCHANDISER,
    SUPERVISOR,
    CUSTOMER,
    INVALID_USER;

    public static final String getRoleNameByReference(final int roleReference) {

        return Arrays.stream(Roles.values())
                .filter(roles -> (roles.ordinal() + 1) == roleReference)
                .findFirst()
                .get()
                .toString();
    }
}

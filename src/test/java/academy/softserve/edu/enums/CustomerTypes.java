package academy.softserve.edu.enums;

import java.util.Arrays;

public enum CustomerTypes {

    STANDART,
    SILVER,
    GOLD,
    PLATINUM;

    public static final String getCustomerTypeNameByReference(final int customerTypeReference) {

        return Arrays.stream(CustomerTypes.values())
                .filter(customerTypes -> (customerTypes.ordinal() + 1) == customerTypeReference)
                .findFirst()
                .get()
                .toString();
    }
}

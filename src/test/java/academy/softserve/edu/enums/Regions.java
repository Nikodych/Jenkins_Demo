package academy.softserve.edu.enums;

import java.util.Arrays;

public enum Regions {

    NORTH,
    EAST,
    SOUTH,
    WEST;

    public static final String getRegionNameByReference(final int regionReference) {

        return Arrays.stream(Regions.values())
                .filter(regions -> (regions.ordinal() + 1) == regionReference)
                .findFirst()
                .get()
                .toString();
    }
}

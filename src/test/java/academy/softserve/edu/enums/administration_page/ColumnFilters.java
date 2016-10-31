package academy.softserve.edu.enums.administration_page;

public enum ColumnFilters {

    ALL_COLUMNS,
    FIRST_NAME,
    LAST_NAME,
    LOGIN,
    ROLE,
    REGION;

    @Override
    public final String toString() {
        return super.toString().replace('_', ' ');
    }
}

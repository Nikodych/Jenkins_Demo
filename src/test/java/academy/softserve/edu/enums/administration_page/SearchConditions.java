package academy.softserve.edu.enums.administration_page;

public enum SearchConditions {

    EQUALS,
    NOT_EQUALS_TO,
    STARTS_WITH,
    CONTAINS,
    DOES_NOT_CONTAIN;

    @Override
    public final String toString() {
        return super.toString().replace('_', ' ');
    }
}

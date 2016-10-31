package academy.softserve.edu.enums.merchandiser_ordering_page;

public enum SearchConditions {

    ORDER_NAME,
    STATUS;

    @Override
    public final String toString() {
        return super.toString().replace('_', ' ');
    }
}

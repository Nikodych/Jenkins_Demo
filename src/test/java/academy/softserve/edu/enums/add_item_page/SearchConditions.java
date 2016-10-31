package academy.softserve.edu.enums.add_item_page;

public enum SearchConditions {

    ITEM_NAME,
    ITEM_DESCRIPTION;

    @Override
    public final String toString() {
        return super.toString().replace('_', ' ');
    }

}

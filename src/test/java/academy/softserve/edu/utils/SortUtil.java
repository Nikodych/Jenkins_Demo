package academy.softserve.edu.utils;

import com.google.common.collect.Ordering;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public final class SortUtil {

    private SortUtil() {

    }

    public static final boolean isListSortedByAsc(final List<WebElement> elementsList) {

        final List<String> gridsColumnValues = elementsList.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());

        return Ordering.natural()
                .isOrdered(gridsColumnValues);
    }

    //TODO re-consider
    //Pull Double to List from list of elements.
    public final static boolean isListDoubleSortedByDescend(final List<WebElement> elementsList) {

        final List<Double> gridsColumnDoubleValues = elementsList.stream()
                .map(WebElement::getText).map(Double::parseDouble)
                .collect(Collectors.toList());

        return Ordering.natural()
                .reverse()
                .isOrdered(gridsColumnDoubleValues);
    }

    public final static boolean isListDoubleSortedByAscent(final List<WebElement> elementsList) {

        final List<Double> gridsColumnDoubleValues = elementsList.stream()
                .map(WebElement::getText)
                .map(Double::parseDouble)
                .collect(Collectors.toList());

        return Ordering.natural()
                .isOrdered(gridsColumnDoubleValues);
    }
}


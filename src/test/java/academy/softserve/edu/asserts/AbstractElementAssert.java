package academy.softserve.edu.asserts;

import academy.softserve.edu.elements.wrappers.AbstractElement;
import org.assertj.core.api.AbstractAssert;
import org.openqa.selenium.support.ui.Select;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class AbstractElementAssert extends AbstractAssert<AbstractElementAssert, AbstractElement> {

    AbstractElementAssert(final AbstractElement actual) {
        super(actual, AbstractElementAssert.class);
    }

    public static final AbstractElementAssert assertThat(final AbstractElement actual) {
        return new AbstractElementAssert(actual);
    }

    public final AbstractElementAssert isDisplayed() {

        isNotNull();

        if (!actual.isDisplayed()) {

            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be displayed !");
            failWithMessage("Element {%s} with locator {%s} should be displayed !",
                    actual.getLocatorName(), actual.getLocatorValue());
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is displayed");
        }
        return this;
    }

    public final AbstractElementAssert textContains(final String condition) {

        isNotNull();

        if (!actual.getText()
                .contains(condition)) {

            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should contain {" +
                    condition + "} !");
            failWithMessage("Element's {%s} text {%s} with locator {%s} should contain {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text contains {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert textEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getText())) {

            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should equal {"
                    + condition + "} !");
            failWithMessage("Element's {%s} text {%s} with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text equals {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert textNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getText())) {

            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should not equal {" +
                    condition + "} !");
            failWithMessage("Element's {%s} text {%s} with locator {%s} should not equal {%s} !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text does not equal {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert valueEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getValue())) {

            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue() +
                    "} with locator {" + actual.getLocatorValue() + "} should equal {" + condition + "} !");
            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' equals {" + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert valueNotEqual(final String condition) {

        isNotNull();

        if (condition.equals(actual.getValue())) {

            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue() +
                    "} with locator {" + actual.getLocatorValue() + "} should not equal {" + condition + "} !");
            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should not equal {%s} !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' does not equal {"
                    + condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert isValueEmpty() {

        isNotNull();

        if (!actual.getValue()
                .isEmpty()) {

            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' {" + actual.getValue()
                    + "} with locator {" + actual.getLocatorValue() + "} should be empty !");
            failWithMessage("Element's {%s} attribute 'value' {%s} with locator {%s} should be empty !",
                    actual.getLocatorName(), actual.getValue(), actual.getLocatorValue());
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' is empty");
        }
        return this;
    }

    public final AbstractElementAssert isValueNotEmpty() {

        isNotNull();

        if (actual.getValue()
                .isEmpty()) {

            logFail("Element's {" + actual.getLocatorName() + "} attribute 'value' with locator {" +
                    actual.getLocatorValue() + "} should not be empty !");
            failWithMessage("Element's {%s} attribute 'value' with locator {%s} should not be empty !",
                    actual.getLocatorName(), actual.getLocatorValue());
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} attribute 'value' is not empty");
        }
        return this;
    }

    public final AbstractElementAssert isTextBold() {

        isNotNull();

        if (!"700".equals(actual.getElement()
                .getCssValue("font-weight"))) {

            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should be bold !");
            failWithMessage("Element's {%s} text {%s} with locator {%s} should be bold !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue());
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is bold");
        }
        return this;
    }

    public final AbstractElementAssert isTextEmpty() {

        isNotNull();

        if (!actual.getText()
                .isEmpty()) {

            logFail("Element's {" + actual.getLocatorName() + "} text {" + actual.getText() +
                    "} with locator {" + actual.getLocatorValue() + "} should be empty !");
            failWithMessage("Element's {%s} text {%s} with locator {%s} should be empty !",
                    actual.getLocatorName(), actual.getText(), actual.getLocatorValue());
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is empty");
        }
        return this;
    }

    public final AbstractElementAssert isTextNotEmpty() {

        isNotNull();

        if (actual.getText()
                .isEmpty()) {

            logFail("Element's {" + actual.getLocatorName() + "} text with locator {" +
                    actual.getLocatorValue() + "} should not be empty !");
            failWithMessage("Element's {%s} text with locator {%s} should not be empty !",
                    actual.getLocatorName(), actual.getLocatorValue());
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} text is not empty");
        }
        return this;
    }

    public final AbstractElementAssert isEnabled() {

        isNotNull();

        if (!actual.isEnabled()) {

            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be enabled !");
            failWithMessage("Element {%s} with locator {%s} should be enabled !",
                    actual.getLocatorName(), actual.getLocatorValue());
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is enabled");
        }
        return this;
    }

    public final AbstractElementAssert isDisabled() {

        isNotNull();

        if (actual.isEnabled()) {

            logFail("Element {" + actual.getLocatorName() + "} with locator {" +
                    actual.getLocatorValue() + "} should be disabled !");
            failWithMessage("Element {%s} with locator {%s} should be disabled !",
                    actual.getLocatorName(), actual.getLocatorValue());
        } else {
            logPass("Element {" + actual.getLocatorName() + "} is disabled");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropdownEquals(final String condition) {

        isNotNull();

        if (!condition.equals(new Select(actual.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            logFail("Element's {" + actual.getLocatorName() + "} selected dropdown value with locator {" +
                    actual.getLocatorValue() + "} should equal {" + condition + "} !");
            failWithMessage("Element's {%s} selected dropdown value with locator {%s} should equal {%s} !",
                    actual.getLocatorName(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} selected dropdown value equals {" +
                    condition + "}");
        }
        return this;
    }

    public final AbstractElementAssert selectedDropdownEqualsIgnoreCase(final String condition) {

        isNotNull();

        if (!condition.equalsIgnoreCase(new Select(actual.getElement())
                        .getFirstSelectedOption()
                        .getText())) {

            logFail("Element's {" + actual.getLocatorName() + "} selected dropdown value with locator {" +
                    actual.getLocatorValue() + "} should equal {" + condition + "} (case is ignored)!");
            failWithMessage("Element's {%s} selected dropdown value with locator {%s} should equal {%s}" +
                    " (case is ignored)!", actual.getLocatorName(), actual.getLocatorValue(), condition);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} selected dropdown value equals {" +
                    condition + "} (case is ignored)");
        }
        return this;
    }

    public final AbstractElementAssert isQuantityMoreThan(final int quantity) {

        if (actual.getElements()
                .size() <= quantity) {

            logFail("Element's {" + actual.getLocatorName() + "} quantity should be more than {"
                    + quantity + "}");
            failWithMessage("Element's {%s} quantity should be more, than {%s} ",
                    actual.getLocatorName(), quantity);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} quantity more than {" + quantity + "}");
        }
        return this;
    }

    public final AbstractElementAssert isQuantityLessOrEqualsThan(final int quantity) {

        if (actual.getElements()
                .size() > quantity) {

            logFail("Element's {" + actual.getLocatorName() + "} quantity should be less or equals" +
                    " than {" + quantity + "}");
            failWithMessage("Element's {%s} quantity should be less or equals, than {%s} ",
                    actual.getLocatorName(), quantity);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} quantity less or equals" +
                    " than {" + quantity + "}");
        }
        return this;
    }

    public final AbstractElementAssert isQuantityEqualTo(final int quantity) {

        if (actual.getElements()
                .size() != quantity) {

            logFail("Element's {" + actual.getLocatorName() + "} quantity should be equal {"
                    + quantity + "}");
            failWithMessage("Element's {%s} quantity should be equal {%s} ",
                    actual.getLocatorName(), quantity);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} quantity equal {" + quantity + "}");

        }
        return this;
    }


    public final AbstractElementAssert isParseIntQuantityEqualTo(final int quantity) {

        if (Integer.parseInt(actual.getText()) != quantity) {

            logFail("Element's {" + actual.getLocatorName() + "} quantity should be equal {" +
                    quantity + "}");
            failWithMessage("Element's {%s} quantity should be equal {%s} ",
                    actual.getLocatorName(), quantity);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} quantity equal {" + quantity + "}");
        }
        return this;
    }

    public final AbstractElementAssert isParseIntQuantityMoreThan(final int quantity) {

        if (Integer.parseInt(actual.getText()) <= quantity) {

            logFail("Element's {" + actual.getLocatorName() + "} quantity should be more, than {" +
                    quantity + "}");
            failWithMessage("Element's {%s} quantity should be more, than {%s} ",
                    actual.getLocatorName(), quantity);
        } else {
            logPass("Element's {" + actual.getLocatorName() + "} quantity more, than {" + quantity + "}");
        }
        return this;
    }


    @Override
    public final AbstractElementAssert isNotNull() {

        if (actual == null) {

            logFail("Element should be not null");
            failWithMessage("Element should be not null");
        }
        return this;
    }

}

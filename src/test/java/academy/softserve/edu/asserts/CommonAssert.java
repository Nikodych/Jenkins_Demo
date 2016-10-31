package academy.softserve.edu.asserts;

import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class CommonAssert extends AbstractAssert<CommonAssert, Boolean> {

    CommonAssert(final Boolean actual) {
        super(actual, CommonAssert.class);

    }

    public static final CommonAssert assertThat(final Boolean actual) {
        return new CommonAssert(actual);
    }

    public final CommonAssert isTrue() {

        if (!actual) {

            logFail("Expected True, but in fact False! ");
            failWithMessage("Expected True, but in fact False!");
        } else {
            logPass("True");
        }
        return this;
    }

}




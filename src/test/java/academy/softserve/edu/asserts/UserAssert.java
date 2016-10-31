package academy.softserve.edu.asserts;

import academy.softserve.edu.domains.User;
import org.assertj.core.api.AbstractAssert;

import static academy.softserve.edu.utils.Logger.logFail;
import static academy.softserve.edu.utils.Logger.logPass;

public class UserAssert extends AbstractAssert<UserAssert, User> {

    UserAssert(final User actual) {
        super(actual, UserAssert.class);
    }

    public static final UserAssert assertThat(final User actual) {
        return new UserAssert(actual);
    }

    public final UserAssert userEquals(final User condition) {

        isNotNull();

        if (!condition.equals(actual)) {

            logFail("User {" + actual + "} \n should equal \n {" + condition + "} !");
            failWithMessage("User {%s} \n should equal \n {%s} !",
                    actual, condition);
        } else {
            logPass("Users are equal");
        }
        return this;
    }

    public final UserAssert lastNameEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getLastName())) {

            logFail("User's {id=" + actual.getId() + "} Last name {" + actual.getLastName() +
                    "} should equal {" + condition + "} !");
            failWithMessage("User's {id=%s} Last name {%s} should equal {%s} !",
                    actual.getId(), actual.getLastName(), condition);
        } else {
            logPass("User's {id=" + actual.getId() + "} Last name equals {" + condition + "}");
        }
        return this;
    }

    public final UserAssert passwordEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getPassword())) {

            logFail("User's {id=" + actual.getId() + "} Password {" + actual.getPassword() +
                    "} should equal {" + condition + "} !");
            failWithMessage("User's {id=%s} Password {%s} should equal {%s} !",
                    actual.getId(), actual.getPassword(), condition);
        } else {
            logPass("User's {id=" + actual.getId() + "} Password equals {" + condition + "}");
        }
        return this;
    }

    public final UserAssert regionNameEquals(final String condition) {

        isNotNull();

        if (!condition.equals(actual.getRegionName())) {

            logFail("User's {id=" + actual.getId() + "} Region name {" + actual.getRegionName() +
                    "} should equal {" + condition + "} !");
            failWithMessage("User's {id=%s} Region name {%s} should equal {%s} !",
                    actual.getId(), actual.getRegionName(), condition);
        } else {
            logPass("User's {id=" + actual.getId() + "} Region name equals {" + condition + "}");
        }
        return this;
    }

    public final UserAssert isUserActive() {

        isNotNull();

        if (actual.getUserActive() != 1) {

            logFail("User {id=" + actual.getId() + "} should be active !");
            failWithMessage("User {id=%s} should be active !", actual.getId());
        } else {
            logPass("User {id=" + actual.getId() + "} is active");
        }
        return this;
    }

    public final UserAssert isUserInactive() {

        isNotNull();

        if (actual.getUserActive() == 1) {

            logFail("User {id=" + actual.getId() + "} should be inactive !");
            failWithMessage("User {id=%s} should be inactive !", actual.getId());
        } else {
            logPass("User {id=" + actual.getId() + "} is inactive");
        }
        return this;
    }

    @Override
    public final UserAssert isNotNull() {

        if (actual == null) {

            logFail("Required user should be not null !");
            failWithMessage("Required user should be not null !");
        }
        return this;
    }

}

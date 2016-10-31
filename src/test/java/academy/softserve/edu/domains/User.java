package academy.softserve.edu.domains;

import academy.softserve.edu.enums.CustomerTypes;
import academy.softserve.edu.enums.Regions;
import academy.softserve.edu.enums.Roles;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter @EqualsAndHashCode
public class User {

    private int id;
    private int userActive;
    private int balance;
    private String email;
    private String firstName;
    private String lastName;
    private String login;
    private String password;
    private int customerTypeReference;
    private int regionReference;
    private int roleReference;

    private User() {

    }

    public static FirstIdStep newBuilder() {
        return new Builder();
    }

    public interface FirstIdStep {
        UserActiveStep setId(final int id);
    }

    public interface UserActiveStep {
        BalanceStep setUserActive(final int userActive);
    }

    public interface BalanceStep {
        EmailStep setBalance(final int balance);
    }

    public interface EmailStep {
        FirstNameStep setEmail(final String email);
    }

    public interface FirstNameStep {
        LastNameStep setFirstName(final String firstName);
    }

    public interface LastNameStep {
        LoginStep setLastName(final String lastName);
    }

    public interface LoginStep {
        PasswordStep setLogin(final String login);
    }

    public interface PasswordStep {
        CustomerTypeReferenceStep setPassword(final String password);
    }

    public interface CustomerTypeReferenceStep {
        RegionReferenceStep setCustomerTypeReference(final int customerTypeReference);
    }

    public interface RegionReferenceStep {
        RoleReferenceStep setRegionReference(final int regionReference);
    }

    public interface RoleReferenceStep {
        BuildStep setRoleReference(final int roleReference);
    }

    public interface BuildStep {
        User build();
    }

    private static class Builder implements FirstIdStep, UserActiveStep, BalanceStep,
            EmailStep, FirstNameStep, LastNameStep, LoginStep, PasswordStep,
            CustomerTypeReferenceStep, RegionReferenceStep, RoleReferenceStep, BuildStep {

        private int id;
        private int userActive;
        private int balance;
        private String email;
        private String firstName;
        private String lastName;
        private String login;
        private String password;
        private int customerTypeReference;
        private int regionReference;
        private int roleReference;

        @Override
        public final UserActiveStep setId(final int id) {
            this.id = id;
            return this;
        }

        @Override
        public final BalanceStep setUserActive(final int userActive) {
            this.userActive = userActive;
            return this;
        }

        @Override
        public final EmailStep setBalance(final int balance) {
            this.balance = balance;
            return this;
        }

        @Override
        public final FirstNameStep setEmail(final String email) {
            this.email = email;
            return this;
        }

        @Override
        public final LastNameStep setFirstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        @Override
        public final LoginStep setLastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        @Override
        public final PasswordStep setLogin(final String login) {
            this.login = login;
            return this;
        }

        @Override
        public final CustomerTypeReferenceStep setPassword(final String password) {
            this.password = password;
            return this;
        }

        @Override
        public final RegionReferenceStep setCustomerTypeReference(final int customerTypeReference) {
            this.customerTypeReference = customerTypeReference;
            return this;
        }

        @Override
        public final RoleReferenceStep setRegionReference(final int regionReference) {
            this.regionReference = regionReference;
            return this;
        }

        @Override
        public final BuildStep setRoleReference(final int roleReference) {
            this.roleReference = roleReference;
            return this;
        }

        @Override
        public final User build() {

            final User user = new User();

            user.setId(id);
            user.setUserActive(userActive);
            user.setBalance(balance);
            user.setEmail(email);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setLogin(login);
            user.setPassword(password);
            user.setCustomerTypeReference(customerTypeReference);
            user.setRegionReference(regionReference);
            user.setRoleReference(roleReference);

            return user;
        }
    }

    public final String getRoleName() {
        return Roles.getRoleNameByReference(roleReference);
    }

    public final String getRegionName() {
        return Regions.getRegionNameByReference(regionReference);
    }

    public final String getCustomerTypeName() {
        return CustomerTypes.getCustomerTypeNameByReference(customerTypeReference);
    }

    @Override
    public final String toString() {

        return "User {" +
                "ID=" + id +
                ", isUserActive=" + userActive +
                ", Balance=" + balance +
                ", Email=" + email +
                ", FirstName=" + firstName +
                ", LastName=" + lastName +
                ", Login=" + login +
                ", Password=" + password +
                ", CustomerTypeRef=" + customerTypeReference +
                ", RegionRef=" + regionReference +
                ", RoleRef=" + roleReference +
                "}";
    }

}

package academy.softserve.edu.domains;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditCard {

    private String cardType;
    private String cardNumber;
    private int CVV2;
    private int expireDateMonth;
    private int expireDateYear;
    private String startDate;
    private int issueNumber;

    private CreditCard() {

    }

    public static FirstCardTypeStep newBuilder() {
        return new Builder();
    }

    public interface FirstCardTypeStep {
        CardNumberStep setCardType(final String cardType);
    }

    public interface CardNumberStep {
        CVV2Step setCardNumber(final String cardNumber);
    }

    public interface CVV2Step {
        ExpireDateMonthStep setCVV2(final int CVV2);
    }

    public interface ExpireDateMonthStep {
        ExpireDateYearStep setExpireDateMonth(final int expireDateMonth);
    }

    public interface ExpireDateYearStep {
        StartDateStep setExpireDateYear(final int expireDateYear);
    }

    public interface StartDateStep {
        IssueNumberStep setStartDate(final String startDate);
        IssueNumberStep skipStartDate();
    }

    public interface IssueNumberStep {
        BuildStep setIssueNumber(final int issueNumber);
        BuildStep skipIssueNumber();
    }

    public interface BuildStep {
        CreditCard build();
    }

    private static class Builder implements FirstCardTypeStep, CardNumberStep, CVV2Step,
            ExpireDateMonthStep, ExpireDateYearStep, StartDateStep, IssueNumberStep,
            BuildStep {

        private String cardType;
        private String cardNumber;
        private int CVV2;
        private int expireDateMonth;
        private int expireDateYear;
        private String startDate;
        private int issueNumber;

        @Override
        public final CardNumberStep setCardType(final String cardType) {
            this.cardType = cardType;
            return this;
        }

        @Override
        public final CVV2Step setCardNumber(final String cardNumber) {
            this.cardNumber = cardNumber;
            return this;
        }

        @Override
        public final ExpireDateMonthStep setCVV2(final int CVV2) {
            this.CVV2 = CVV2;
            return this;
        }

        @Override
        public final ExpireDateYearStep setExpireDateMonth(final int expireDateMonth) {
            this.expireDateMonth = expireDateMonth;
            return this;
        }

        @Override
        public final StartDateStep setExpireDateYear(final int expireDateYear) {
            this.expireDateYear = expireDateYear;
            return this;
        }

        @Override
        public final IssueNumberStep setStartDate(final String startDate) {
            this.startDate = startDate;
            return this;
        }

        @Override
        public final IssueNumberStep skipStartDate() {
            return this;
        }

        @Override
        public final BuildStep setIssueNumber(final int issueNumber) {
            this.issueNumber = issueNumber;
            return this;
        }

        @Override
        public final BuildStep skipIssueNumber() {
            return this;
        }

        @Override
        public CreditCard build() {

            final CreditCard creditCard = new CreditCard();

            creditCard.setCardType(cardType);
            creditCard.setCardNumber(cardNumber);
            creditCard.setCVV2(CVV2);
            creditCard.setExpireDateMonth(expireDateMonth);
            creditCard.setExpireDateYear(expireDateYear);
            creditCard.setStartDate(startDate);
            creditCard.setIssueNumber(issueNumber);

            return creditCard;
        }
    }
}


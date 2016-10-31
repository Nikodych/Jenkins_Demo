package academy.softserve.edu.repos;

import academy.softserve.edu.domains.CreditCard;

public final class CreditCardRepo {

    private static final int CVV2_CODE = 456;
    private static final int EXPIRE_DATE_MONTH = 10;
    private static final int EXPIRE_DATE_YEAR = 2017;

    private CreditCardRepo() {

    }

    public static CreditCard getValidVisaCard() {

        return CreditCard.newBuilder()
                .setCardType("Visa")
                .setCardNumber("4532543327732234")
                .setCVV2(CVV2_CODE)
                .setExpireDateMonth(EXPIRE_DATE_MONTH)
                .setExpireDateYear(EXPIRE_DATE_YEAR)
                .skipStartDate()
                .skipIssueNumber()
                .build();
    }

    public static CreditCard getValidMasterCard() {

        return CreditCard.newBuilder()
                .setCardType("MasterCard")
                .setCardNumber("5408694520868818")
                .setCVV2(CVV2_CODE)
                .setExpireDateMonth(EXPIRE_DATE_MONTH)
                .setExpireDateYear(EXPIRE_DATE_YEAR)
                .skipStartDate()
                .skipIssueNumber()
                .build();
    }

    public static CreditCard getValidAmericanExpressCard() {

        return CreditCard.newBuilder()
                .setCardType("American Express")
                .setCardNumber("345024720300379")
                .setCVV2(CVV2_CODE)
                .setExpireDateMonth(EXPIRE_DATE_MONTH)
                .setExpireDateYear(EXPIRE_DATE_YEAR)
                .skipStartDate()
                .skipIssueNumber()
                .build();
    }

    public static CreditCard getValidMaestroCard() {

        return CreditCard.newBuilder()
                .setCardType("Maestro")
                .setCardNumber("6759316694729609")
                .setCVV2(CVV2_CODE)
                .setExpireDateMonth(EXPIRE_DATE_MONTH)
                .setExpireDateYear(EXPIRE_DATE_YEAR)
                .setStartDate("29/09/2016")
                .setIssueNumber(4)
                .build();
    }

    public static CreditCard getInvalidCard() {

        return CreditCard.newBuilder()
                .setCardType("Visa")
                .setCardNumber("2562624")
                .setCVV2(CVV2_CODE)
                .setExpireDateMonth(EXPIRE_DATE_MONTH)
                .setExpireDateYear(EXPIRE_DATE_YEAR)
                .skipStartDate()
                .skipIssueNumber()
                .build();
    }
}

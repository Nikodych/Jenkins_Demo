package academy.softserve.edu.utils;

import academy.softserve.edu.enums.Roles;
import academy.softserve.edu.enums.administration_page.SearchConditions;
import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    private static final String EXCEL_FILE = PropertiesReader.getDefaultProperty("excel.file");

    @DataProvider
    static public Object[][] testDataForAllUsersRole() {
        return new Object[][]{
                {Roles.ADMINISTRATOR},
                {Roles.MERCHANDISER},
                {Roles.SUPERVISOR},
                {Roles.CUSTOMER}};
    }

    @DataProvider
    static final public Object[][] excelLogInDataForAllUsersRole() throws IOException {
        return ExcelReader.getArrayFromExcel(EXCEL_FILE, "sheet1");
    }

    @DataProvider
    static final public Object[][] oneColumnOfExcelLoginData() throws IOException {
        return ExcelReader.getColumnByName(EXCEL_FILE, "password", "sheet1");
    }

    @DataProvider
    static final public Object[][] oneColumnFromDefaultExcelFile() throws IOException {
        return ExcelReader.getColumnByName("password", "sheet1");
    }


    @DataProvider
    static final public Object[][] testSearchingForAllColumnsFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "Customer", "Customer"},
                {SearchConditions.NOT_EQUALS_TO, "Sarumjan", "Administrator"},
                {SearchConditions.STARTS_WITH, "C", "Customer"},
                {SearchConditions.CONTAINS, "Admin", "Administrator"},
                {SearchConditions.DOES_NOT_CONTAIN, "Admin", "Merchandiser"},

        };
    }

    @DataProvider
    static final public Object[][] testSearchingForFirstNameFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "ivanka", "ivanka"},
                {SearchConditions.NOT_EQUALS_TO, "Sarumjan", "ivanka"},
                {SearchConditions.STARTS_WITH, "i", "ivanka"},
                {SearchConditions.CONTAINS, "ivank", "ivanka"},
                {SearchConditions.DOES_NOT_CONTAIN, "rom", "ivanka"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForLastNameFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "horoshko", "horoshko"},
                {SearchConditions.NOT_EQUALS_TO, "shram", "horoshko"},
                {SearchConditions.STARTS_WITH, "h", "horoshko"},
                {SearchConditions.CONTAINS, "horosh", "horoshko"},
                {SearchConditions.DOES_NOT_CONTAIN, "a", "horoshko"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForLoginFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "login1", "login1"},
                {SearchConditions.NOT_EQUALS_TO, "sha", "iva"},
                {SearchConditions.STARTS_WITH, "l", "login1"},
                {SearchConditions.CONTAINS, "login1", "login1"},
                {SearchConditions.DOES_NOT_CONTAIN, "login1", "iva"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForRoleFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "Merchandiser", "Merchandiser"},
                {SearchConditions.NOT_EQUALS_TO, "Administrator", "Merchandiser"},
                {SearchConditions.STARTS_WITH, "Cust", "Customer"},
                {SearchConditions.CONTAINS, "Merchandiser", "Merchandiser"},
                {SearchConditions.DOES_NOT_CONTAIN, "Administrator", "Merchandiser"},
        };
    }

    @DataProvider
    static final public Object[][] testSearchingForRegionFilter() {
        return new Object[][]{
                {SearchConditions.EQUALS, "West", "West"},
                {SearchConditions.NOT_EQUALS_TO, "West", "South"},
                {SearchConditions.STARTS_WITH, "North", "North"},
                {SearchConditions.CONTAINS, "South", "South"},
                {SearchConditions.DOES_NOT_CONTAIN, "East", "West"}
        };
    }
}


package academy.softserve.edu.utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public final class ExcelReader {

    private ExcelReader() {

    }

    public static String[][] getArrayFromExcel(final String excelFileName,
                                               final String sheetName) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(excelFileName);
        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet = workBook.getSheet(sheetName);

        final int numberOfRows = sheet.getPhysicalNumberOfRows();
        final int numberOfCells = sheet.getRow(0)
                .getPhysicalNumberOfCells();

        final String[][] loginData = new String[numberOfRows - 1][numberOfCells];

        for (int i = 1; i < numberOfRows; i++) {

            for (int j = 0; j < numberOfCells; j++) {

                loginData[i - 1][j] = sheet
                        .getRow(i)
                        .getCell(j)
                        .getStringCellValue();
            }
        }
        fileSystem.close();

        return loginData;
    }


    public static String[][] getColumnByName(final String excelFileName, final String cellName,
                                             final String sheetName) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(excelFileName);
        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet = workBook.getSheet(sheetName);
        final Row row = sheet.getRow(0);

        final int numberOfRows = sheet
                .getPhysicalNumberOfRows() - 1;
        final int numberOfCells = row
                .getPhysicalNumberOfCells();

        final String[][] columnArray = new String[numberOfRows][1];
        int cellColumn = 0;

        for (int j = 0; j < numberOfCells; j++) {

            if (cellName.equals(row.getCell(j).getStringCellValue())) {
                cellColumn = j;
            }
        }

        int j = 1;

        for (int i = 0; i < numberOfRows; i++) {

            columnArray[i][0] = sheet
                    .getRow(j)
                    .getCell(cellColumn)
                    .getStringCellValue();
            j++;
        }
        fileSystem.close();

        return columnArray;
    }

    public static String[][] getColumnByName(final String cellName,
                                             final String sheetName) throws IOException {

        final FileInputStream fileSystem = new FileInputStream(PropertiesReader.getDefaultProperty("excel.file"));

        final Workbook workBook = new XSSFWorkbook(fileSystem);
        final Sheet sheet = workBook.getSheet(sheetName);
        final Row row = sheet.getRow(0);

        final int numberOfRows = sheet.getPhysicalNumberOfRows() - 1;
        final int numberOfCells = row.getPhysicalNumberOfCells();

        final String[][] columnArray = new String[numberOfRows][1];
        int cellColumn = 0;

        for (int j = 0; j < numberOfCells; j++) {

            if (cellName.equals(row.getCell(j).getStringCellValue())) {
                cellColumn = j;
            }
        }

        int j = 1;

        for (int i = 0; i < numberOfRows; i++) {

            columnArray[i][0] = sheet
                    .getRow(j)
                    .getCell(cellColumn)
                    .getStringCellValue();
            j++;
        }
        fileSystem.close();

        return columnArray;
    }

}

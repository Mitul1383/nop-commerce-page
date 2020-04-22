package com.demo.nopcommerce.excelutility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;

/**
 * Created by Mitul
 */
public class ExcelRead {
    public static void main(String[] args) {

        String projectPath = System.getProperty("user.dir");

        XSSFWorkbook excelWBook;
        XSSFSheet excelWSheet;
        XSSFCell Cell;

        // Location of the Excel file
        String path = projectPath + "/src/test/java/com/demo/nopcommerce/resources/testdata/JustTest.xlsx";
        String sheetName = "Sheet1";

        try {
            FileInputStream ExcelFile = new FileInputStream(path);
            excelWBook = new XSSFWorkbook(ExcelFile);
            excelWSheet = excelWBook.getSheet(sheetName);

            Cell = excelWSheet.getRow(0).getCell(1);
            String cellData = Cell.getStringCellValue();
            System.out.println("Cell Data: " + cellData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

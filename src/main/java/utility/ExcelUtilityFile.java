package utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelUtilityFile {
    static String PATH = "C:\\Users\\91812\\IdeaProjects\\Selenium_Maven\\SelTest1\\src\\main\\resources\\testData\\td.xlsx";
    FileInputStream io;
    FileOutputStream fo;
    XSSFWorkbook wb;
    XSSFSheet sheet;
    XSSFRow row;
    XSSFCell cell;

    public ExcelUtilityFile(String path) {
        PATH = path;
    }

    public int rowCount(String sheetName) throws IOException {

        io = new FileInputStream(PATH);
        wb = new XSSFWorkbook(io);
        sheet = wb.getSheet(sheetName);
        int rowCount = sheet.getLastRowNum();
        wb.close();
        io.close();
        return rowCount;

    }

    public int columnCount(String sheetName, int rowCount) throws IOException {
        io = new FileInputStream(PATH);
        wb = new XSSFWorkbook(io);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowCount);
        return row.getLastCellNum();


    }

    public String getCellData(String sheetName, int rowNum, int colNum) throws Exception {
        io = new FileInputStream(PATH);
        wb = new XSSFWorkbook(io);
        sheet = wb.getSheet(sheetName);
        row = sheet.getRow(rowNum);
        cell = row.getCell(colNum);

        return cell.getStringCellValue();
    }

    public void setCellData(String sheetName, int rowNum, int columnNum, String data) throws IOException {
        File excelFile = new File(PATH);
        if (!excelFile.exists())    // If file not exists then create new file
        {
            wb = new XSSFWorkbook();
            fo = new FileOutputStream(PATH);
            wb.write(fo);
        }

        io = new FileInputStream(PATH);
        wb = new XSSFWorkbook(io);

        if (wb.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
            wb.createSheet(sheetName);

        sheet = wb.getSheet(sheetName);

        if (sheet.getRow(rowNum) == null)   // If row not exists then create new Row
            sheet.createRow(rowNum);
        row = sheet.getRow(rowNum);

        cell = row.createCell(columnNum);
        cell.setCellValue(data);
        fo = new FileOutputStream(PATH);
        wb.write(fo);
        wb.close();
        io.close();
        fo.close();
    }


    public static void main(String[] args) throws Exception {
        ExcelUtilityFile excel = new ExcelUtilityFile(PATH);
        System.out.println(excel.rowCount("Sheet1"));
        System.out.println(excel.columnCount("Sheet1", 2));
        System.out.println(excel.getCellData("Sheet1", 2, 1));
        excel.setCellData("Sheet1", 2, 2, "sdf");
    }


}

package com.combinatorg.dao.util;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

/**
 * Created by svetlana on 31/05/15.
 */
public class CommonExcelUtil {
    private static final Logger LOGGER =  LoggerFactory.getLogger(CommonExcelUtil.class);
    public static final String EXCEL_FILE_PATH = "./doc/test.xlsx";

    public static Iterator<Row> getExcelRows(String sheetName) {
        Iterator<Row> rowIterator = null;
        try (FileInputStream file = new FileInputStream(new File(EXCEL_FILE_PATH))) {
            XSSFWorkbook workbook = new XSSFWorkbook(file);
            XSSFSheet sheet = workbook.getSheet(sheetName);
            rowIterator = sheet.rowIterator();

        } catch (IOException ex) {
            LOGGER.error(ex.getMessage(), ex);
        }
        return rowIterator;
    }
}

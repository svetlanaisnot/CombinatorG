package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Question;
import org.apache.poi.ss.usermodel.Cell;
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

    public static Question createQuestion(Cell cell, String sign) {
        Question question = new Question();
        String cellValue = cell.getStringCellValue();
        question.setTitle(createQuestionTitle(cellValue));
        question.setCategoryId(createQuestionCategory(cellValue, sign));
        return question;
    }

    private static String createQuestionTitle(String s) {
        String[] parts = s.split("\\(");
        return parts[0].trim();
    }

    private static int createQuestionCategory(String s, String sign) {
        String[] parts = s.split("\\(");
        return Integer.valueOf(parts[1].substring(0, parts[1].indexOf(sign)));
    }
}

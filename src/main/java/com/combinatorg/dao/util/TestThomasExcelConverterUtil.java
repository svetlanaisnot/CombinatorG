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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class TestThomasExcelConverterUtil {

    private static final Logger LOGGER =  LoggerFactory.getLogger(TestThomasExcelConverterUtil.class);
    public static final String SHEET_NAME = "тест Томаса";

    public static Iterator<Row> getTestThomasRows() {
        return CommonExcelUtil.getExcelRows(SHEET_NAME);
    }

    public static List<Question> convertToQuestions(Iterator<Row> rowIterator) {
        List<Question> questions = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            questions.add(createQuestion(row.getCell(0)));
            questions.add(createQuestion(row.getCell(1)));
        }
        return questions;
    }

    private static Question createQuestion(Cell cell) {
        Question question = new Question();
        String cellValue = cell.getStringCellValue();
        question.setTitle(createQuestionTitle(cellValue));
        question.setCategoryId(createQuestionCategory(cellValue));
        question.setThomas(true);
        return question;
    }

    private static String createQuestionTitle(String s) {
        String[] parts = s.split("\\.");
        return parts[1].trim();
    }

    private static int createQuestionCategory(String s) {
        return Integer.valueOf(s.substring(0, s.indexOf(" ")));
    }
}

package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Statement;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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

    public static List<Statement> convertToQuestions(Iterator<Row> rowIterator) {
        List<Statement> statements = new ArrayList<>();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();
            statements.add(createQuestion(row.getCell(0)));
            statements.add(createQuestion(row.getCell(1)));
        }
        return statements;
    }

    private static Statement createQuestion(Cell cell) {
        Statement statement = new Statement();
        String cellValue = cell.getStringCellValue();
        statement.setTitle(createQuestionTitle(cellValue));
        statement.setCategoryId(createQuestionCategory(cellValue));
        statement.setThomas(true);
        return statement;
    }

    private static String createQuestionTitle(String s) {
        String[] parts = s.split("\\.");
        return parts[1].trim();
    }

    private static int createQuestionCategory(String s) {
        return Integer.valueOf(s.substring(0, s.indexOf(" ")));
    }
}

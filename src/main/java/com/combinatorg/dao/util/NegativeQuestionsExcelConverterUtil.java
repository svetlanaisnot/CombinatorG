package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Statement;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class NegativeQuestionsExcelConverterUtil {

    public static final String SHEET_NAME = "-1";

    public static Iterator<Row> getNegativeRows() {
        return CommonExcelUtil.getExcelRows(SHEET_NAME);
    }

    public static List<List<Statement>> createQuestions(Iterator<Row> iter) {
        return convertToQuestions(iter);
    }

    private static List<List<Statement>> convertToQuestions(Iterator<Row> iter) {
        List<List<Statement>> questions = new ArrayList<>();
        List<Statement> firstPart = new ArrayList<>();
        List<Statement> secondPart = new ArrayList<>();
        int rowNumber = 1;
        while (iter.hasNext()) {
            Row row = iter.next();
            if (rowNumber <= 13) {
                firstPart.add(CommonExcelUtil.createQuestion(row.getCell(0), "-"));
                firstPart.add(CommonExcelUtil.createQuestion(row.getCell(1), "-"));
            } else {
                secondPart.add(CommonExcelUtil.createQuestion(row.getCell(0), "-"));
                secondPart.add(CommonExcelUtil.createQuestion(row.getCell(1), "-"));
            }
            rowNumber++;
        }
        questions.add(firstPart);
        questions.add(secondPart);
        return questions;
    }
}

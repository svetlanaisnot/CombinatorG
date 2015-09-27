package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Statement;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class NegativeQuestionsExcelConverterUtil {


    public static Iterator<Row> getNegativeRows(String sheetName) {
        return CommonExcelUtil.getExcelRows(sheetName);
    }

    public static List<List<Statement>> convertToNegativeStatement1(Iterator<Row> iter) {
        List<List<Statement>> questions = new ArrayList<>();
        List<Statement> statements1 = new ArrayList<>();
        List<Statement> statements2 = new ArrayList<>();
        List<Statement> statements3 = new ArrayList<>();
        List<Statement> statements4 = new ArrayList<>();
        int rowNumber = 1;
        while (iter.hasNext()) {
            Row row = iter.next();
            if (rowNumber <= 13) {
                statements1.add(CommonExcelUtil.createQuestion(row.getCell(0), "-"));
                statements2.add(CommonExcelUtil.createQuestion(row.getCell(1), "-"));
            } else {
                statements3.add(CommonExcelUtil.createQuestion(row.getCell(0), "-"));
                statements4.add(CommonExcelUtil.createQuestion(row.getCell(1), "-"));
            }
            rowNumber++;
        }
        Collections.sort(statements1);
        Collections.sort(statements2);
        Collections.sort(statements3);
        Collections.sort(statements4);
        questions.add(statements1);
        questions.add(statements2);
        questions.add(statements3);
        questions.add(statements4);
        return questions;
    }

    public static List<List<Statement>> convertToNegativeStatement2(Iterator<Row> iter) {
        List<List<Statement>> result = new ArrayList<>();
        List<Statement> statements1 = new ArrayList<>();
        List<Statement> statements2 = new ArrayList<>();
        while (iter.hasNext()) {
            Row row = iter.next();
            statements1.add(CommonExcelUtil.createQuestion(row.getCell(0), "-"));
            statements2.add(CommonExcelUtil.createQuestion(row.getCell(1), "-"));
        }
        Collections.sort(statements1);
        Collections.sort(statements2);
        result.add(statements1);
        result.add(statements2);
        return result;
    }
}

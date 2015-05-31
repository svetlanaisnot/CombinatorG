package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Question;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class PositiveQuestionsExcelConverterUtil {

    public static final String SHEET_NAME_1 = "+1";
    public static final String SHEET_NAME_2 = "+2";

    public static Iterator<Row> getPositiveRows1() {
        return CommonExcelUtil.getExcelRows(SHEET_NAME_1);
    }

    public static Iterator<Row> getPositiveRows2() {
        return CommonExcelUtil.getExcelRows(SHEET_NAME_2);
    }

    public static List<Question> createQuestions(Iterator<Row> iter1, Iterator<Row> iter2) {
        List<Question> questions = new ArrayList<>();
        questions.addAll(convertToQuestions(iter1));
        questions.addAll(convertToQuestions(iter2));
        return questions;
    }

    private static List<Question> convertToQuestions(Iterator<Row> iter) {
        List<Question> questions = new ArrayList<>();
        while (iter.hasNext()) {
            Row row = iter.next();
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
        return question;
    }

    private static String createQuestionTitle(String s) {
        String[] parts = s.split("\\(");
        return parts[0].trim();
    }

    private static int createQuestionCategory(String s) {
        return Integer.valueOf(s.substring(s.indexOf("(") + 1, s.indexOf("+")));
    }
}

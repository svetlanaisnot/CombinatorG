package com.combinatorg.dao.util;

import com.combinatorg.dao.model.test.question.Question;
import org.apache.poi.ss.usermodel.Row;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class PositiveQuestionsExcelConverterUtil {

    public static final String SHEET_NAME = "+1";

    public static Iterator<Row> getPositiveRows() {
        return CommonExcelUtil.getExcelRows(SHEET_NAME);
    }

    public static List<Question> createQuestions(Iterator<Row> iter) {
        return convertToQuestions(iter);
    }

    private static List<Question> convertToQuestions(Iterator<Row> iter) {
        List<Question> questions = new ArrayList<>();
        while (iter.hasNext()) {
            Row row = iter.next();
            questions.add(CommonExcelUtil.createQuestion(row.getCell(0), "+"));
            questions.add(CommonExcelUtil.createQuestion(row.getCell(1), "+"));
        }
        return questions;
    }


}

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
public class PositiveQuestionsExcelConverterUtil {



    public static Iterator<Row> getPositiveRows(String sheetName) {
        return CommonExcelUtil.getExcelRows(sheetName);
    }

    public static List<List<Statement>> createQuestions(Iterator<Row> iter) {
        return convertToQuestions(iter);
    }

    private static List<List<Statement>> convertToQuestions(Iterator<Row> iter) {
        List<List<Statement>> result = new ArrayList<>();
        List<Statement> statements1 = new ArrayList<>();
        List<Statement> statements2 = new ArrayList<>();
        while (iter.hasNext()) {
            Row row = iter.next();
            statements1.add(CommonExcelUtil.createQuestion(row.getCell(0), "+"));
            statements2.add(CommonExcelUtil.createQuestion(row.getCell(1), "+"));
        }
        Collections.sort(statements1);
        Collections.sort(statements2);
        result.add(statements1);
        result.add(statements2);
        return result;
    }


}

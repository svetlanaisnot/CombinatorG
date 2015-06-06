package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Statement;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class TestThomasExcelUploaderTest {

    public static void main(String[] args) {
        List<Statement> testThomasStatements = new ExcelTestQuestionsDaoImpl().getThomasTestStatements();
        for (Statement statement : testThomasStatements) {
            System.out.println(statement);
        }

    }
}

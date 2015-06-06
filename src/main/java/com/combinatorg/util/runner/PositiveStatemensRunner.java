package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Statement;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class PositiveStatemensRunner {
    public static void main(String[] args) {
        List<Statement> positiveQ = new ExcelTestQuestionsDaoImpl().getPositiveStatements();
        for (Statement statement : positiveQ) {
            System.out.println(statement);
        }
        System.out.println(positiveQ.size());
    }
}

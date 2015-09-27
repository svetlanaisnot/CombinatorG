package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Statement;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class NegativeStatemensRunner {

    public static void main(String[] args) {
        List<List<Statement>> qLists = new ExcelTestQuestionsDaoImpl().getNegativeStatements();
        for (List<Statement> qList : qLists) {
            for (Statement statement : qList) {
                System.out.println(statement);
            }
            System.out.println("===============Statement list finished ============");
            System.out.println(qList.size());
        }

    }
}

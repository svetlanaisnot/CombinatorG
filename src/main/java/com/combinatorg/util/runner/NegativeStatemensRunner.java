package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Statement;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class NegativeStatemensRunner {

    public static void main(String[] args) {
        int id = 1;
        int subcategory = 1;
        List<List<Statement>> qLists = new ExcelTestQuestionsDaoImpl().getNegativeStatements();
        for (List<Statement> qList : qLists) {
            System.out.println("Subcategory = " + subcategory);
            for (Statement statement : qList) {
                statement.setId(id);
                System.out.println(statement);
                id++;
            }
            subcategory++;
        }
        System.out.println("===============Statement list finished ============");
        System.out.println("Current id = " + id);
    }
}

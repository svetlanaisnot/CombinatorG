package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Statement;

import java.util.*;

/**
 * Created by svetlana on 31/05/15.
 */
public class PositiveStatemensRunner {
    public static void main(String[] args) {
        int id = 1;
        int subcategory = 1;
        List<List<Statement>> positiveQ = new ExcelTestQuestionsDaoImpl().getPositiveStatements();
        for (List<Statement> statementList : positiveQ) {
            System.out.println("Subcategory = " + subcategory);
            for (Statement statement : statementList) {
                statement.setId(id);
                System.out.println(statement);
                id++;
            }
            subcategory++;
        }
        System.out.println("===============Statement list finished ============");
        System.out.println("Current id = " + id);

        List<Statement> list1 = positiveQ.get(0);
        List<Statement> list2 = positiveQ.get(1);

        preparePares(list1, list2);

        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
            System.out.println(list2.get(i));
        }

    }

    private static void preparePares(List<Statement> list1, List<Statement> list2) {
        boolean foundDuplicateCategories = true;
        int counter = 0;
        while (foundDuplicateCategories) {
            foundDuplicateCategories = false;
            Collections.shuffle(list1);
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getCategoryId() == list2.get(i).getCategoryId()) {
                    foundDuplicateCategories = true;
                    break;
                }
            }
            counter++;
            System.out.println("Counter = "+ counter);
        }

    }
}

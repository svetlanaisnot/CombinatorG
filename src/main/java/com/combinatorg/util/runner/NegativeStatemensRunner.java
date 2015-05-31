package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Question;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class NegativeStatemensRunner {

    public static void main(String[] args) {
        List<List<Question>> qLists = new ExcelTestQuestionsDaoImpl().getNegativeQuestions();
        for (List<Question> qList : qLists) {
            for (Question question : qList) {
                System.out.println(question);
            }
            System.out.println("===============Question list finished ============");
            System.out.println(qList.size());
        }

    }
}

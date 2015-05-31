package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Question;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class PositiveStatemensRunner {
    public static void main(String[] args) {
        List<Question> positiveQ = new ExcelTestQuestionsDaoImpl().getPositiveQuestions();
        for (Question question : positiveQ) {
            System.out.println(question);
        }
        System.out.println(positiveQ.size());
    }
}

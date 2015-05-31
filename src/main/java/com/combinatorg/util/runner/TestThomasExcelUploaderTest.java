package com.combinatorg.util.runner;

import com.combinatorg.dao.ExcelTestQuestionsDaoImpl;
import com.combinatorg.dao.model.test.question.Question;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public class TestThomasExcelUploaderTest {

    public static void main(String[] args) {
        List<Question> testThomasQuestions = new ExcelTestQuestionsDaoImpl().getThomasTestQuestions();
        for (Question question : testThomasQuestions) {
            System.out.println(question);
        }

    }
}

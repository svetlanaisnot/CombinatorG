package com.combinatorg.service.test;

import com.combinatorg.dao.TestQuestionsDao;
import com.combinatorg.dao.model.test.question.Statement;
import com.combinatorg.model.test.TestQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by svetlana on 06/06/15.
 */
@Service
public class TestService {

    @Autowired
    TestQuestionsDao testQuestionsDao;


    public List<TestQuestion> getTestContent() {
        //Get all statements from database;
        List<Statement> thomasStatements = testQuestionsDao.getThomasTestStatements();
        List<List<Statement>> positiveStatements = testQuestionsDao.getPositiveStatements();
        List<List<Statement>> negativeStatements = testQuestionsDao.getNegativeStatements();

        //convert all statements into test questions
        List<TestQuestion> testContent = new ArrayList<>();

        testContent.addAll(createThomasTestQuestions(thomasStatements));
        testContent.addAll(createQuestions(positiveStatements, true));
        testContent.addAll(createQuestions(negativeStatements, false));
        //shuffle and return
        Collections.shuffle(testContent);
        return testContent;
    }

    private List<TestQuestion> createThomasTestQuestions(List<Statement> statements) {
        List<TestQuestion> result = new ArrayList<>();
         for (int i = 0; i < statements.size() /2; i ++) {
             result.add(TestQuestion.createTestThomasQuestion(statements.get(2 * i), statements.get(2 * i + 1)));
         }
        return result;
    }

    private List<TestQuestion> createQuestions(List<List<Statement>> listOfStatements, boolean isPositive) {
        List<TestQuestion> result = new ArrayList<>();
        for (int i = 0; i < listOfStatements.size() / 2; i++) {
            result.addAll(
                    createQuestionListFromPair(listOfStatements.get(2 * i), listOfStatements.get(2 * i + 1), isPositive)
            );
        }
        return result;
    }

    private List<TestQuestion> createQuestionListFromPair(List<Statement> list1, List<Statement> list2, boolean isPositive) {
        List<TestQuestion> result = new ArrayList<>();
        makeUniqueCategory(list1, list2);
        for (int i = 0; i < list1.size(); i++) {
            Statement st1 = list1.get(i);
            Statement st2 = list2.get(i);
            result.add(isPositive ? TestQuestion.createPositiveQuestion(st1, st2)
                                  : TestQuestion.createNegativeQuestion(st1, st2));
        }

        return result;
    }



    private void makeUniqueCategory(List<Statement> list1, List<Statement> list2) {
        boolean foundDuplicateCategories = true;
        while (foundDuplicateCategories) {
            foundDuplicateCategories = false;
            Collections.shuffle(list1);
            for (int i = 0; i < list1.size(); i++) {
                if (list1.get(i).getCategoryId() == list2.get(i).getCategoryId()) {
                    foundDuplicateCategories = true;
                    break;
                }
            }
        }

    }
}

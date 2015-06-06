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
        List<Statement> positiveStatements = testQuestionsDao.getPositiveStatements();
        List<List<Statement>> negativeStatements = testQuestionsDao.getNegativeStatements();

        //convert all statements into test questions
        List<TestQuestion> testContent = new ArrayList<>();

        testContent.addAll(createThomasTestQuestions(thomasStatements));
        testContent.addAll(createPositiveNegativeContent(positiveStatements, negativeStatements));
        //shuffle and return
        Collections.shuffle(testContent);
        return testContent;
    }

    private List<TestQuestion> createThomasTestQuestions(List<Statement> statements) {
        List<TestQuestion> result = new ArrayList<>();
         for (int i = 0; i < statements.size() /2; i ++) {
             result.add(new TestQuestion(statements.get(2*i), statements.get(2 * i + 1), true));
         }
        return result;
    }

    private List<TestQuestion> createPositiveNegativeContent(List<Statement> positiveStatements, List<List<Statement>> negativeStatements) {
        List<TestQuestion> result = new ArrayList<>();
        int[] seeds = {2, 3, 5, 7, 11};
        //process positive statements
        result.addAll(createTestQuestions(positiveStatements, seeds[0], seeds[1]));

        int seedIndex = 0;
        //process negative statements using different random seed
        for (List<Statement> negativeStatement : negativeStatements) {
            result.addAll(
               createTestQuestions(
                       negativeStatement, seeds[seedIndex], seeds[(seedIndex + 1) % seeds.length]
               )
            );
            seedIndex = (seedIndex + 2) % seeds.length;
        }

        return result;
    }

    private List<TestQuestion> createTestQuestions(List<Statement> statements, int seed1, int seed2) {
        // split statements into 2 lists
        List<Statement> firstList = new ArrayList<>();
        List<Statement> secondList = new ArrayList<>();
        for (int i = 0; i < statements.size() /2; i++) {
            firstList.add(statements.get(2*i));
            secondList.add(statements.get(2*i + 1));
        }

        //shuffle in different seed
        Collections.shuffle(firstList, new Random(seed1));
        Collections.shuffle(secondList, new Random(seed2));

        //merge the results
        List<TestQuestion> result = new ArrayList<>();
        for (int i = 0; i < firstList.size(); i++) {
            result.add(new TestQuestion(firstList.get(i), secondList.get(i)));
        }

        return result;
    }
}

package com.combinatorg.dao;

import com.combinatorg.dao.model.test.question.Statement;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public interface TestQuestionsDao {

    List<Statement> getThomasTestQuestions();

    List<Statement> getPositiveQuestions();

    List<List<Statement>> getNegativeQuestions();

}

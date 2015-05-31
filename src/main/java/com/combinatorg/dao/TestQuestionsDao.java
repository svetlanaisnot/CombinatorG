package com.combinatorg.dao;

import com.combinatorg.dao.model.test.question.Question;

import java.util.List;

/**
 * Created by svetlana on 31/05/15.
 */
public interface TestQuestionsDao {

    List<Question> getThomasTestQuestions();

    List<Question> getPositiveQuestions();

    List<List<Question>> getNegativeQuestions();

}

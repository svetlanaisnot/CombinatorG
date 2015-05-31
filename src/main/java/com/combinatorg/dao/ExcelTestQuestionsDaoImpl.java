package com.combinatorg.dao;

import com.combinatorg.dao.model.test.question.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.combinatorg.dao.util.TestThomasExcelConverterUtil.*;

/**
 * Created by svetlana on 31/05/15.
 */
@Repository
public class ExcelTestQuestionsDaoImpl implements TestQuestionsDao {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ExcelTestQuestionsDaoImpl.class);

    @Override
    public List<Question> getThomasTestQuestions() {
        return convertToQuestions(
                getTestThomasRows()
        );
    }



}

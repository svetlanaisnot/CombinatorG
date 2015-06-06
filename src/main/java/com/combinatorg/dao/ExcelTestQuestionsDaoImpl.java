package com.combinatorg.dao;

import com.combinatorg.dao.model.test.question.Statement;
import com.combinatorg.dao.util.NegativeQuestionsExcelConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.combinatorg.dao.util.PositiveQuestionsExcelConverterUtil.*;
import static com.combinatorg.dao.util.TestThomasExcelConverterUtil.*;

/**
 * Created by svetlana on 31/05/15.
 */
@Repository
public class ExcelTestQuestionsDaoImpl implements TestQuestionsDao {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ExcelTestQuestionsDaoImpl.class);

    @Override
    public List<Statement> getThomasTestQuestions() {
        return convertToQuestions(
                getTestThomasRows()
        );
    }

    @Override
    public List<Statement> getPositiveQuestions() {
        return createQuestions(
                getPositiveRows()
        );
    }

    @Override
    public List<List<Statement>> getNegativeQuestions() {
        return NegativeQuestionsExcelConverterUtil.createQuestions(
                NegativeQuestionsExcelConverterUtil.getNegativeRows()
        );
    }


}

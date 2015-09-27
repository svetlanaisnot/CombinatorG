package com.combinatorg.dao;

import com.combinatorg.dao.model.test.question.Statement;
import com.combinatorg.dao.util.NegativeQuestionsExcelConverterUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

import static com.combinatorg.dao.util.PositiveQuestionsExcelConverterUtil.*;
import static com.combinatorg.dao.util.TestThomasExcelConverterUtil.*;

/**
 * Created by svetlana on 31/05/15.
 */
@Repository
public class ExcelTestQuestionsDaoImpl implements TestQuestionsDao {

    private static final Logger LOGGER =  LoggerFactory.getLogger(ExcelTestQuestionsDaoImpl.class);

    public static final String POSITIVE_SHEET_1 = "+1";
    public static final String POSITIVE_SHEET_2 = "+2";
    public static final String NEGATIVE_SHEET_1 = "-1";
    public static final String NEGATIVE_SHEET_2 = "-2";

    @Override
    public List<Statement> getThomasTestStatements() {
        return convertToQuestions(
                getTestThomasRows()
        );
    }

    @Override
    public List<List<Statement>> getPositiveStatements() {
        List<List<Statement>> result = new ArrayList<>();

        List<List<Statement>> sheetStatements1 = createQuestions(
                getPositiveRows(POSITIVE_SHEET_1)
        );

        List<List<Statement>> sheetStatements2 = createQuestions(
                getPositiveRows(POSITIVE_SHEET_2)
        );

        result.add(sheetStatements1.get(0));
        result.add(sheetStatements1.get(1));
        result.add(sheetStatements2.get(0));
        result.add(sheetStatements2.get(1));

        return result;
    }

    @Override
    public List<List<Statement>> getNegativeStatements() {
        List<List<Statement>> result;

        result = NegativeQuestionsExcelConverterUtil.convertToNegativeStatement1(
                NegativeQuestionsExcelConverterUtil.getNegativeRows(NEGATIVE_SHEET_1)
        );

        List<List<Statement>> statements2 = NegativeQuestionsExcelConverterUtil.convertToNegativeStatement2(
                NegativeQuestionsExcelConverterUtil.getNegativeRows(NEGATIVE_SHEET_2)
        );

        result.add(statements2.get(0));
        result.add(statements2.get(1));

        return result;
    }


}

package com.combinatorg.model.test;

import com.combinatorg.dao.model.test.question.Statement;

/**
 * Created by svetlana on 06/06/15.
 */
public class TestQuestion {
    private String id;
    private Statement statement1;
    private Statement statement2;

    private boolean isThomas;

    public TestQuestion(Statement statement1, Statement statement2, boolean isThomas) {
        this.id = statement1.getId() + "_" + statement2.getId();
        this.statement1 = statement1;
        this.statement2 = statement2;
        this.isThomas = isThomas;
    }

    public TestQuestion(Statement statement1, Statement statement2) {
        this(statement1, statement2, false);
    }

}

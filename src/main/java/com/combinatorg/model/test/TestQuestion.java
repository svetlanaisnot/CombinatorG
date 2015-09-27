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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Statement getStatement1() {
        return statement1;
    }

    public void setStatement1(Statement statement1) {
        this.statement1 = statement1;
    }

    public Statement getStatement2() {
        return statement2;
    }

    public void setStatement2(Statement statement2) {
        this.statement2 = statement2;
    }

    public boolean isThomas() {
        return isThomas;
    }

    public void setThomas(boolean isThomas) {
        this.isThomas = isThomas;
    }
}

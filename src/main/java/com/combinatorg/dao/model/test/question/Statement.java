package com.combinatorg.dao.model.test.question;

/**
 * Created by svetlana on 31/05/15.
 */
public class Statement implements Comparable<Statement> {
    private int id;
    private String title;
    private boolean isThomas;
    private int categoryId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isThomas() {
        return isThomas;
    }

    public void setThomas(boolean isThomas) {
        this.isThomas = isThomas;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Statement{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isThomas=" + isThomas +
                ", categoryId=" + categoryId +
                '}';
    }

    @Override
    public int compareTo(Statement o) {
        return this.categoryId > o.categoryId ? 1 : this.categoryId < o.getCategoryId() ? -1 : 0;
    }
}

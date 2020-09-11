package com.banulp.toy.junit5test;

public enum RelationGrades {

    BEST("best", 10),
    GOOD("good", 8),
    SOSO("soso", 6),
    NOTBAD("notbad", 4),
    BAD("bad", 2);

    private String name;
    private int code;

    RelationGrades(String name, int code) {
        this.name = name;
        this.code = code;
    }
}

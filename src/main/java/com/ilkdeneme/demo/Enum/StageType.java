package com.ilkdeneme.demo.Enum;


public enum StageType {
    BOOK_DETAILS("Book"),
    MENU("Book"),
    SEARCHED_BOOK_DETAILS("1"),
    CREATE_BOOK("");

    private String val;

    StageType(String book) {
        this.val=book;
    }

    public String getStageType()
    {

        return this.val;
    }
}

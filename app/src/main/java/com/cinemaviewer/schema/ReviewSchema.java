package com.cinemaviewer.schema;

public class ReviewSchema {
    public String author;
    public String date;
    public String comment;

    public ReviewSchema(String author, String date, String comment) {
        this.author = author;
        this.date = date;
        this.comment = comment;
    }
}
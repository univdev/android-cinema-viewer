package com.cinemaviewer.schema;

public class MovieSchema {
    public int thumbnail;
    public String title;
    public String description;
    public float score;

    public MovieSchema() {
        super();
    }

    public MovieSchema(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public MovieSchema(int thumbnail, String title, String description) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
    }

    public MovieSchema(int thumbnail, String title, String description, float score) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
        this.score = score;
    }
}

package com.example.adnan.habittracker;

/**
 * Created by Adnan on 8/22/2016.
 */
public class Habits {
    String title,Description;
    int id;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Habits(String title, String description) {

        this.title = title;
        Description = description;
    }

    public Habits(String title, String description, int id) {

        this.title = title;
        Description = description;
        this.id = id;
    }
}

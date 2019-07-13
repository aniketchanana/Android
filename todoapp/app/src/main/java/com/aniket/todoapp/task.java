package com.aniket.todoapp;

import android.widget.TextView;

public class task {
    public String description;
    public String title;
    public String id;
    public task(String des,String title,String id)
    {
        description = des;
        this.title = title;
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public task(){

    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
}

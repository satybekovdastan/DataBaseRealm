package com.example.az.database;

import io.realm.RealmObject;

public class Student extends RealmObject{

    String name;
    int course;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }
}

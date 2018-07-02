package com.example.az.database;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

public class RealmManager {

    public static RealmManager instance = null;

    public static RealmManager getInstance(){
        RealmManager localInstance = instance;

        if (localInstance == null){
            synchronized (RealmManager.class){
                localInstance = instance;
                if (localInstance==null)
                    instance = localInstance = new RealmManager();
            }
        }

        return localInstance;
    }

    public void addStudent(String name, int course){
        Realm realm = Realm.getDefaultInstance();
        realm.beginTransaction();

        List<Student> list = new ArrayList<>();
        Student student = new Student();
        student.setName(name);
        student.setCourse(course);
        list.add(student);

        Realm.getDefaultInstance().copyToRealmOrUpdate(list);
        realm.commitTransaction();
        realm.close();
    }

}

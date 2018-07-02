package com.example.az.database;

import io.realm.RealmObject;

public class Predmet extends RealmObject{
    String predmetName;

    public void setPredmetName(String predmetName) {
        this.predmetName = predmetName;
    }

    public String getPredmetName() {
        return predmetName;
    }
}

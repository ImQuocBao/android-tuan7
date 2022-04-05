package com.example.android_week7;

public class Student {
    private int _id;
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public Student(int _id, String name) {
        this._id = _id;
        this.name = name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

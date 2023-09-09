package com.example.fbaseapplication;

public class MainModel {
    String name,email,courses,turl;
MainModel(){

}
    public MainModel(String name, String email, String courses, String turl) {
        this.name = name;
        this.email = email;
        this.courses = courses;
        this.turl = turl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getTurl() {
        return turl;
    }

    public void setTurl(String turl) {
        this.turl = turl;
    }
}

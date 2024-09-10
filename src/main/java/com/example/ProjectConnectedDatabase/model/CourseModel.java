package com.example.ProjectConnectedDatabase.model;

public class CourseModel {

    private int course_id;
    private String nazev;
    private String popis;

    public void Course() {
    }


    public void Course(int course_id, String nazev, String popis) {
        this.course_id = course_id;
        this.nazev = nazev;
        this.popis = popis;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourseID(int course_id) {
        this.course_id = course_id;
    }

    public String getName() {
        return nazev;
    }


    public void setName(String nazev) {
        this.nazev = nazev;
    }


    public String getDescription() {
        return popis;
    }

    public void setDescription(String popis) {
        this.popis = popis;
    }

    @Override
    public String toString() {
        return "Course{" +
                "course ID=" + getCourse_id() +
                ", description='" + getName() + '\'' +
                ", name ='" + getDescription() + '\'' +
                '}';
    }



}

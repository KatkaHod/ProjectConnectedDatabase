package com.example.ProjectConnectedDatabase.Database;

public class School {

    //table courses
    public static final String COURSE_ID = "course_id";
    public static final String NAZEV = "nazev";
    public static final String POPISEK = "popisek";

    //table students
    public static final String STUDENT_ID = "student_id";
    public static final String JMENO = "jmeno";
    public static final String PRIJMENI = "prijmeni";

    //table zapis

    public static final String ZAPIS_ID = "zapis_id";
    public static final String ZAPIS_STUDENT_ID = "zapis_student_id";
    public static final String ZAPIS_COURSE_ID = "zapis_course_id";
    public static final String DATUM_ZAPISU = "datum_zapisu";
}

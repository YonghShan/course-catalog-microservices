package com.yonghshan.services.newcoursecatalog;

import java.math.BigInteger;

/**
 * @author YonghShan
 * @date 4/4/21 - 22:15
 */


public class Course {

    private BigInteger courseid;
    private String coursename;
    private String author;

    public Course() {
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getCoursename() {
        return coursename;
    }

    public void setCoursename(String coursename) {
        this.coursename = coursename;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}


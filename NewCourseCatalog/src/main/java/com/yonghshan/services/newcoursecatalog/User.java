package com.yonghshan.services.newcoursecatalog;

import java.math.BigInteger;

/**
 * @author YonghShan
 * @date 4/12/21 - 16:50
 */


public class User {

    private BigInteger userid;
    private BigInteger courseid;
    private String username;

    public User() {
    }

    public BigInteger getUserid() {
        return userid;
    }

    public void setUserid(BigInteger userid) {
        this.userid = userid;
    }

    public BigInteger getCourseid() {
        return courseid;
    }

    public void setCourseid(BigInteger courseid) {
        this.courseid = courseid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

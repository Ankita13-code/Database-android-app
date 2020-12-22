package com.example.android.studentapp.Model;

public class StudentModel {
    String name, enrollNo, branch, bhawan, phoneNo;

    public StudentModel() {
        //empty constructor
    }

    public StudentModel(String name, String enrollNo, String branch, String bhawan, String phoneNo) {
        this.name = name;
        this.enrollNo = enrollNo;
        this.branch = branch;
        this.bhawan = bhawan;
        this.phoneNo = phoneNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEnrollNo() {
        return enrollNo;
    }

    public void setEnrollNo(String enrollNo) {
        this.enrollNo = enrollNo;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getBhawan() {
        return bhawan;
    }

    public void setBhawan(String bhawan) {
        this.bhawan = bhawan;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }


}

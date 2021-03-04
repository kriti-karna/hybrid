package com.kriti.student;

public class Student {
    private String name ;
    private String usn ;
    private String password;
    private Integer admin;

    public Student() {
    }

    public Student(String name, String usn, String password, Integer admin) {
        this.name = name;
        this.usn = usn;
        this.password = password;
        this.admin = admin;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAdmin() {
        return admin;
    }

    public void setAdmin(Integer admin) {
        this.admin = admin;
    }
}

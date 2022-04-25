package com.atguigu.mybatis.pojo;

public class Emp {

    private Integer eid;
    private String ename;
    private String email;
    private Integer age;
    private Dept dept;

    public Emp() {
    }

    public Emp(Integer eid, String ename, String email, Integer age, Dept dept) {
        this.eid = eid;
        this.ename = ename;
        this.email = email;
        this.age = age;
        this.dept = dept;
    }

    public Integer getEid() {
        return eid;
    }

    public void setEid(Integer eid) {
        this.eid = eid;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Dept getDept() {
        return dept;
    }

    public void setDept(Dept dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", dept=" + dept +
                '}';
    }
}

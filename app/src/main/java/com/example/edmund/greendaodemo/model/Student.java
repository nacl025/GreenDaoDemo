package com.example.edmund.greendaodemo.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Student {
    @Id
    private Long id;
    private String name;
    private int age;
    private String num;
    private String grate = "0";
    private Integer grate2 = -1;
    private int grate3 = 0;
    @Generated(hash = 1592715475)
    public Student(Long id, String name, int age, String num, String grate,
            Integer grate2, int grate3) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.num = num;
        this.grate = grate;
        this.grate2 = grate2;
        this.grate3 = grate3;
    }
    @Generated(hash = 1556870573)
    public Student() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return this.name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return this.age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getNum() {
        return this.num;
    }
    public void setNum(String num) {
        this.num = num;
    }
    public String getGrate() {
        return this.grate;
    }
    public void setGrate(String grate) {
        this.grate = grate;
    }
    public int getGrate2() {
        return this.grate2;
    }
    public void setGrate2(int grate2) {
        this.grate2 = grate2;
    }
    public void setGrate2(Integer grate2) {
        this.grate2 = grate2;
    }
    public int getGrate3() {
        return this.grate3;
    }
    public void setGrate3(int grate3) {
        this.grate3 = grate3;
    }
}

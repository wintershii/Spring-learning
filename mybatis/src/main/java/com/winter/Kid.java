package com.winter;

import java.util.Date;

public class Kid {
    private Integer id;
    private String name;
    private String num;
    private Date birthDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", num='" + num + '\'' +
                ", birthDate=" + birthDate +
                '}';
    }
}

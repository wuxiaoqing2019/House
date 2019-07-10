package com.kgc.util;

public class UserCondition extends Page{
    private String name;
    private String telephone;
    private Integer startAge;
    private Integer endAge;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getStartAge() {
        return startAge;
    }

    public void setStartAge(Integer startAge) {
        this.startAge = startAge;
    }

    public Integer getEndAge() {
        return endAge;
    }

    public void setEndAge(Integer endAge) {
        this.endAge = endAge;
    }

    @Override
    public String toString() {
        return "UserCondition{" +
                "name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                ", startAge=" + startAge +
                ", endAge=" + endAge +
                '}';
    }
}

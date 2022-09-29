package com.example.springredis.entity;

public class User {
    private Integer id;

    private String name;

    private Integer age;

    private String power;

    public User(Integer id, String name, Integer age, String power) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", power='" + power + '\'' +
                '}';
    }
}

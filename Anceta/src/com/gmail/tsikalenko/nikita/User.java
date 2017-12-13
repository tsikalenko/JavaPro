package com.gmail.tsikalenko.nikita;

public class User {
    private String login;
    private int age;
    private String sex;
    private String answer;

    public User(String login, int age, String sex, String answer) {
        this.login = login;
        this.age = age;
        this.sex = sex;
        this.answer = answer;
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "User{" +
                "login='" + login + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}

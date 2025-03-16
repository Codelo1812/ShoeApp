package com.example.nhom10;

import java.io.Serializable;

public class User implements Serializable {
    private String userName;
    private String passWord;
    private String email;
    private String phoneNumber;
    private int sex;
    String id;
    String name;
    String avatar;
    String price;
    public User(String id,String name,String avatar,String price,String userName, String passWord, String email, String phoneNumber, int sex){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.price = price;
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.sex = sex;
    }
    public String getId(){
        return id;
    }
    public void setId(String id){
        this.id=id;
    }
    public String getPrice(){
        return price;
    }
    public void setPrice(String price){
        this.price=price;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getAvatar(){
        return avatar;
    }
    public void setAvatar(String avatar){
        this.avatar=avatar;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return passWord;
    }
    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public int getSex() {
        return sex;
    }
    public void setSex(int sex) {
        this.sex = sex;
    }
}




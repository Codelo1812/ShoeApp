package com.example.nhom10;

public class User {
    String id;
    String name;
    String avatar;
    String price;
    public User(String id,String name,String avatar,String price){
        this.id = id;
        this.name = name;
        this.avatar = avatar;
        this.price = price;
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
}

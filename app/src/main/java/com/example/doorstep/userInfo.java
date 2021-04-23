package com.example.doorstep;

public class userInfo {
    public String name;
    public String surname;
    public String phone_num;

    public userInfo(){
    }

    public userInfo(String name,String surname, String phone_num){
        this.name = name;
        this.surname = surname;
        this.phone_num = phone_num;
    }
    public String getUserName() {
        return name;
    }
    public String getUserSurname() {
        return surname;
    }
    public String getUserPhoneNum() {
        return phone_num;
    }
}

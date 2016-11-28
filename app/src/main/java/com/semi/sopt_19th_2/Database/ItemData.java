package com.semi.sopt_19th_2.Database;

/**
 * Created by hyejin on 2016-11-27.
 */
public class ItemData {

    public int ID;
    public String id;
    public String name;
    public String major;
    public String gender;

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String pwd;
    public String img;

    public String getImg() {return img;}

    public int getID() {
        return ID;
    }

    public String getId() {
        return id;
    }

    public String getMajor() {
        return major;
    }

    public String getGender() {
        return gender;
    }

    public String getPwd() {
        return pwd;
    }

    public String getName() {
        return name;
    }
}

package com.baway.project.historyday.dbutils;

/**
 * Created by 张瑞凯 on 2017/3/26.
 */
public class DBBean {
    String date;
    String title;
    String picurl;
    String E_id;
    int flag;

    public DBBean(String date, String title, String picurl,String E_id) {
        this.date = date;
        this.title = title;
        this.picurl = picurl;
        this.E_id=E_id;
        this.flag=flag;
    }



    public String getE_id() {
        return E_id;
    }

    public void setE_id(String e_id) {
        E_id = e_id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicurl() {
        return picurl;
    }

    public void setPicurl(String picurl) {
        this.picurl = picurl;
    }
}

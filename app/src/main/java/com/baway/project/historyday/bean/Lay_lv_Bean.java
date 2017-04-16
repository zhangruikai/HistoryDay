package com.baway.project.historyday.bean;

/**
 * Created by 张瑞凯 on 2017/3/17.
 */
public class Lay_lv_Bean {

    private int img;
    private String name;

    public Lay_lv_Bean(int img, String name) {
        this.img = img;
        this.name = name;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

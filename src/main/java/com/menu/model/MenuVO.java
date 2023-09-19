package com.menu.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuVO {

    private int mid;
    private String code;
    private String codename;
    private int sort_num;
    private String comment;
    private String reg_id;
    private String reg_dt;

    @Override
    public String toString() {
        return "MenuVO{" +
                "mid=" + mid +
                ", code='" + code + '\'' +
                ", codename='" + codename + '\'' +
                ", sort_num=" + sort_num +
                ", comment='" + comment + '\'' +
                ", reg_id='" + reg_id + '\'' +
                ", reg_dt='" + reg_dt + '\'' +
                '}';
    }
}

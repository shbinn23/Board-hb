package com.myapp.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    String uid;
    String name;
    String pwd;
    String re_pwd;
    String email;
    String grade;
    String reg_dt;
}

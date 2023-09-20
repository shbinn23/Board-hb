package com.myapp.user.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserVO {
    public int user_id;
    public UserRole userrole;
    public String email;
    public String password;
    public String username;
    public boolean is_deleted;

    @Override
    public String toString() {
        return "UserVO{" +
                "user_id=" + user_id +
                ", userrole=" + userrole +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", is_deleted=" + is_deleted +
                '}';
    }
}

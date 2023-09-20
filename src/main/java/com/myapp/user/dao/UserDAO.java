package com.myapp.user.dao;

import com.myapp.user.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    public List<UserVO> getUserList();

}
package com.myapp.user.dao;

import com.myapp.user.model.UserVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserDAO {

    public List<UserVO> getUserList() throws Exception;

    public UserVO getUserInfo(String uid) throws Exception;

    public int insertUser(UserVO userVO) throws Exception;

    public int updateUser(UserVO userVO) throws Exception;

    public int deleteUser(String uid) throws Exception;
}
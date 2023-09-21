package com.myapp.user.service;

import com.myapp.user.model.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<UserVO> getUserList() throws Exception;

    public UserVO getUserInfo(String uid) throws Exception;

    public void insertUser(UserVO userVO) throws Exception;

    public void updateUser(UserVO userVO) throws Exception;

    public void deleteUser(String uid) throws Exception;
}
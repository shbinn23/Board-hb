package com.myapp.user.service;

import com.myapp.user.dao.UserDAO;
import com.myapp.user.model.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserVO> getUserList() throws Exception {
        return userDAO.getUserList();
    }

    @Override
    public UserVO getUserInfo(String uid) throws Exception {
        return userDAO.getUserInfo(uid);
    }

    @Override
    public void insertUser(UserVO userVO) throws Exception {
        userDAO.insertUser(userVO);
    }

    @Override
    public void updateUser(UserVO userVO) throws Exception {
        userDAO.updateUser(userVO);
    }

    @Override
    public void deleteUser(String uid) throws Exception {
        userDAO.deleteUser(uid);
    }
}

package com.myapp.user.service;

import com.myapp.user.dao.UserDAO;
import com.myapp.user.model.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    public List<UserVO> getUserList() {
        return userDAO.getUserList();
    }
}

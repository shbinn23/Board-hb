package com.myapp.user.service;

import com.myapp.user.model.UserVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<UserVO> getUserList();

}

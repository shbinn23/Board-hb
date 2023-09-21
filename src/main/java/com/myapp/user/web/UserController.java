package com.myapp.user.web;

import com.myapp.user.model.UserVO;
import com.myapp.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/getUserList")
    public String getUserList(Model model) throws Exception{

        model.addAttribute("userList", userService.getUserList());
        return "user/userList";
    }

    @PostMapping("/insertUser")
    public String insertUser(@ModelAttribute("userVO") UserVO userVO, RedirectAttributes rttr) throws Exception {

        userService.insertUser(userVO);
        return "redirect:/user/getUserList";
    }

}
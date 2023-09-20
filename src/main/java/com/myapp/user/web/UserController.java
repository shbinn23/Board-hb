package com.myapp.user.web;

import com.myapp.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/getUserList", method = RequestMethod.GET)
    public String getUserList(Model model) throws Exception {
        logger.info("getUserList()....");
        model.addAttribute("userList", userService.getUserList());
        return "user/userList";
    }

//    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
//    public String insertUser(@ModelAttribute("userVO") UserVO userVO, RedirectAttributes rttr) throws Exception {
//        userService.insertUser(userVO);
//        return "redirect:/user/getUserList";
//    }
}
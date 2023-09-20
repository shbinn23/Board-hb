package com.myapp.login.web;

import com.myapp.user.model.UserVO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String loginForm(Model model) throws Exception {
        return "login/login"; // "login"은 tiles.xml에서 정의한 타일 이름입니다.
    }

    @RequestMapping(value = "/signupForm", method = RequestMethod.GET)
    public String signupForm(Model model) throws Exception {
        model.addAttribute("userVO", new UserVO());
        return "login/signupForm";
    }
}


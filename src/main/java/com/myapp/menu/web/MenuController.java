package com.myapp.menu.web;

import com.myapp.menu.model.MenuVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/menu")
public class MenuController {

    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);

    @GetMapping("/getMenuList")
    public String getMenuList(Model model) throws Exception {
        model.addAttribute("menuVO", new MenuVO());
        return "menu/menu";
    }
}

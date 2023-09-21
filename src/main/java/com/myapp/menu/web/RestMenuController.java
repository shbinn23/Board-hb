package com.myapp.menu.web;

import com.myapp.menu.model.MenuVO;
import com.myapp.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/restMenu")
public class RestMenuController {

    private static final Logger logger = LoggerFactory.getLogger(RestMenuController.class);

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
    public Map<String, Object> getMenuList() throws Exception {
        Map<String, Object> result = new HashMap<String, Object>();

        try {
            result.put("menuList", menuService.getMenuList());
            result.put("status", "OK");
        } catch (Exception e) {
            result.put("status",  "False");
            logger.info(e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/saveMenu", method = RequestMethod.POST)
    public Map<String, Object> saveMenu(MenuVO menuVO) throws Exception	{

        Map<String, Object> result = new HashMap<String, Object>();

        logger.info("menuVO : " + menuVO.toString());

        try {
            menuService.saveMenu(menuVO);
            result.put("status",  "OK");
        } catch (Exception e) {
            result.put("status",  "False");
            logger.info(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/updateMenu", method = RequestMethod.POST)
    public Map<String, Object> updateMenu(MenuVO menuVO) throws Exception {
        Map<String, Object> result = new HashMap<>();

        try {
            menuService.updateMenu(menuVO);
            result.put("status", "OK");
        } catch (Exception e) {
            result.put("status",  "False");
            logger.info(e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/deleteMenu", method = RequestMethod.POST)
    public Map<String, Object> deleteMenu(@RequestParam("code") String code) throws Exception {
        Map<String, Object> result = new HashMap<>();

        try {
            menuService.deleteMenu(code);
            result.put("status", "OK");
        } catch (Exception e) {
            result.put("status",  "False");
            logger.info(e.getMessage());
        }

        return result;
    }
}

package com.myapp.menu.service;

import com.myapp.menu.dao.MenuDAO;
import com.myapp.menu.model.MenuVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class menuServiceImpl implements menuService {

    @Autowired
    private MenuDAO menuDAO;

    @Override
    public List<MenuVO> getMenuList() {
        return menuDAO.getMenuList();
    }

    @Override
    public void saveMenu(MenuVO menuVO) {
        menuDAO.saveMenu(menuVO);
    }

    @Override
    public void updateMenu(MenuVO menuVO) {
        menuDAO.updateMenu(menuVO);
    }

    @Override
    public void deleteMenu(String code) {
        menuDAO.deleteMenu(code);
    }
}

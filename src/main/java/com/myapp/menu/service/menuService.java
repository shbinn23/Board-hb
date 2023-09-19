package com.myapp.menu.service;

import com.myapp.menu.model.MenuVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface menuService {

    public List<MenuVO> getMenuList();

    public void saveMenu(MenuVO menuVO);

    public void updateMenu(MenuVO menuVO);

    public void deleteMenu(String code);

}

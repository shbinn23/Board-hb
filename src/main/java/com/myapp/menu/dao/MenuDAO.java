package com.myapp.menu.dao;

import com.myapp.menu.model.MenuVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MenuDAO {

    public List<MenuVO> getMenuList();

    public int saveMenu(MenuVO menuVO);

    public int updateMenu(MenuVO menuVO);

    public int deleteMenu(String code);

}
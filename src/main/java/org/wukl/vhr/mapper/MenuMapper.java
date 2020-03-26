package org.wukl.vhr.mapper;

import org.wukl.vhr.model.Hr;
import org.wukl.vhr.model.Menu;

import java.util.List;

public interface MenuMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Menu record);

    int insertSelective(Menu record);

    Menu selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Menu record);

    int updateByPrimaryKey(Menu record);
    List<Menu> getMenuByHrId(Integer hrId);
    List<Menu> getMenuInfoByRole();
}
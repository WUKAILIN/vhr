package org.wukl.vhr.mapper;

import org.wukl.vhr.model.Hr;
import org.wukl.vhr.model.Role;

import java.util.List;

public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);
    Hr loadUserByUsername(String username);
    List<Role> getRolesByHrId(Integer id);
}
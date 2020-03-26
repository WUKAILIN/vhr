package org.wukl.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.wukl.vhr.mapper.MenuMapper;
import org.wukl.vhr.model.Hr;
import org.wukl.vhr.model.Menu;

import java.util.List;

@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;
    public List<Menu> getMenuByHrId()
    {
        /**
         * 从SpringSecurity中获取当前登录用户，根据当前登录用户获取用户Id
         * SecurityContextHolder.getContext()
         * .getAuthentication().getPrincipal():从SpringSecurity中获取当前登录用户对象
         */

        return menuMapper.getMenuByHrId(((Hr) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal()).getId());
    }

    /**
     * 根据当前登录用户角色标识获取角色所有可访问菜单项
     * @return 角色菜单集合
     */
    public List<Menu> getMenuInfoByRole()
    {
       return menuMapper.getMenuInfoByRole();
    }
}

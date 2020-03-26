package org.wukl.vhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.wukl.vhr.model.Menu;
import org.wukl.vhr.model.Role;
import org.wukl.vhr.service.MenuService;

import java.util.Collection;
import java.util.List;

/**
 * 根据请求url地址，对用户访问权限接口需要的角色进行控制
 */
@Component
public class CustomUrlFilterConfig implements FilterInvocationSecurityMetadataSource {
    @Autowired
    private MenuService menuServicel;
    AntPathMatcher pathMatcher=new AntPathMatcher();
    /**
     *
     * @param obj
     * @return
     * @throws IllegalArgumentException
     */
    @Override
    public Collection<ConfigAttribute> getAttributes(Object obj) throws IllegalArgumentException {
        //获取当前登录用户操作接口请求地址
        String requestUrl=((FilterInvocation) obj).getRequestUrl();
        //根据角色查询对应的权限树菜单
        List<Menu> menuList=menuServicel.getMenuInfoByRole();
        for(Menu menu:menuList)
        {
            //对树形菜单中的数据和操作接口请求地址进行匹配，匹配上获取菜单对应角色信息
            if(pathMatcher.match(menu.getUrl(),requestUrl))
            {
                List<Role> roles=menu.getMenuRoles();
                String[] rolesStr=new String[roles.size()];
                //将角色集合信息转化为字符串
                for(int i=0;i<roles.size();i++)
                {
                    rolesStr[i]=roles.get(i).getName();
                }
                return SecurityConfig.createList(rolesStr);
            }
        }
        return SecurityConfig.createList("ROLE_LOGIN");
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

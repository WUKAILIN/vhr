package org.wukl.vhr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collection;
@Component
public class CustomUrlDecisionManager implements AccessDecisionManager {
    @Override
    public void decide(Authentication authentication, Object obj, Collection<ConfigAttribute> collection) throws AccessDeniedException, InsufficientAuthenticationException {
        for(ConfigAttribute attribute:collection)
        {
            //获取登录用户角色名称
            String loginRole=attribute.getAttribute();
            if("ROLE_LOGIN".equals(loginRole))
            {
                //未登录用户请求操作
                if(authentication instanceof AnonymousAuthenticationToken)
                {
                    throw new AccessDeniedException("尚未登录，请执行登录操作");
                }
                else
                {
                    return;
                }
            }
            //获取角色集合信息
           Collection<? extends GrantedAuthority> authorities=authentication.getAuthorities();
            for(GrantedAuthority authority:authorities)
            {
                //集合元素与登录用户角色匹配成功
                if(authority.getAuthority().equals(loginRole))
                {
                    return ;
                }
            }
         }
        throw new AccessDeniedException("权限不足，请联系管理员");
    }

    @Override
    public boolean supports(ConfigAttribute configAttribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}

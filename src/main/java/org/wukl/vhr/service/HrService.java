package org.wukl.vhr.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.wukl.vhr.mapper.HrMapper;
import org.wukl.vhr.model.Hr;

@Service
public class HrService implements UserDetailsService {
    @Autowired
    HrMapper hrMapper;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
       Hr hr=hrMapper.loadUserByUsername(username);
       if(hr==null)
       {
           throw new UsernameNotFoundException("用户名不存在");
       }
       hr.setRoles(hrMapper.getRolesByHrId(hr.getId()));
        return hr;
    }
}

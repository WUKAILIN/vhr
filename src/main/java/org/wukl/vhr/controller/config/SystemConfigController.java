package org.wukl.vhr.controller.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wukl.vhr.model.Menu;
import org.wukl.vhr.service.MenuService;

import java.util.List;

@RestController
@RequestMapping("/system/menuConfig")
public class SystemConfigController {
   @Autowired
    MenuService menuService;
    @RequestMapping("/initMenu")
    public List<Menu> getMenuByHrId()
    {
        return menuService.getMenuByHrId();
    }
}

package org.wukl.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wukl.vhr.model.ResponseBean;

@RestController
public class LoginController {
@GetMapping("/login")
    public ResponseBean getLoginMessage()
    {
        return ResponseBean.responseError("匿名用户非法访问，请登录");
    }
}

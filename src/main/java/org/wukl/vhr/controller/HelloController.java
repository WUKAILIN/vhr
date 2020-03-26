package org.wukl.vhr.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getMessage()
    {
        return "hello Message";
    }

    /**
     * 请求路径须与menu表url(/emp/basic/**)字段信息一致
     *  **表示/emp/basic下的所有请求路径接口
     * @return
     */
    @GetMapping("/emp/basic/getBasicMessage")
    public String getEmpBasicMessage()
    {
        return "/emp/basic/getBasicMessage";
    }
    /**
     * 请求路径须与menu表url(/emp/advanced/**)字段信息一致
     *  **表示/emp/advanced下的所有请求路径接口
     * @return
     */
    @GetMapping("/emp/advanced/getAdvancedMessage")
    public String getEmpAdvancedMessage()
    {
        return "/emp/advanced/getAdvancedMessage";
    }
}

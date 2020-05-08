package com.ts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName ProviderController
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 20:45
 * @Params TODO
 */
@RestController
public class ProviderController {

    /*
     *
     * @Author linky
     * @Description 方法描述: 服务提供者
     * @Date  2020/5/7 20:46
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/provider/service")
    public String providerService(){
        return "provider service";
    }

}

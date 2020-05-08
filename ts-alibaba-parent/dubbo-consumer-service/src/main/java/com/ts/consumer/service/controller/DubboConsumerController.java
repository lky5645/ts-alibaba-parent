package com.ts.consumer.service.controller;

import com.ts.dubbo.service.api.DubboProviderServiceApi;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName DubboConsumerController
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 23:21
 * @Params TODO
 */
@RestController
public class DubboConsumerController {
    @Reference
    private DubboProviderServiceApi dubboProviderServiceApi;

    /*
     *
     * @Author linky
     * @Description 方法描述: 使用dubbo调用接口
     * @Date  2020/5/7 23:33
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/consumer/dubbo/getService")
    public String getService() {
        String result = dubboProviderServiceApi.getServiceApi();
        return "dubbo consumer || " + result + " || success";
    }

}

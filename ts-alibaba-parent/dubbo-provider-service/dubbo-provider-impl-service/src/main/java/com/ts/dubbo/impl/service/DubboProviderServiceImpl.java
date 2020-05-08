package com.ts.dubbo.impl.service;

import com.ts.dubbo.service.api.DubboProviderServiceApi;
import org.apache.dubbo.config.annotation.Service;

/**
 * @ClassName DubboProviderServiceImpl
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 22:15
 * @Params TODO
 */
@Service
public class DubboProviderServiceImpl implements DubboProviderServiceApi {
    @Override
    public String getServiceApi() {
        return "dubbo provider service";
    }
}

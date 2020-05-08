package com.ts.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

/**
 * @ClassName ConsumerController
 * @Description TODO
 * @Author 86175
 * @Date 2020/5/7 20:49
 * @Params TODO
 */
@RestController
public class ConsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${service-url}")
    private String serviceUrl;

    //调用的服务名
    private String serviceId = "provider-service";

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/consumer/service")
    public String consumerService() {
        String result = restTemplate.getForObject("http://" + serviceUrl + "/provider/service", String.class);
        return "consumer service || " + result;
    }

    /*
     *
     * @Author linky
     * @Description 方法描述:使用服务调用
     * @Date  2020/5/7 21:10
     * @Param []
     * @return java.lang.String
     **/
    @GetMapping("/consumer/service1")
    public String consumerService1() {
        ServiceInstance choose = loadBalancerClient.choose(serviceId);
        int port = choose.getPort();
        URI uri = choose.getUri();
        String result = restTemplate.getForObject(uri + "/provider/service", String.class);
        return "nacos consumer service || " + result + " || " + port;
    }

}

package com.sykj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 黄泉碧落
 * @date 2020/5/9 17:51
 */
@RestController
@Slf4j
public class ConsulController {
    public static  final String INVOKE_URL="http://consul-provider-payment";

    @Resource
    private RestTemplate restTemplate;

@GetMapping(value = "/consumer/payment/consul")
    public String getPaymentInfo(){
        String result=restTemplate.getForObject(INVOKE_URL+"/payment/consul",String.class);
              return result;
    }


}

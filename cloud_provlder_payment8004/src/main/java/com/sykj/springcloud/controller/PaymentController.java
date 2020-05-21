package com.sykj.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * @author 黄泉碧落
 * @date 2020/5/9 14:25
 */
@RestController
@Slf4j
public class PaymentController {


    @Value("${server.port}")
    private  String serverPort;


    @RequestMapping(value = "/payment/zk")
    public  String paymentzk(){
return "springcloud with zookeeper"+ serverPort+"\t"+ UUID.randomUUID().toString();

    }
}

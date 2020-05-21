package com.sykj.springcloud.controller;

import com.sykj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
public class PaymentController
{
    @Resource
    private PaymentService paymentService;

   @Value("$server.port")
    private String serverPort;

    @GetMapping("/payment/hystrix/ok/{pid}")
    public String paymentInfo_OK(@PathVariable("pid") Integer pid)
    {
        String result = paymentService.paymentInfo_OK(pid);
        log.info("*****result: "+result);
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{pid}")
    public String paymentInfo_TimeOut(@PathVariable("pid") Integer pid)
    {
        String result = paymentService.paymentInfo_TimeOut(pid);
        log.info("*****result: "+result);
        return result;
    }

//服务熔断
    @GetMapping("/payment/circuit/{pid}")
    public String paymentCircuitBreaker_fallback(@PathVariable("pid") Integer pid){
        String result=paymentService.paymentCircuitBreaker(pid);
        log.info("*********result"+result);
        return result;
    }

}

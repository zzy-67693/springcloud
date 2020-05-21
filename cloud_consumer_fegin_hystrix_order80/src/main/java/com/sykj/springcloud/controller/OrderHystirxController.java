package com.sykj.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sykj.springcloud.service.PaymentHystrixService;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@Slf4j
@DefaultProperties(defaultFallback = "paymentGlobalFallbackMethod")
public class OrderHystirxController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/payment/hystrix/ok/{pid}")
    public String paymentInfo_OK(@PathVariable("pid") Integer pid) {
        String result = paymentHystrixService.paymentInfo_OK(pid);
        return result;
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{pid}")
//    @HystrixCommand(fallbackMethod = "paymentTimeOutFallbackMethod",commandProperties = {
//            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="1500")
//    })
    @HystrixCommand
    public String paymentInfo_TimeOut(@PathVariable("pid") Integer pid)
    {
        int age = 10/0;
        String result = paymentHystrixService.paymentInfo_TimeOut(pid);
        return result;
    }
    public String paymentTimeOutFallbackMethod(@PathVariable("pid") Integer pid)
    {
        return "我是消费者80,对方支付系统繁忙请10秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o";
    }

    /**
     * 全局的falback方法
     * @return
     */
    public String paymentGlobalFallbackMethod()
    {
        return "Globa异常,,o(╥﹏╥)o";
    }

}

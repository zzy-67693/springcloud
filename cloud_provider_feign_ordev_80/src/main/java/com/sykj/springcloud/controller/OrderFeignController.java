package com.sykj.springcloud.controller;

import com.sykj.springcloud.entities.CommonResult;
import com.sykj.springcloud.entities.Payment;
import com.sykj.springcloud.service.PaymentFeignService;
import javafx.beans.DefaultProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author 黄泉碧落
 * @date 2020/5/10 16:25
 */
@RestController
@Slf4j
public class OrderFeignController {
    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping("/consumer/payment/get/{pid}")
 public CommonResult<Payment>getPaymentBYid(@PathVariable("pid") Integer pid){

        return paymentFeignService.getPaymentByid(pid);
    }




}

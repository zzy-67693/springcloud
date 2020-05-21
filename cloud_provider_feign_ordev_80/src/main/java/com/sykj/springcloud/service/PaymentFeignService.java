package com.sykj.springcloud.service;

import com.sykj.springcloud.entities.CommonResult;
import com.sykj.springcloud.entities.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    @GetMapping("/payment/get/{pid}")
    public CommonResult<Payment> getPaymentByid(@PathVariable("pid") Integer pid) ;
}

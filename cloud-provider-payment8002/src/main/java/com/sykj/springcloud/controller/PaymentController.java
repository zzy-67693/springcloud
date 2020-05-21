package com.sykj.springcloud.controller;

import com.sykj.springcloud.entities.CommonResult;
import com.sykj.springcloud.entities.Payment;
import com.sykj.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 14:26
 */
@RestController
@Slf4j
public class PaymentController {
        @Resource
    private PaymentService paymentService;
        @Value("${server.port}")
        private  String serverPort;

        @PostMapping(value ="/payment/create")
        public CommonResult create(@RequestBody Payment payment){
        int result=paymentService.create(payment);
        log.info("***************插入结果"+result);
        if (result >0){
            return  new CommonResult(200,"插入数据库成功  serverPort:"+serverPort,result);
        }
            return new CommonResult(444, "插入数据库失败", null);


    }

    @GetMapping("/payment/get/{pid}")
    public CommonResult getPaymentByid(@PathVariable("pid")Integer pid){
        Payment payment=paymentService.getPaymentByid(pid);
        log.info("***************插入结果"+payment);
        if (payment !=null){
            return  new CommonResult(200,"查询成功   serverPort:"+serverPort,payment);
        }
            return new CommonResult(444, "没有对应记录", null);

    }

    @GetMapping(value = "/payment/lb")
    public  String getPaymentLB(){
        return serverPort;
    }



}

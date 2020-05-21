package com.sykj.springcloud.service.impl;

import com.sykj.springcloud.dao.PayDao;
import com.sykj.springcloud.entities.Payment;
import com.sykj.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 黄泉碧落
 * @date 2020/5/7 14:20
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private  PayDao payDao;



    public int create(Payment payment){
        return payDao.create(payment);
    }


    public Payment getPaymentByid(Integer pid){

        return payDao.getPaymentByid(pid);
    }

}

package com.sykj.springcloud.service;

        import com.sykj.springcloud.entities.Payment;
        import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int create(Payment payment);


    public Payment getPaymentByid(@Param("pid") Integer pid);
}

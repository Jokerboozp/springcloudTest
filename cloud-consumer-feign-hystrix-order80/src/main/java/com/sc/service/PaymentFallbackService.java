package com.sc.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentIfo_ok(Integer id) {
        return "-------PaymentFallbackService fall back-paymentIfo_ok";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-------PaymentFallbackService fall back-paymentInfo_timeout";
    }
}

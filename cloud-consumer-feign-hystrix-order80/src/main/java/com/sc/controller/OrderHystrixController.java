package com.sc.controller;

import cn.hutool.Hutool;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.sc.service.PaymentHystrixService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Random;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_Fallbackmethod")
public class OrderHystrixController {

    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping(value = "/consumer/payment/hystrix/ok/{id}")
    public String paymentIfo_ok(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentIfo_ok(id);
        return result;
    }

    @GetMapping(value = "/consumer/payment/hystrix/timeout/{id}")
    /*@HystrixCommand(fallbackMethod = "paymenttimeoutFallBackMethod",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1500")
    })*/
    @HystrixCommand
    public String paymentInfo_timeout(@PathVariable("id") Integer id){
        String result = paymentHystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymenttimeoutFallBackMethod(@PathVariable("id") Integer id){
        return "我是消费者80，对方支付系统繁忙，请稍后再试";
    }

    public String payment_Global_Fallbackmethod(){
        return "全局降级服务生效，请稍后再试";
    }
}

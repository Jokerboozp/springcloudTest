package com.sc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @auther zzyy
 * @create 2019-12-12 17:31
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@EnableFeignClients
@MapperScan("com.sc.dao")
public class SeataStorageServiceApplication2002
{
    public static void main(String[] args)
    {
        SpringApplication.run(SeataStorageServiceApplication2002.class, args);
    }
}

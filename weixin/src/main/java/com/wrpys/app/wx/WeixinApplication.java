package com.wrpys.app.wx;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wrp
 * @Date 2017/11/7
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.wrpys.app.wx.dao"})
@EnableTransactionManagement
public class WeixinApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeixinApplication.class, args);
    }

}

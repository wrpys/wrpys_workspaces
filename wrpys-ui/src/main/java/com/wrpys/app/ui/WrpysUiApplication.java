package com.wrpys.app.ui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wrp
 * @Date 2017/12/01
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan(basePackages = {"com.wrpys.app.**.dao"})
@EnableTransactionManagement
public class WrpysUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrpysUiApplication.class, args);
    }

}

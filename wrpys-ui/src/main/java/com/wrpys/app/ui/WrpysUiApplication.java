package com.wrpys.app.ui;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author wrp
 * @Date 2017/12/01
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.wrpys.app.ui.dao"})
@EnableTransactionManagement
public class WrpysUiApplication {

    public static void main(String[] args) {
        SpringApplication.run(WrpysUiApplication.class, args);
    }

}

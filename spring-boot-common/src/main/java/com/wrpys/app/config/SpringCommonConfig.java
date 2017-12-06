package com.wrpys.app.config;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wrp
 * @Date 2017/10/30
 */
@Configuration
public class SpringCommonConfig {

    /**
     * 配置a:以json请求后台，多字段不会报错 b:后端空对象以 {} 返回
     * 使用方式：在各自微服务使用@Import(com.newland.taas.sbcommon.config.SpringConfig.class)导入配置
     * @return
     */
    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);// 属性为null时不转为json
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);// 属性为空对象以 {} 返回
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);// 以json请求后台，多字段不会报错
        return objectMapper;
    }

}

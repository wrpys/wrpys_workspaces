package com.wrpys.app.wx.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2017/11/7.
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${profiles.active}")
    private String profilesActive;

    @GetMapping("getData")
    public String getData() {
        return "ok," + profilesActive;
    }

}

package com.wrpys.app.ui.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wrp
 * @Date 2017/12/01
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

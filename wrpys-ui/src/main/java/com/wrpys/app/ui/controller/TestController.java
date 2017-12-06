package com.wrpys.app.ui.controller;

import com.wrpys.app.ui.service.TextMessageService;
import com.wrpys.app.wx.model.ReqTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wrp
 * @Date 2017/12/01
 */
@RestController
@RequestMapping("test")
public class TestController {

    @Value("${profiles.active}")
    private String profilesActive;

    @Autowired
    private TextMessageService textMessageService;

    @GetMapping("getData")
    public String getData() {
        return "ok," + profilesActive;
    }

    @GetMapping("findReqTextMessage")
    public List<ReqTextMessage> findReqTextMessage() {
        ReqTextMessage reqTextMessage = new ReqTextMessage();
        reqTextMessage.setFromUserName("owug5t3EYRqfV5uAnO3B6pOdKISI");
        return textMessageService.findTextMessage(reqTextMessage);
    }

}

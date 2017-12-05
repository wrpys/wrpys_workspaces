package com.wrpys.app.ui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wrp
 * @Date 2017/12/1
 */
@Controller
@RequestMapping("index")
public class IndexController {

    @RequestMapping
    public String toIndex() {
        return "index/index";
    }

}

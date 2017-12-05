package com.wrpys.app.wx.service;

import java.util.Map;

/**
 * @author wrp
 * @Description 请求消息处理
 * @Date 2017/12/5
 */
public interface MessageHandleService {

    String handle(Map<String, String> reqMsg);

}

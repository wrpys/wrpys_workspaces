package com.wrpys.app.wx.service;

import javax.servlet.http.HttpServletRequest;

/**
 * @author wrp
 * @Description 微信主业务
 * @Date 2017/11/29
 */
public interface CoreService {

    String processRequest(HttpServletRequest request);

}

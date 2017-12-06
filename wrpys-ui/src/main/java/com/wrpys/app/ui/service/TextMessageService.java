package com.wrpys.app.ui.service;

import com.wrpys.app.common.PageBean;
import com.wrpys.app.vo.PageParamBean;
import com.wrpys.app.wx.model.ReqTextMessage;

import java.util.List;

/**
 * @author wrp
 * @Description 文本消息管理
 * @Date 2017/12/6
 */
public interface TextMessageService {

    PageBean findTextMessage(PageParamBean<ReqTextMessage> pageParam);

}

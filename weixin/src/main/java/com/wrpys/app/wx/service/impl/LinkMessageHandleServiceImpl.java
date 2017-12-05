package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.dao.ReqLinkMessageDao;
import com.wrpys.app.wx.dao.ReqLocationMessageDao;
import com.wrpys.app.wx.model.ReqLinkMessage;
import com.wrpys.app.wx.model.ReqLocationMessage;
import com.wrpys.app.wx.model.resp.TextMessage;
import com.wrpys.app.wx.service.MessageHandleService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wrp
 * @Description 请求消息处理 链接
 * @Date 2017/12/5
 */
@Service("linkMessageHandleService")
public class LinkMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(LinkMessageHandleServiceImpl.class);

    @Autowired
    private ReqLinkMessageDao reqLinkMessageDao;

    @Override
    public String handle(Map<String, String> reqMsg) {
        ReqLinkMessage reqLinkMessage = new ReqLinkMessage();
        MessageUtil.mapToObject(reqMsg, reqLinkMessage);
        log.info("reqLinkMessage:" + JSON.toJSONString(reqLinkMessage));
        reqLinkMessageDao.insert(reqLinkMessage);

        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(reqLinkMessage.getToUserName());
        textMessage.setToUserName(reqLinkMessage.getFromUserName());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        StringBuffer sb = new StringBuffer("您发送的是链接消息");
        textMessage.setContent(sb.toString());
        return MessageUtil.textMessageToXml(textMessage);
    }
}

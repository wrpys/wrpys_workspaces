package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.dao.ReqImageMessageDao;
import com.wrpys.app.wx.model.ReqImageMessage;
import com.wrpys.app.wx.model.resp.BaseMessage;
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
 * @Description 请求消息处理 图片
 * @Date 2017/12/5
 */
@Service("imageMessageHandleService")
public class ImageMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(ImageMessageHandleServiceImpl.class);

    @Autowired
    private ReqImageMessageDao reqImageMessageDao;

    @Override
    public String handle(Map<String, String> reqMsg) {
        ReqImageMessage reqImageMessage = new ReqImageMessage();
        MessageUtil.mapToObject(reqMsg, reqImageMessage);
        log.info("reqImageMessage:" + JSON.toJSONString(reqImageMessage));
        reqImageMessageDao.insert(reqImageMessage);

        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(reqImageMessage.getToUserName());
        textMessage.setToUserName(reqImageMessage.getFromUserName());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        StringBuffer sb = new StringBuffer("您发送的是图片消息");
        textMessage.setContent(sb.toString());
        return MessageUtil.textMessageToXml(textMessage);
    }
}

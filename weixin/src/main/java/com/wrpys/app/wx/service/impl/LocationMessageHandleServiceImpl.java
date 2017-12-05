package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.dao.ReqImageMessageDao;
import com.wrpys.app.wx.dao.ReqLocationMessageDao;
import com.wrpys.app.wx.model.ReqImageMessage;
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
 * @Description 请求消息处理 位置
 * @Date 2017/12/5
 */
@Service("locationMessageHandleService")
public class LocationMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(LocationMessageHandleServiceImpl.class);

    @Autowired
    private ReqLocationMessageDao reqLocationMessageDao;

    @Override
    public String handle(Map<String, String> reqMsg) {
        ReqLocationMessage reqLocationMessage = new ReqLocationMessage();
        MessageUtil.mapToObject(reqMsg, reqLocationMessage);
        log.info("reqLocationMessage:" + JSON.toJSONString(reqLocationMessage));
        reqLocationMessageDao.insert(reqLocationMessage);

        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(reqLocationMessage.getToUserName());
        textMessage.setToUserName(reqLocationMessage.getFromUserName());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        StringBuffer sb = new StringBuffer("您发送的是地理位置消息");
        textMessage.setContent(sb.toString());
        return MessageUtil.textMessageToXml(textMessage);
    }
}

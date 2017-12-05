package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.dao.ReqLinkMessageDao;
import com.wrpys.app.wx.dao.ReqVoiceMessageDao;
import com.wrpys.app.wx.model.ReqLinkMessage;
import com.wrpys.app.wx.model.ReqVoiceMessage;
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
@Service("voiceMessageHandleService")
public class VoiceMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(VoiceMessageHandleServiceImpl.class);

    @Autowired
    private ReqVoiceMessageDao reqVoiceMessageDao;

    @Override
    public String handle(Map<String, String> reqMsg) {
        ReqVoiceMessage reqVoiceMessage = new ReqVoiceMessage();
        MessageUtil.mapToObject(reqMsg, reqVoiceMessage);
        log.info("reqVoiceMessage:" + JSON.toJSONString(reqVoiceMessage));
        reqVoiceMessageDao.insert(reqVoiceMessage);

        TextMessage textMessage = new TextMessage();
        textMessage.setFromUserName(reqVoiceMessage.getToUserName());
        textMessage.setToUserName(reqVoiceMessage.getFromUserName());
        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
        textMessage.setFuncFlag(0);
        StringBuffer sb = new StringBuffer("您发送的是音频消息");
        textMessage.setContent(sb.toString());
        return MessageUtil.textMessageToXml(textMessage);
    }
}

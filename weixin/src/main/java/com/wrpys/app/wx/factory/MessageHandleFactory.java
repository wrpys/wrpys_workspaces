package com.wrpys.app.wx.factory;

import com.wrpys.app.wx.service.MessageHandleService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * @author wrp
 * @Description 消息处理工厂
 * @Date 2017/12/5
 */
@Component
public class MessageHandleFactory {

    @Autowired
    @Qualifier("textMessageHandleService")
    private MessageHandleService textMessageHandleService;

    @Autowired
    @Qualifier("imageMessageHandleService")
    private MessageHandleService imageMessageHandleService;

    @Autowired
    @Qualifier("linkMessageHandleService")
    private MessageHandleService linkMessageHandleService;

    @Autowired
    @Qualifier("locationMessageHandleService")
    private MessageHandleService locationMessageHandleService;

    @Autowired
    @Qualifier("voiceMessageHandleService")
    private MessageHandleService voiceMessageHandleService;

    @Autowired
    @Qualifier("eventMessageHandleService")
    private MessageHandleService eventMessageHandleService;


    public MessageHandleService factory(String MsgType) {
        MessageHandleService messageHandleService = null;
        switch (MsgType) {
            case MessageUtil.REQ_MESSAGE_TYPE_TEXT:
                messageHandleService = textMessageHandleService;
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_IMAGE:
                messageHandleService = imageMessageHandleService;
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LINK:
                messageHandleService = linkMessageHandleService;
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_VOICE:
                messageHandleService = voiceMessageHandleService;
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_LOCATION:
                messageHandleService = locationMessageHandleService;
                break;
            case MessageUtil.REQ_MESSAGE_TYPE_EVENT:
                messageHandleService = eventMessageHandleService;
                break;
            default:
                messageHandleService = textMessageHandleService;
        }
        return messageHandleService;
    }

}

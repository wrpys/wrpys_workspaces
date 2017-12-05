package com.wrpys.app.wx.service.impl;

import com.wrpys.app.wx.model.resp.TextMessage;
import com.wrpys.app.wx.service.MessageHandleService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author wrp
 * @Description 请求消息处理 事件
 * @Date 2017/12/5
 */
@Service("eventMessageHandleService")
public class EventMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(EventMessageHandleServiceImpl.class);

    @Override
    public String handle(Map<String, String> reqMsg) {

        // 事件类型
        String eventType = reqMsg.get("Event");
        // 订阅
        if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
            StringBuffer sb = new StringBuffer();
            sb.append("谢谢您的关注，wrpys公众号：").append("\n");
            sb.append("***功能列表***").append("\n");
            sb.append("图文,获取图文列表").append("\n");
            sb.append("文本链接,获取wrpys主页").append("\n");
            sb.append("**********************").append("\n");
            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(reqMsg.get("ToUserName"));
            textMessage.setToUserName(reqMsg.get("FromUserName"));
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            textMessage.setContent(sb.toString());
            return MessageUtil.textMessageToXml(textMessage);
        }
        // 取消订阅
        else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
            // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
        }
        // 自定义菜单点击事件
        else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
            // TODO 自定义菜单权没有开放，暂不处理该类消息
        }
        return null;
    }
}

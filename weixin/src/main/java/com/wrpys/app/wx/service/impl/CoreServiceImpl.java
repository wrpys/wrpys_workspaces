package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.factory.MessageHandleFactory;
import com.wrpys.app.wx.service.CoreService;
import com.wrpys.app.wx.service.MessageHandleService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * @author wrp
 * @Description 微信主业务
 * @Date 2017/11/29
 */
@Service
public class CoreServiceImpl implements CoreService {

    private static final Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    @Autowired
    private MessageHandleFactory messageHandleFactory;

    public String processRequest(HttpServletRequest request) {
        String respMsg = null;
        try {
            // xml请求解析
            Map<String, String> reqMsgMap = MessageUtil.xmlToMap(request);
            log.info("CoreServiceImpl.processRequest===reqMsgMap:" + JSON.toJSONString(reqMsgMap));
            // 消息类型
            String msgType = reqMsgMap.get("MsgType");
            // 获取具体消息处理类
            MessageHandleService messageHandleService = messageHandleFactory.factory(msgType);
            respMsg = messageHandleService.handle(reqMsgMap);
        } catch (Exception e) {
            log.error("服务异常", e);
        }
        return respMsg;
    }

}

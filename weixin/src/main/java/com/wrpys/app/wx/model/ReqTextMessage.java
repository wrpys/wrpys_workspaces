package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.req.TextMessage;

/**
 * @author wrp
 * @Description 文本消息 db
 * @Date 2017/12/4
 */
public class ReqTextMessage extends TextMessage {

    private Long reqTextMessageId;

    public Long getReqTextMessageId() {
        return reqTextMessageId;
    }

    public void setReqTextMessageId(Long reqTextMessageId) {
        this.reqTextMessageId = reqTextMessageId;
    }
}

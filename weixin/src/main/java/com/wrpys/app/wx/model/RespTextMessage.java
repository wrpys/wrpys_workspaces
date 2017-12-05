package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.resp.TextMessage;

/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class RespTextMessage extends TextMessage {
    private Integer respTextMessageId;

    public Integer getRespTextMessageId() {
        return respTextMessageId;
    }

    public void setRespTextMessageId(Integer respTextMessageId) {
        this.respTextMessageId = respTextMessageId;
    }

}
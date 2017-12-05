package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.resp.NewsMessage;

/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class RespNewsMessage extends NewsMessage {
    private Integer respNewsMessageId;

    public Integer getRespNewsMessageId() {
        return respNewsMessageId;
    }

    public void setRespNewsMessageId(Integer respNewsMessageId) {
        this.respNewsMessageId = respNewsMessageId;
    }


}
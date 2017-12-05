package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.req.VoiceMessage;
/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class ReqVoiceMessage extends VoiceMessage {
    private Integer reqVoiceMessageId;

    public Integer getReqVoiceMessageId() {
        return reqVoiceMessageId;
    }

    public void setReqVoiceMessageId(Integer reqVoiceMessageId) {
        this.reqVoiceMessageId = reqVoiceMessageId;
    }

}
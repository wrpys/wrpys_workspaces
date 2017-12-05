package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.req.ImageMessage;
/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class ReqImageMessage extends ImageMessage {
    private Integer reqImageMessageId;

    public Integer getReqImageMessageId() {
        return reqImageMessageId;
    }

    public void setReqImageMessageId(Integer reqImageMessageId) {
        this.reqImageMessageId = reqImageMessageId;
    }

}
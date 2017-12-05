package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.req.LinkMessage;
/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class ReqLinkMessage extends LinkMessage {
    private Integer reqLinkMessageId;

    public Integer getReqLinkMessageId() {
        return reqLinkMessageId;
    }

    public void setReqLinkMessageId(Integer reqLinkMessageId) {
        this.reqLinkMessageId = reqLinkMessageId;
    }

}
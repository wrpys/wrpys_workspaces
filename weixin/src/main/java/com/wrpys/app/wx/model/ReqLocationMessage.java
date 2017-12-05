package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.req.LocationMessage;
/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class ReqLocationMessage extends LocationMessage {
    private Integer reqLocationMessageId;

    public Integer getReqLocationMessageId() {
        return reqLocationMessageId;
    }

    public void setReqLocationMessageId(Integer reqLocationMessageId) {
        this.reqLocationMessageId = reqLocationMessageId;
    }
}
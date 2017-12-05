package com.wrpys.app.wx.model.req;

/**
 * @author wrp
 * @Description 图片消息
 * @Date 2017/11/29
 */
public class ImageMessage extends BaseMessage {

    // 图片链接
    private String PicUrl;

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }
}

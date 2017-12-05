package com.wrpys.app.wx.model.req;

/**
 * @author wrp
 * @Description 文本消息
 * @Date 2017/11/29
 */
public class TextMessage extends BaseMessage {

    private String Content;//	文本消息内容

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

}

package com.wrpys.app.wx.model.resp;

/**
 * @author wrp
 * @Description 文本消息
 * @Date 2017/11/29
 */
public class TextMessage extends BaseMessage {

    // 回复的消息内容
    private String Content;

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}

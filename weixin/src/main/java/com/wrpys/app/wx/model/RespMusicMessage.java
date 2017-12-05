package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.resp.MusicMessage;
/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class RespMusicMessage extends MusicMessage {
    private Integer respMusicMessageId;

    public Integer getRespMusicMessageId() {
        return respMusicMessageId;
    }

    public void setRespMusicMessageId(Integer respMusicMessageId) {
        this.respMusicMessageId = respMusicMessageId;
    }

}
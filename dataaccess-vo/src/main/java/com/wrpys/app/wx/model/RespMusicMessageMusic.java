package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.resp.Music;

/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class RespMusicMessageMusic extends Music {
    private Integer respMusicMessageMusicId;

    private Integer respMusicMessageId;

    public Integer getRespMusicMessageMusicId() {
        return respMusicMessageMusicId;
    }

    public void setRespMusicMessageMusicId(Integer respMusicMessageMusicId) {
        this.respMusicMessageMusicId = respMusicMessageMusicId;
    }

    public Integer getRespMusicMessageId() {
        return respMusicMessageId;
    }

    public void setRespMusicMessageId(Integer respMusicMessageId) {
        this.respMusicMessageId = respMusicMessageId;
    }

}
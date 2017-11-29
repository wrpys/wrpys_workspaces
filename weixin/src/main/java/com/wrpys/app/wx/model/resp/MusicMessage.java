package com.wrpys.app.wx.model.resp;

/**
 * @author wrp
 * @Description 音乐消息
 * @Date 2017/11/29
 */
public class MusicMessage extends BaseMessage {

    // 音乐
    private Music Music;

    public com.wrpys.app.wx.model.resp.Music getMusic() {
        return Music;
    }

    public void setMusic(com.wrpys.app.wx.model.resp.Music music) {
        Music = music;
    }
}

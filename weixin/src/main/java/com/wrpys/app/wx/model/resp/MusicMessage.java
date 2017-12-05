package com.wrpys.app.wx.model.resp;

/**
 * @author wrp
 * @Description 音乐消息
 * @Date 2017/11/29
 */
public class MusicMessage extends BaseMessage {

    // 音乐
    private Music Music;

    public Music getMusic() {
        return Music;
    }

    public void setMusic(Music music) {
        Music = music;
    }
}

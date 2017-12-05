package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.RespMusicMessage;

public interface RespMusicMessageDao {
    int deleteByPrimaryKey(Integer respMusicMessageId);

    int insert(RespMusicMessage record);

    int insertSelective(RespMusicMessage record);

    RespMusicMessage selectByPrimaryKey(Integer respMusicMessageId);

    int updateByPrimaryKeySelective(RespMusicMessage record);

    int updateByPrimaryKey(RespMusicMessage record);
}
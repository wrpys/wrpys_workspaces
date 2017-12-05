package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.RespMusicMessageMusic;

public interface RespMusicMessageMusicDao {
    int deleteByPrimaryKey(Integer respMusicMessageMusicId);

    int insert(RespMusicMessageMusic record);

    int insertSelective(RespMusicMessageMusic record);

    RespMusicMessageMusic selectByPrimaryKey(Integer respMusicMessageMusicId);

    int updateByPrimaryKeySelective(RespMusicMessageMusic record);

    int updateByPrimaryKey(RespMusicMessageMusic record);
}
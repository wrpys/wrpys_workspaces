package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.RespTextMessage;

public interface RespTextMessageDao {
    int deleteByPrimaryKey(Integer respTextMessageId);

    int insert(RespTextMessage record);

    int insertSelective(RespTextMessage record);

    RespTextMessage selectByPrimaryKey(Integer respTextMessageId);

    int updateByPrimaryKeySelective(RespTextMessage record);

    int updateByPrimaryKey(RespTextMessage record);
}
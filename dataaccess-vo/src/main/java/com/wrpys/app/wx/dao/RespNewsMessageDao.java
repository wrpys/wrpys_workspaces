package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.RespNewsMessage;

public interface RespNewsMessageDao {
    int deleteByPrimaryKey(Integer respNewsMessageId);

    int insert(RespNewsMessage record);

    int insertSelective(RespNewsMessage record);

    RespNewsMessage selectByPrimaryKey(Integer respNewsMessageId);

    int updateByPrimaryKeySelective(RespNewsMessage record);

    int updateByPrimaryKey(RespNewsMessage record);
}
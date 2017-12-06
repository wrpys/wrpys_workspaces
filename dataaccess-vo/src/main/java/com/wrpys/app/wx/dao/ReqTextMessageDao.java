package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.ReqTextMessage;

import java.util.List;

public interface ReqTextMessageDao {
    int deleteByPrimaryKey(Integer reqTextMessageId);

    int insert(ReqTextMessage record);

    int insertSelective(ReqTextMessage record);

    ReqTextMessage selectByPrimaryKey(Integer reqTextMessageId);

    int updateByPrimaryKeySelective(ReqTextMessage record);

    int updateByPrimaryKey(ReqTextMessage record);

    List<ReqTextMessage> findTextMessageByParams(ReqTextMessage reqTextMessage);
}
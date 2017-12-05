package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.ReqImageMessage;

public interface ReqImageMessageDao {
    int deleteByPrimaryKey(Integer reqImageMessageId);

    int insert(ReqImageMessage record);

    int insertSelective(ReqImageMessage record);

    ReqImageMessage selectByPrimaryKey(Integer reqImageMessageId);

    int updateByPrimaryKeySelective(ReqImageMessage record);

    int updateByPrimaryKey(ReqImageMessage record);
}
package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.ReqLocationMessage;

public interface ReqLocationMessageDao {
    int deleteByPrimaryKey(Integer reqLocationMessageId);

    int insert(ReqLocationMessage record);

    int insertSelective(ReqLocationMessage record);

    ReqLocationMessage selectByPrimaryKey(Integer reqLocationMessageId);

    int updateByPrimaryKeySelective(ReqLocationMessage record);

    int updateByPrimaryKey(ReqLocationMessage record);
}
package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.ReqLinkMessage;

public interface ReqLinkMessageDao {
    int deleteByPrimaryKey(Integer reqLinkMessageId);

    int insert(ReqLinkMessage record);

    int insertSelective(ReqLinkMessage record);

    ReqLinkMessage selectByPrimaryKey(Integer reqLinkMessageId);

    int updateByPrimaryKeySelective(ReqLinkMessage record);

    int updateByPrimaryKey(ReqLinkMessage record);
}
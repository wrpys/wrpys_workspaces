package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.ReqVoiceMessage;

public interface ReqVoiceMessageDao {
    int deleteByPrimaryKey(Integer reqVoiceMessageId);

    int insert(ReqVoiceMessage record);

    int insertSelective(ReqVoiceMessage record);

    ReqVoiceMessage selectByPrimaryKey(Integer reqVoiceMessageId);

    int updateByPrimaryKeySelective(ReqVoiceMessage record);

    int updateByPrimaryKey(ReqVoiceMessage record);
}
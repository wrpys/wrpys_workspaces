package com.wrpys.app.wx.dao;

import com.wrpys.app.wx.model.RespNewsMessageArticle;

public interface RespNewsMessageArticleDao {
    int deleteByPrimaryKey(Integer respNewsMessageArticleId);

    int insert(RespNewsMessageArticle record);

    int insertSelective(RespNewsMessageArticle record);

    RespNewsMessageArticle selectByPrimaryKey(Integer respNewsMessageArticleId);

    int updateByPrimaryKeySelective(RespNewsMessageArticle record);

    int updateByPrimaryKey(RespNewsMessageArticle record);
}
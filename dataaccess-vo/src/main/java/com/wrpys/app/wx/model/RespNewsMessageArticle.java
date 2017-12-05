package com.wrpys.app.wx.model;

import com.wrpys.app.wx.model.resp.Article;

/**
 * @author wrp
 * @Description db
 * @Date 2017/12/4
 */
public class RespNewsMessageArticle extends Article {
    private Integer respNewsMessageArticleId;

    private Integer respNewsMessageId;

    public Integer getRespNewsMessageArticleId() {
        return respNewsMessageArticleId;
    }

    public void setRespNewsMessageArticleId(Integer respNewsMessageArticleId) {
        this.respNewsMessageArticleId = respNewsMessageArticleId;
    }

    public Integer getRespNewsMessageId() {
        return respNewsMessageId;
    }

    public void setRespNewsMessageId(Integer respNewsMessageId) {
        this.respNewsMessageId = respNewsMessageId;
    }

}
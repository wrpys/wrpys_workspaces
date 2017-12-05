package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.dao.ReqTextMessageDao;
import com.wrpys.app.wx.model.ReqTextMessage;
import com.wrpys.app.wx.model.resp.Article;
import com.wrpys.app.wx.model.resp.NewsMessage;
import com.wrpys.app.wx.model.resp.TextMessage;
import com.wrpys.app.wx.service.MessageHandleService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author wrp
 * @Description 请求消息处理 文本
 * @Date 2017/12/5
 */
@Service("textMessageHandleService")
public class TextMessageHandleServiceImpl implements MessageHandleService {

    private static final Logger log = LoggerFactory.getLogger(TextMessageHandleServiceImpl.class);

    @Autowired
    private ReqTextMessageDao reqTextMessageDao;

    @Override
    public String handle(Map<String, String> reqMsg) {
        ReqTextMessage reqTextMessage = new ReqTextMessage();
        MessageUtil.mapToObject(reqMsg, reqTextMessage);
        log.info("reqTextMessage:" + JSON.toJSONString(reqTextMessage));
        reqTextMessageDao.insert(reqTextMessage);
        if ("菜单".equals(reqTextMessage.getContent())) {
            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(reqTextMessage.getToUserName());
            textMessage.setToUserName(reqTextMessage.getFromUserName());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            StringBuffer sb = new StringBuffer();
            sb.append("wrpys公众号：").append("\n");
            sb.append("***功能列表***").append("\n");
            sb.append("图文,获取图文列表").append("\n");
            sb.append("文本链接,获取wrpys主页").append("\n");
            sb.append("**********************").append("\n");
            textMessage.setContent(sb.toString());
            return MessageUtil.textMessageToXml(textMessage);
        } else if ("图文".equals(reqTextMessage.getContent())) {
            NewsMessage newsMessage = new NewsMessage();
            newsMessage.setFromUserName(reqTextMessage.getToUserName());
            newsMessage.setToUserName(reqTextMessage.getFromUserName());
            newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
            newsMessage.setFuncFlag(0);

            List<Article> articles = new ArrayList<>();
            Article article = new Article();
            article.setTitle("标题");
            article.setPicUrl("https://ss0.bdstatic.com/5aV1bjqh_Q23odCf/static/superman/img/logo/bd_logo1_31bdc765.png");
            article.setUrl("https://www.baidu.com/");
            article.setDescription("测试描述");
            articles.add(article);

            article = new Article();
            article.setTitle("大家的事由大家商量着办——习近平主席致第四届世界互联网大会的贺信引起与会中外嘉宾热烈反响");
//          article.setPicUrl("https://mp.weixin.qq.com/misc/getqrcode?fakeid=3074025666&token=205380857&style=1");
            article.setUrl("https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_15464600260927191937%22%7D&n_type=0&p_from=1");
            article.setDescription("大家的事由大家商量着办——习近平主席致第四届世界互联网大会的贺信引起与会中外嘉宾热烈反响");
            articles.add(article);

            article = new Article();
            article.setTitle("某网友吃冰激凌吃出一条真蛇，他真的很无耻！");
            article.setPicUrl("https://ss1.baidu.com/6ONXsjip0QIZ8tyhnq/it/u=1192839229,3053310621&fm=173&s=DDFE34D7560046E204B6A9740300D06B&w=640&h=397&img.JPEG");
            article.setUrl("https://mbd.baidu.com/newspage/data/landingsuper?context=%7B%22nid%22%3A%22news_9860825529527486302%22%7D&n_type=0&p_from=1");
            article.setDescription("某网友吃冰激凌吃出一条真蛇，他真的很无耻！");
            articles.add(article);

            String baseUrl = "http://5aa06d97.ngrok.io";
            article = new Article();
            article.setTitle("wrpys");
            article.setUrl(baseUrl + "/index");
            article.setPicUrl(baseUrl + "/common/images/erweima.jpg");
            article.setDescription("wrpys微信公众号");
            articles.add(article);

            article = new Article();
            article.setTitle("wrpys头像");
            article.setUrl(baseUrl + "/index");
            article.setPicUrl(baseUrl + "/common/images/wrpys_icon.jpg");
            article.setDescription("wrpys微信公众号头像");
            articles.add(article);

            newsMessage.setArticles(articles);
            newsMessage.setArticleCount(articles.size());
            return MessageUtil.newsMessageToXml(newsMessage);
        } else if ("文本链接".equals(reqTextMessage.getContent())) {
            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(reqTextMessage.getToUserName());
            textMessage.setToUserName(reqTextMessage.getFromUserName());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            textMessage.setContent("<a href=\"https://wrpys.github.io/PhotoWall\">wrpys主页</a>");
            return MessageUtil.textMessageToXml(textMessage);
        } else {
            TextMessage textMessage = new TextMessage();
            textMessage.setFromUserName(reqTextMessage.getToUserName());
            textMessage.setToUserName(reqTextMessage.getFromUserName());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);
            StringBuffer sb = new StringBuffer();
            sb.append("未知内容，请发送：").append("\n");
            sb.append("**********************").append("\n");
            sb.append("图文,获取图文列表").append("\n");
            sb.append("文本链接,获取wrpys主页").append("\n");
            sb.append("**********************").append("\n");
            textMessage.setContent(sb.toString());
            return MessageUtil.textMessageToXml(textMessage);
        }
    }
}

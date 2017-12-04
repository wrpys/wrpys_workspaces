package com.wrpys.app.wx.service.impl;

import com.alibaba.fastjson.JSON;
import com.wrpys.app.wx.model.resp.Article;
import com.wrpys.app.wx.model.resp.NewsMessage;
import com.wrpys.app.wx.model.resp.TextMessage;
import com.wrpys.app.wx.service.CoreService;
import com.wrpys.app.wx.utils.MessageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author wrp
 * @Description 微信主业务
 * @Date 2017/11/29
 */
@Service
public class CoreServiceImpl implements CoreService {

    private static final Logger log = LoggerFactory.getLogger(CoreServiceImpl.class);

    public String processRequest(HttpServletRequest request) {
        String respMessage = null;
        try {
            // 默认返回的文本消息内容
            String respContent = "请求处理异常，请稍候尝试！";

            // xml请求解析
            Map<String, String> requestMap = MessageUtil.xmlToMap(request);
            log.info("CoreServiceImpl.processRequest===requestMap:" + JSON.toJSONString(requestMap));

            // 发送方帐号（open_id）
            String fromUserName = requestMap.get("FromUserName");
            // 公众帐号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            // 回复文本消息
            TextMessage textMessage = new TextMessage();
            textMessage.setToUserName(fromUserName);
            textMessage.setFromUserName(toUserName);
            textMessage.setCreateTime(new Date().getTime());
            textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
            textMessage.setFuncFlag(0);

            // 文本消息
            if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)) {

                String content = requestMap.get("Content");
                if ("图片".equals(content)) {
                    NewsMessage newsMessage = new NewsMessage();
                    newsMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                    newsMessage.setToUserName(fromUserName);
                    newsMessage.setFromUserName(toUserName);
                    newsMessage.setCreateTime(new Date().getTime());
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
//                    article.setPicUrl("https://mp.weixin.qq.com/misc/getqrcode?fakeid=3074025666&token=205380857&style=1");
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
                } else if ("文本链接".equals(content)) {
                    respContent = "<a href=\"http://blog.csdn.net/lyq8479\">wrpys主页</a>";
                } else {
                    respContent = "您发送的是文本消息！" + content;
                }

            }
            // 图片消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_IMAGE)) {
                respContent = "您发送的是图片消息！";
            }
            // 地理位置消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LOCATION)) {
                respContent = "您发送的是地理位置消息！";
            }
            // 链接消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_LINK)) {
                respContent = "您发送的是链接消息！";
            }
            // 音频消息
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_VOICE)) {
                respContent = "您发送的是音频消息！";
            }
            // 事件推送
            else if (msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)) {
                // 事件类型
                String eventType = requestMap.get("Event");
                // 订阅
                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    respContent = "谢谢您的关注！";
                }
                // 取消订阅
                else if (eventType.equals(MessageUtil.EVENT_TYPE_UNSUBSCRIBE)) {
                    // TODO 取消订阅后用户再收不到公众号发送的消息，因此不需要回复消息
                }
                // 自定义菜单点击事件
                else if (eventType.equals(MessageUtil.EVENT_TYPE_CLICK)) {
                    // TODO 自定义菜单权没有开放，暂不处理该类消息
                }
            }
            textMessage.setContent(respContent);
            respMessage = MessageUtil.textMessageToXml(textMessage);
        } catch (Exception e) {
            log.error("异常", e);
        }
        return respMessage;
    }

}

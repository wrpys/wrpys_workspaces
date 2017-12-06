package com.wrpys.app.ui.service.impl;

import com.wrpys.app.ui.service.TextMessageService;
import com.wrpys.app.wx.dao.ReqTextMessageDao;
import com.wrpys.app.wx.model.ReqTextMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wrp
 * @Description 文本消息管理
 * @Date 2017/12/6
 */
@Service
public class TextMessageServiceImpl implements TextMessageService{

    @Autowired
    private ReqTextMessageDao reqTextMessageDao;

    @Override
    public List<ReqTextMessage> findTextMessage(ReqTextMessage reqTextMessage) {

        return reqTextMessageDao.findTextMessageByParams(reqTextMessage);

    }

}

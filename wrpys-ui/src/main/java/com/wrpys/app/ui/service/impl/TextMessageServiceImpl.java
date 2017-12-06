package com.wrpys.app.ui.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.wrpys.app.common.Contants;
import com.wrpys.app.common.PageBean;
import com.wrpys.app.ui.service.TextMessageService;
import com.wrpys.app.vo.PageParamBean;
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
    public PageBean findTextMessage(PageParamBean<ReqTextMessage> pageParam) {
        Page<ReqTextMessage> page = PageHelper.startPage(pageParam.getPage(), pageParam.getLimit());
        List<ReqTextMessage> data = reqTextMessageDao.findTextMessageByParams(pageParam.getParams());
        return PageBean.build(Contants.SUCESS, null, page.getTotal(), data);
    }

}

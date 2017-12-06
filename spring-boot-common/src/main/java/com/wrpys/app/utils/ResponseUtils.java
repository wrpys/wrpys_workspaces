package com.wrpys.app.utils;

import com.wrpys.app.vo.BasicResponseContentVo;
import com.wrpys.app.vo.ResponseHeaderVo;

import java.util.Date;

/**
 * 报文请求/返回工具
 *
 * @author wrp
 */
public class ResponseUtils {

    /**
     * 构造响应头
     *
     * @param respDesc
     * @param respCode
     * @param requestSeq
     * @return
     */
    public static ResponseHeaderVo buildResponseHeader(String respDesc, String respCode, String requestSeq) {
        ResponseHeaderVo header = new ResponseHeaderVo();
        header.setRespDesc(respDesc);
        header.setRespCode(respCode);
        header.setRequestSeq(requestSeq);
        header.setResponseTime(DateUtils.formatDate(new Date(), DateUtils.DATE_FORMAT));
        return header;
    }

    /**
     * 构造响应实体
     *
     * @param responseHeaderVo
     * @param object
     * @return
     */
    public static BasicResponseContentVo buildBasicResponseContentVo(
            ResponseHeaderVo responseHeaderVo, Object object) {
        BasicResponseContentVo<Object> responseContentVo = new BasicResponseContentVo<>();
        responseContentVo.setHeader(responseHeaderVo);
        responseContentVo.setContent(object);
        return responseContentVo;
    }
}

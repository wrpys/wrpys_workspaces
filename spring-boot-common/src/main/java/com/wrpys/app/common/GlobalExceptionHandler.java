package com.wrpys.app.common;

import com.wrpys.app.exception.WYCheckedException;
import com.wrpys.app.exception.WYUnCheckedException;
import com.wrpys.app.utils.ResponseUtils;
import com.wrpys.app.vo.ResponseHeaderVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.sql.SQLException;

/**
 * @author wrp
 * @Description 统一异常处理
 * @Date 2017/10/11
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String tag = "GlobalExceptionHandler===";

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
        logger.error(tag, e);
        ResponseHeaderVo responseHeaderVo = null;
        Class eClazz = Exception.class;
        // 异常为SQLException或者SQLException的子类
        if (SQLException.class.isAssignableFrom(eClazz) || e instanceof SQLException
                || DataAccessException.class.isAssignableFrom(eClazz) || e instanceof DataAccessException) {
            responseHeaderVo = ResponseUtils.buildResponseHeader("数据库操作异常!", ErrorCode.SQL_OPER_ERROR, null);
        }
        // 异常为NLCheckedException或者NLCheckedException的子类
        else if (WYCheckedException.class.isAssignableFrom(eClazz) || e instanceof WYCheckedException) {
            WYCheckedException nlce = (WYCheckedException) e;
            responseHeaderVo = ResponseUtils.buildResponseHeader(nlce.getMsg(), nlce.getCode(), null);
        }
        // 异常为NLUnCheckedException或者NLUnCheckedException的子类
        else if (WYUnCheckedException.class.isAssignableFrom(eClazz) || e instanceof WYUnCheckedException) {
            WYUnCheckedException nluce = (WYUnCheckedException) e;
            responseHeaderVo = ResponseUtils.buildResponseHeader(nluce.getMsg(), nluce.getCode(), null);
        } else {
            responseHeaderVo = ResponseUtils.buildResponseHeader("系统未知异常！", ErrorCode.SYSERROR_UNKNOW, null);
        }
        return ResponseEntity.ok(ResponseUtils.buildBasicResponseContentVo(responseHeaderVo, null));
    }

}

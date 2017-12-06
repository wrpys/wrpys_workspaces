package com.wrpys.app.common;

/**
 * 错误码定义类
 *
 * @author wrp 编码规则：第三方异常如果有errcode则直接使用，否则按一级分类(1位)+二级分类(2位)+三级分类(自定义)
 */
public class ErrorCode {

    // 系统级异常
    public static final String SYSERROR = "1";
    public static final String SYSERROR_UNKNOW = SYSERROR + "00" + "00000";

    // 数据库操作异常
    public static final String SQL_OPER_ERROR = SYSERROR + "21" + "00000";

    // 业务级异常
    public static final String BUSERROR = "2";

    // 日期转换异常
    public static final String BUSERROR_DATE_PARSER = BUSERROR + "01" + "00002";

}
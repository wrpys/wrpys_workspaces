package com.wrpys.app.exception;

interface WYThrowable {

    /**
     * 获取错误码信息
     *
     * @return
     */
    String getCode();

    /**
     * 获取错误信息
     *
     * @return
     */
    String getMsg();

    /**
     * 获取异常类型
     *
     * @return
     */
    String getType();

    /**
     * 获取异常堆栈信息
     *
     * @return
     */
    String getStackTraceMsg();

    /**
     * 获取异常源
     *
     * @return
     */
    Throwable getThrowable();
}

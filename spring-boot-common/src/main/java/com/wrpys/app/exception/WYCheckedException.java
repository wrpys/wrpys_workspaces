package com.wrpys.app.exception;

import com.wrpys.app.utils.ErrorMsg;

/**
 * 检查型异常基类，抛出此异常，外部强制捕获此异常和做相关处理。
 *
 * @author wrp
 */
public class WYCheckedException extends Exception implements WYThrowable {

    private static final long serialVersionUID = 1L;

    // 错误码
    protected String code = "";

    // 错误信息
    protected String message = "";

    // 异常体
    protected Throwable throwable;

    public WYCheckedException() {
    }

    public WYCheckedException(String code, String message, Throwable throwable) {
        super(message, throwable);
        this.code = code;
        this.message = message;
        this.throwable = throwable;
    }

    public WYCheckedException(String code, Throwable throwable) {
        super(throwable);
        this.code = code;
        this.throwable = throwable;
        if (throwable != null) {
            this.message = throwable.getMessage();
        }
    }

    public WYCheckedException(String code, WYThrowable ex) {
        this.code = code;
        if (ex != null) {
            this.message = ex.getMsg();
            this.throwable = ex.getThrowable();
            if (this.throwable != null) {
                setStackTrace(ex.getThrowable().getStackTrace());
            }
        }
    }

    public WYCheckedException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.message;
    }

    public String getStackTraceMsg() {
        if (this.throwable == null)
            return message;
        return ErrorMsg.getErrorMsg(this.throwable);
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override
    public String getType() {
        // TODO Auto-generated method stub
        return null;
    }
}

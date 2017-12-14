package com.wrpys.app.utils;

/**
 * 异常堆栈处理
 *
 * @author Administrator
 */
public class ErrorMsg {
    /**
     * 获取异常堆栈为字符串
     */
    public static String getErrorMsg(Throwable e) {
        StringBuffer errorMsg = new StringBuffer();
        errorMsg.append(e);
        StackTraceElement[] trace = e.getStackTrace();
        for (int i = 0; i < trace.length; i++) {
            errorMsg.append("\n\tat " + trace[i]);
        }
        Throwable ourCause = e.getCause();
        if (ourCause != null) {
            errorMsg.append(getErrorCause(ourCause, trace));
        }
        return errorMsg.toString();
    }

    private static String getErrorCause(Throwable ourCause, StackTraceElement[] causedTrace) {
        StringBuffer errorMsg = new StringBuffer();
        StackTraceElement[] trace = ourCause.getStackTrace();
        int m = trace.length - 1, n = causedTrace.length - 1;
        while (m >= 0 && n >= 0 && trace[m].equals(causedTrace[n])) {
            m--;
            n--;
        }
        int framesInCommon = trace.length - 1 - m;
        errorMsg.append("\nCaused by: \n" + ourCause);
        for (int i = 0; i <= m; i++) {
            errorMsg.append("\n\tat " + trace[i]);
        }
        if (framesInCommon != 0) {
            errorMsg.append("\n\t... " + framesInCommon + " more");
        }
        Throwable ourCause2 = ourCause.getCause();
        if (ourCause2 != null) {
            errorMsg.append(getErrorCause(ourCause2, trace));
        }
        return errorMsg.toString();
    }
}

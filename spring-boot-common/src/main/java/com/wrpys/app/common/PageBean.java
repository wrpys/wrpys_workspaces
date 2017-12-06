package com.wrpys.app.common;

import java.util.List;

/**
 * @author wrp
 * @Description 分页查询对象
 * @Date 2017/12/6
 */
public class PageBean {

    private String code;
    private String msg;
    private Long count;
    private List<?> data;

    public PageBean() {
    }

    public PageBean(String code, String msg, Long count, List<?> data) {
        this.code = code;
        this.msg = msg;
        this.count = count;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

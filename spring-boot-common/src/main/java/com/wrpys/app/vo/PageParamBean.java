package com.wrpys.app.vo;

/**
 * @author wrp
 * @Description 分页参数
 * @Date 2017/12/6
 */
public class PageParamBean<T> {

    private Integer page = 1;
    private Integer limit = 10;

    private T params;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public T getParams() {
        return params;
    }

    public void setParams(T params) {
        this.params = params;
    }
}

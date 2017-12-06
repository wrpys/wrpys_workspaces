package com.wrpys.app.common;

import java.util.List;

/**
 * @author wrp
 * @Description 分页查询对象
 * @Date 2017/10/18
 */
public class PageBean {

    private Long total;
    private List<?> rows;

    public PageBean() {
    }

    public PageBean(Long total, List<?> rows) {
        this.total = total;
        this.rows = rows;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}

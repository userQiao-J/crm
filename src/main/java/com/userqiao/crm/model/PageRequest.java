package com.userqiao.crm.model;

/**
 * @author userqiao
 * @Title: PageRequest
 * @Package com.userqiao.crm.model
 * @Description: 请求的分页对象
 * @date 2020/7/11 0:03
 */
public class PageRequest {
    private Integer pageNum;

    private Integer pageSize;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}

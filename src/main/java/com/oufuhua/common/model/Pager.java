package com.oufuhua.common.model;

import javax.persistence.criteria.CriteriaBuilder;
import java.io.Serializable;
import java.util.List;

public class Pager<T> implements Serializable {
    private static final long serialVersionUID = -7248915170131298357L;

    private Integer pageIndex = 0; // 当前第几条数据 默认从0开始

    private Integer pageSize = 10; // 每页显示多少条数据

    private Integer totalRecord = 0; // 一共多少条记录

    private Integer totalPage = 0; // 一共多少页记录

    private List<T> dataList;  // 要显示的数据


    private String orderByType = "DESC"; //排序方向（降序）
    private String orderByName = "update_time"; // 排序更新时间


    /* 获取分页的开始索引，默认从0开始 */
    public Integer getPageNum() {
        return pageIndex * pageSize;
    }

    public Pager() {
    }

    public Pager(Integer pageSize, Integer pageIndex, Integer totalRecord, Integer totalPage, List<T> dataList) {
        this.pageSize = pageSize;
        this.pageIndex = pageIndex;
        this.totalRecord = totalRecord;
        this.totalPage = totalPage;
        this.dataList = dataList;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(Integer totalRecord) {
        this.totalRecord = totalRecord;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }


    public String getOrderByType() {
        return orderByType;
    }

    public void setOrderByType(String orderByType) {
        this.orderByType = orderByType;
    }

    public String getOrderByName() {
        return orderByName;
    }

    public void setOrderByName(String orderByName) {
        this.orderByName = orderByName;
    }

    @Override
    public String toString() {
        return "Pager{" +
                "pageSize=" + pageSize +
                ", pageIndex=" + pageIndex +
                ", totalRecord=" + totalRecord +
                ", totalPage=" + totalPage +
                ", dataList=" + dataList +
                ", orderByType='" + orderByType + '\'' +
                ", orderByName='" + orderByName + '\'' +
                '}';
    }
}

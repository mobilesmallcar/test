package com.example.grab.vo.Response;

import com.google.common.base.MoreObjects;
import java.io.Serializable;

public class ResultDTO<T> implements Serializable {
    private Boolean success;
    private Integer code;
    private String msg;
    private Integer pageNum;
    private Integer pageSize;
    private Long count;
    private Long total;
    private T data;

    public ResultDTO() {
        this.success = Boolean.TRUE;
    }

    public ResultDTO(T data) {
        this.success = Boolean.TRUE;
        this.code = 0;
        this.data = data;
    }

    public static <T> ResultDTO<T> newResult() {
        return new ResultDTO();
    }

    public static <T> ResultDTO<T> newResult(T data) {
        return new ResultDTO(data);
    }

    public Boolean getSuccess() {
        return this.success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
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

    public Integer getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return this.pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTotal() {
        return this.total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String toString() {
        return MoreObjects.toStringHelper(this).add("success", this.success).add("code", this.code).add("event", this.msg).add("pageNum", this.pageNum).add("pageSize", this.pageSize).add("pageCount", this.count).add("data", this.data).toString();
    }
}

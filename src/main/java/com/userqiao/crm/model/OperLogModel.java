package com.userqiao.crm.model;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 操作日志实体类
 *
 * @author userqiao
 * @date 2020/06/22
 */
public class OperLogModel {
    private String operId;
    private String operModul;
    private String operType;
    private String operDesc;
    private String operRequParam;
    private String operRespParam;
    private long operUserId;
    private String operUserName;
    private String operMethod;
    private String operUrl;
    private String operIp;
    private Date operCreateTime;
    private String operVer;

    public String getOperId() {
        return operId;
    }

    public void setOperId(String operId) {
        this.operId = operId;
    }

    public String getOperModul() {
        return operModul;
    }

    public void setOperModul(String operModul) {
        this.operModul = operModul;
    }


    public String getOperType() {
        return operType;
    }

    public void setOperType(String operType) {
        this.operType = operType;
    }


    public String getOperDesc() {
        return operDesc;
    }

    public void setOperDesc(String operDesc) {
        this.operDesc = operDesc;
    }


    public String getOperRequParam() {
        return operRequParam;
    }

    public void setOperRequParam(String operRequParam) {
        this.operRequParam = operRequParam;
    }


    public String getOperRespParam() {
        return operRespParam;
    }

    public void setOperRespParam(String operRespParam) {
        this.operRespParam = operRespParam;
    }


    public long getOperUserId() {
        return operUserId;
    }

    public void setOperUserId(long operUserId) {
        this.operUserId = operUserId;
    }


    public String getOperUserName() {
        return operUserName;
    }

    public void setOperUserName(String operUserName) {
        this.operUserName = operUserName;
    }


    public String getOperMethod() {
        return operMethod;
    }

    public void setOperMethod(String operMethod) {
        this.operMethod = operMethod;
    }


    public String getOperUrl() {
        return operUrl;
    }

    public void setOperUrl(String operUrl) {
        this.operUrl = operUrl;
    }


    public String getOperIp() {
        return operIp;
    }

    public void setOperIp(String operIp) {
        this.operIp = operIp;
    }


    public Date getOperCreateTime() {
        return operCreateTime;
    }

    public void setOperCreateTime(Date operCreateTime) {
        this.operCreateTime = operCreateTime;
    }

    public String getOperVer() {
        return operVer;
    }

    public void setOperVer(String operVer) {
        this.operVer = operVer;
    }

}

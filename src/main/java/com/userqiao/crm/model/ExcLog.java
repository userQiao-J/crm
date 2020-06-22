package com.userqiao.crm.model;


import java.time.LocalDateTime;
import java.util.Date;

public class ExcLog {

  private long excId;
  private String excRequParam;
  private String excName;
  private String excMessage;
  private long operUserId;
  private String operUserName;
  private String operMethod;
  private String operUrl;
  private String operIp;
  private String operVer;
  private Date operCreateTime;


  public long getExcId() {
    return excId;
  }

  public void setExcId(long excId) {
    this.excId = excId;
  }


  public String getExcRequParam() {
    return excRequParam;
  }

  public void setExcRequParam(String excRequParam) {
    this.excRequParam = excRequParam;
  }


  public String getExcName() {
    return excName;
  }

  public void setExcName(String excName) {
    this.excName = excName;
  }


  public String getExcMessage() {
    return excMessage;
  }

  public void setExcMessage(String excMessage) {
    this.excMessage = excMessage;
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


  public String getOperVer() {
    return operVer;
  }

  public void setOperVer(String operVer) {
    this.operVer = operVer;
  }

  public Date getOperCreateTime() {
    return operCreateTime;
  }

  public void setOperCreateTime(Date operCreateTime) {
    this.operCreateTime = operCreateTime;
  }
}

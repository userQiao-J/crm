package com.userqiao.crm.model;

import lombok.Getter;
import lombok.Setter;

/**
 * @author userqiao
 * @Title: RespBean
 * @Package com.userqiao.crm.model
 * @Description: 接口返回值实体类
 * @date 2020/6/6 9:12
 */
@Getter
@Setter
public class RespBean {
    private Integer status;
    private String msg;
    private Object object;

    private RespBean() {
    }

    private RespBean(Integer status, String msg, Object object) {
        this.status = status;
        this.msg = msg;
        this.object = object;
    }

    public static RespBean ok(String msg){
        return new RespBean(200,msg,null);
    }
    public static RespBean ok(String msg,Object object){
        return new RespBean(200,msg,object);
    }
    public static RespBean error(String msg){
        return new RespBean(500,msg,null);
    }
    public static RespBean error(String msg,Object object){
        return new RespBean(500,msg,object);
    }
}

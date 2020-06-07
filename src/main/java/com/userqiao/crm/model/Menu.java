package com.userqiao.crm.model;

import lombok.Data;

import java.util.List;

/**
 * 菜单
 *
 * @author userqiao
 * @date 2020/06/05
 */
@Data
public class Menu {
    private Integer id;

    private String url;

    private String path;

    private String component;

    private String name;

    private String iconCls;

    private Meta meta;

    private List<Menu> children;

    private Integer parentId;

    private Boolean enabled;
}
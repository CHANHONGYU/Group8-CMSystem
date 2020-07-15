package com.smart.cmsystem.domain.entity;

import lombok.Data;

@Data
public class User {
    /**
    * 主键
    */
    private Integer uId;

    /**
    * 角色名
    */
    private String uRole;

    /**
    * 权限等级
    */
    private String uPrivilegelevel;

    /**
    * 描述
    */
    private String uDescribe;

    /**
    * 状态 1为启用 ，0为停用
    */
    private Integer uState;

    /**
    * 删除 1为未删除，0为已删除
    */
    private Integer uDel;
}
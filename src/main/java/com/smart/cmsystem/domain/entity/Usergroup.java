package com.smart.cmsystem.domain.entity;

import lombok.Data;

/**
    * 用户组列表
    */
@Data
public class Usergroup {
    /**
    * 用户组ID
    */
    private Integer uId;

    /**
    * 角色名
    */
    private String uRole;

    /**
    * 权限等级
    */
    private String uPrivlegelevel;

    /**
    * 描述
    */
    private String uDescribe;

    /**
    * 状态 1为启用，0为停用
    */
    private Integer uState;

    /**
    * 删除 1为未删除，0为删除
    */
    private Integer uDel;
}
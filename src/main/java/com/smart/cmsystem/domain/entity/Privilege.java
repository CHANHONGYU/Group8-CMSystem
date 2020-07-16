package com.smart.cmsystem.domain.entity;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

@Data
public class Privilege {
    /**
    * 权限ID
    */
    private Integer pId;

    /**
    * 权限规则
    */
    private String pRole;

    /**
    * 权限名称
    */
    private String pName;

    /**
    * 权限等级
    */
    private String pLevel;

    /**
    * 创建时间
    */
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date pCreationtime;

    /**
    * 状态 1为启用，0为停用
    */
    private Integer pState;

    /**
    * 删除 1为未删除，0为删除
    */
    private Integer pDel;
}
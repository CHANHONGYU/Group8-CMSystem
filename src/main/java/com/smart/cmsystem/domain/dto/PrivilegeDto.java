package com.smart.cmsystem.domain.dto;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;
@Data
public class PrivilegeDto {
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

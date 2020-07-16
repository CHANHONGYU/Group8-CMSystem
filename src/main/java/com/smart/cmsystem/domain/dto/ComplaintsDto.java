package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.util.Date;

/**
    * 投诉管理表
    */
@Data
public class ComplaintsDto {
    /**
    * 投诉管理id
    */
    private Integer complaintId;

    /**
    * 投诉人id
    */
    private Integer ownerId;

    /**
    * 业主名字
    */
    private String ownerName;

    /**
    * 业主小区id
    */
    private Integer cCellid;

    /**
    * 所属小区
    */
    private String cCommunity;

    /**
    * 投诉标题
    */
    private String cName;

    /**
    * 投诉事由
    */
    private String cDetail;

    /**
    * 投诉时间
    */
    private Date createTime;

    /**
    * 是否匿名0->否,1->是
    */
    private Integer cStatus;


}
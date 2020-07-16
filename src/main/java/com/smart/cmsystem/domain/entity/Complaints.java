package com.smart.cmsystem.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 投诉管理表
    */
@Data
public class Complaints {
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

    /**
    * 是否删除0->N,1->Y
    */
    private Integer isDel;
}
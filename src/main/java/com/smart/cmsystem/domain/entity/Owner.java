package com.smart.cmsystem.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Owner {
    /**
    * 业主信息id
    */
    private Integer ownerId;

    /**
    * 所属小区id
    */
    private String ownerCommunityId;

    /**
    * 业主房产id
    */
    private Integer ownerHouseId;

    /**
    * 业主名字
    */
    private String ownerName;

    /**
    * 业主照片
    */
    private String ownerPic;

    /**
    * 业主身份证号码
    */
    private String ownerNo;

    /**
    * 业主联系方式
    */
    private String ownerConnect;

    /**
    * 业主职业
    */
    private String ownerWork;

    /**
    * 业主生日
    */
    private Date ownerBirth;

    /**
    * 业主性别
    */
    private String ownerGender;

    /**
    * 业主类型
    */
    private Integer ownerType;

    /**
    * 备注
    */
    private String ownerRemarks;

    /**
    * 创建时间
    */
    private Date creatTime;

    /**
    * 更新时间
    */
    private Date updateTime;

    /**
    * 假删除：0表示已删除，1表示存在
    */
    private Integer isDel;
}
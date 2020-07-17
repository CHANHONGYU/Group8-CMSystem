package com.smart.cmsystem.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 收费表
    */
@Data
public class Money implements Serializable {
    private Integer mId;

    /**
    * 收取金额小区名字
    */
    private String mCoumityName;

    /**
    * 收费编号
    */
    private String monConding;

    /**
    * 收费项目
    */
    private String monProject;

    /**
    * 创建时间
    */
    private String  createTime;

    /**
    * 截止时间
    */
    private String   endingTime;

    /**
    * 0代表未修改 1代表修改
    */
    private Integer mStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;
}
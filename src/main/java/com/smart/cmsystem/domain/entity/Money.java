package com.smart.cmsystem.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 收费表
    */
@Data
public class Money {
    private Integer monId;

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
    private Date createTime;

    /**
    * 1表示修改  0表示删除
    */
    private Integer monStatus;

    /**
    * 收费详情Id
    */
    private Integer monDetId;

    /**
    * 0代表未修改 1代表修改
    */
    private Integer mStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;
}
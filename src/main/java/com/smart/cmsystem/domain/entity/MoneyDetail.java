package com.smart.cmsystem.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
    * 收费详情表
    */
@Data
public class MoneyDetail {
    /**
    * 收费详情id
    */
    private Integer monDetId;

    /**
    * 小区名字
    */
    private String monCoumityName;

    /**
    * 收费项目Id
    */
    private String monDetProject;

    /**
    * 业主名字
    */
    private String ownerName;

    /**
    * 应收金额
    */
    private BigDecimal monReceivable;

    /**
    * 实收金额
    */
    private BigDecimal monFinal;

    /**
    * 备注
    */
    private String monText;

    /**
    * 缴费时间
    */
    private Date updateTime;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    *  0代表未修改 1代表修改
    */
    private Integer monStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;

    /**
    * 收费表Id
    */
    private Integer monId;
}
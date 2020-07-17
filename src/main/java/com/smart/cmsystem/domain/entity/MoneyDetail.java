package com.smart.cmsystem.domain.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;
import org.springframework.stereotype.Service;

/**
    * 收费详情表
    */
@Data
public class MoneyDetail implements Serializable {
    /**
    * 收费详情id
    */
    private Integer mdId;

    /**
    * 小区名字
    */
    private String monCoumityName;

    /**
    * 收费项目
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
    private Date  updateTime;

    /**
    * 截止时间
    */
    private String endingTime;

    /**
    * 创建时间
    */
    private String createTime;

    /**
    *  0代表未修改 1代表修改
    */
    private Integer monStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;
}
package com.smart.cmsystem.domain.entity;

import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class Assets {
    /**
    * 资产id
    */
    private Integer assetsId;

    /**
    * 所属小区id
    */
    private String communityId;

    /**
    * 设备编号
    */
    private String assetsNo;

    /**
    * 设备名称
    */
    private String assetsName;

    /**
    * 设备品牌
    */
    private String assetsBrand;

    /**
    * 购买单价
    */
    private BigDecimal assetsPrice;

    /**
    * 购买数量
    */
    private Integer assetsNumber;

    /**
    * 购买日期
    */
    private Date assetsBuytime;

    /**
    * 预计使用年限（年）
    */
    private String assetsLife;

    /**
    * 创建时间
    */
    private Date createTime;

    /**
    * 假删除：0是已删除，1是存在
    */
    private Integer isDel;
}
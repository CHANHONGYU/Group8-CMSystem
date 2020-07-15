package com.smart.cmsystem.domain.entity;

import java.util.Date;

import lombok.Data;

@Data
public class Cell {
    /**
    * 小区ID
    */
    private Integer cId;

    /**
    * 小区编号
    */
    private String cNumber;

    /**
    * 小区名称
    */
    private String cName;

    /**
    * 小区地址
    */
    private String cAddress;

    /**
    * 占地面积(m^2)
    */
    private Integer cAreacovered;

    /**
    * 总栋数
    */
    private Integer cBuildings;

    /**
    * 总户数
    */
    private Integer cTotalusers;

    /**
    * 绿化率(%)
    */
    private Integer cGreen;

    /**
    * 缩略图
    */
    private String cThumbnail;

    /**
    * 开发商名称
    */
    private String cDevelopername;

    /**
    * 物业公司名称
    */
    private String cPropertycompany;

    /**
    * 创建时间
    */

    private Date cCreationtime;

    /**
    * 状态 1为启用 ，0为停用
    */
    private Integer cState;

    /**
    * 删除 1为未删除，0为已删除
    */
    private Integer cDel;
}
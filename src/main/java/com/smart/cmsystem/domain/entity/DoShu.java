package com.smart.cmsystem.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 栋数表
    */
@Data
public class DoShu implements Serializable {
    /**
    * 栋数Id
    */
    private Integer dId;

    /**
    * 栋数小区名字
    */
    private String dCoumityName;

    /**
    * 栋数编号
    */
    private String dCoding;

    /**
    * 栋数名称
    */
    private String dName;

    /**
    * 总户数
    */
    private Integer dSum;

    /**
    * 描述
    */
    private String dTxt;

    /**
    * 注册时间
    */
    private String  createTime;
    private  String endingTime;
    /**
    * 0代表未修改  1代表修改
    */
    private Integer dStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;
}
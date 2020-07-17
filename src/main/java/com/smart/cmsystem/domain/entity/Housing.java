package com.smart.cmsystem.domain.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
    * 房产表
    */
@Data
public class Housing implements Serializable {
    /**
    * 房产id
    */
    private Integer hId;

    /**
    * 小区名字
    */
    private String hCoumityName;

    /**
    * 房产栋数名字
    */
    private String hDName;

    /**
    * 房产编码
    */
    private String hConding;

    /**
    * 房产名称
    */
    private String hName;

    /**
    * 户主名称
    */
    private String hOwnerName;

    /**
    * 户主的联系方式
    */
    private String hOwnPhone;

    /**
    * 房间数
    */
    private Integer hHome;

    /**
    * 单元
    */
    private Integer hCell;

    /**
    * 楼层
    */
    private Integer hLevel;

    /**
    * 描述
    */
    private String hTxt;

    /**
    * 注册时间
    */
    private String  createTime;
private  String endingTime;
    /**
    * 0表示未修改  1表示修改
    */
    private Integer hStatus;

    /**
    * 0代表未删除 1代表删除
    */
    private Integer isDel;
}
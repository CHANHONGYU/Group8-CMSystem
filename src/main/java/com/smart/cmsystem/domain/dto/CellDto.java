package com.smart.cmsystem.domain.dto;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.Date;

@Data
public class CellDto {

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
    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
    private Date cCreationtime;

    /**
     * 状态 1为启用 ，0为停用
     */
    private Integer cState;

}

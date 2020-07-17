package com.smart.cmsystem.domain.entity;

import java.util.Date;
import lombok.Data;

@Data
public class Pets {
    /**
     * 宠物id
     */
    private Integer petsId;

    /**
     * 宠物照片
     */
    private String petsPic;

    /**
     * 所属业主
     */
    private Integer ownerId;

    /**
     * 宠物种类名称
     */
    private String petsType;

    /**
     * 宠物颜色
     */
    private String petsColor;

    /**
     * 宠物备注
     */
    private String petsRemarks;

    /**
     * 收养时间
     */
    private Date petsAdoption;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 假删除：0是已删除，1是存在
     */
    private Integer isDel;
}
package com.smart.cmsystem.domain.dto;

import com.smart.cmsystem.domain.entity.Maintain;
import lombok.Data;

import java.util.Date;
@Data
public class MaintainDto {
    private Integer maintainId;

    /**
     * 小区
     */
    private String community;

    /**
     * 报修人
     */
    private String repairee;

    /**
     * 设备名称
     */
    private String deviceName;

    /**
     * 描述
     */
    private String description;

    private Date createTime;

    /**
     * 状态:1->待受理,2->已受理,3->已完成,0->已取消
     */
    private Integer status;

}

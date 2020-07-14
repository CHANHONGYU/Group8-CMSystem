package com.smart.cmsystem.domain.dto;

import lombok.Data;

import java.util.Date;
@Data
public class ActivitiesDto {

    private Integer actId;

    /**
     * 活动主题
     */
    private String theme;

    /**
     * 举办小区
     */
    private String community;

    /**
     * 活动地点
     */
    private String location;

    /**
     * 举办组织
     */
    private String organizers;

    /**
     * 活动开始时间
     */
    private Date startTime;

    /**
     * 活动结束时间
     */
    private Date endTime;

    /**
     * 状态:0->代表取消,1->未开始,2->进行中,3->结束
     */
    private Integer status;

}

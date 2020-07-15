package com.smart.cmsystem.domain.entity;

import java.util.Date;
import lombok.Data;

/**
    * 活动表
    */
@Data
public class Activities {
    /**
    * 活动id主键
    */
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
    * 创建时间
    */
    private Date createTime;

    /**
    * 状态:0->代表取消,1->未开始,2->进行中,3->结束
    */
    private Integer status;

    /**
    * 删除记录
    */
    private Integer isDel;
}
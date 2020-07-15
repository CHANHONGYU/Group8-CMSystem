package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.ActivitiesDto;
import com.smart.cmsystem.domain.entity.Activities;
import com.smart.cmsystem.utils.ResponseEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * keyword 搜索的参数
 * startTime 开始时间
 * endTime 结束时间
 */
public interface ActivitiesService {
    List<Activities> ActivitiesList(String keyword,String startTime,String endTime,int limit,int offset);
    ResponseEntity deleteActivities(List<Integer> actIds);
//    增加活动
    ResponseEntity saveActivities(ActivitiesDto activitiesDto);
    ResponseEntity updateActivities(ActivitiesDto activitiesDto);
}

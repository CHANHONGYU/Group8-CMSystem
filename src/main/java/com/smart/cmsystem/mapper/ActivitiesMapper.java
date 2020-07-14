package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Activities;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * keyword 搜索的参数
 * startTime 开始时间
 * endTime 结束时间
 */
public interface ActivitiesMapper {
    List<Activities> selectAll(@Param("keyword")String keyword,@Param("start_time") String startTime,@Param("end_time") String endTime,@Param("limit") int limit,@Param("offset") int offset);
    int deleteActivities(@Param("actIds") List<Integer> actIds);
    int saveActivities(@Param("activities") Activities activities);
    int updateActivities(@Param("act")Activities activities);
}
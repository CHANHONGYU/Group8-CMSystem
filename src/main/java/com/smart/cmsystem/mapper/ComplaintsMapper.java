package com.smart.cmsystem.mapper;


import com.smart.cmsystem.domain.entity.Complaints;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ComplaintsMapper {
    List<Complaints> selectAll(@Param("keyword")String keyword, @Param("start_time") String startTime, @Param("end_time") String endTime, @Param("limit") int limit, @Param("offset") int offset);

    int deleteComplaintsById(@Param("comIds")List<Integer> comIds);

    /**
     * 存一条数据
     */
    int saveComplaint(@Param("complaints")Complaints complaints);

    /**
     * 修改投诉的信息
     */
    int updateComplaint(@Param("complaints")Complaints complaints);
}
package com.smart.cmsystem.mapper;

import com.smart.cmsystem.domain.entity.Maintain;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MaintainMapper {

    List<Maintain> selectAllByKey(@Param("keyword")String keyword,@Param("start_time") String startTime,@Param("end_time") String endTime,@Param("limit") int limit,@Param("offset") int offset);

    int deleteMaintain(@Param("mIds") List<Integer> mIds);

    int insertMaintain(@Param("maintain") Maintain maintain);

    int updateMaintain(@Param("maintain")Maintain maintain);
}
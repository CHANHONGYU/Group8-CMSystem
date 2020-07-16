package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.ComplaintsDto;
import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Complaints;
import com.smart.cmsystem.utils.ResponseEntity;

import java.util.List;

public interface ComplaintsService {
    /**
     * 通过关键字 和时间区间查询相关的数据
     * @return
     */
    List<ComplaintsDto> selectAllComplaintsByKey(String keyword,String startTime,String endTime,int limit,int offset);
    /**
     * 通过id删除
     */
    ResponseEntity deleteComplaintsById(List<Integer> comIds);
    /**
     * 添加一条投诉
     */
    ResponseEntity saveComplaint(ComplaintsDto complaintsDto);


    ResponseEntity updateComplaint(ComplaintsDto complaintsDto);
}

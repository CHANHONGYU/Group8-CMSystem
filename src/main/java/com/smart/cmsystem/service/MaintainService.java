package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.MaintainDto;

import java.util.List;

public interface MaintainService {
    List<MaintainDto> selectAllByKey(String keyword, String startTime, String endTime, int limit, int offset);
}

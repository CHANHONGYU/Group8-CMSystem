package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.MaintainDto;
import com.smart.cmsystem.domain.entity.Maintain;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ResponseEntity;

import java.util.List;

public interface MaintainService {
    List<MaintainDto> selectAllByKey(String keyword, String startTime, String endTime, int limit, int offset) throws ServiceException;

    /**
     * 批量删除
     * @param mids maintain_id
     * @return
     */
    ResponseEntity deleteMaintain(List<Integer> mids) throws ServiceException;
    /**
     *添加
     */
    ResponseEntity insertMaintain(MaintainDto maintainDto);
    /**
     * 修改
     */
    ResponseEntity updateMaintain(MaintainDto maintainDto);
}

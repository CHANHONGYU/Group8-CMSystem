package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ResponseEntity;

import java.rmi.ServerException;
import java.util.List;

/*
房产的接口
 */
public interface HousingService {
    /**
     * 添加房产
     *
     */

    ResponseEntity insertHousing(HousingDto housingDto);
    /**
     * 修改单个房产的信息
     */
    ResponseEntity alterHousing(HousingDto housingDto);
    /**
     * 删除单个房产的信息
     */
    ResponseEntity delHousing(int hId);
    /**
     * 批量删除房产的信息
     */
    ResponseEntity delHousings(List<Integer> hIds) throws ServiceException;
    /**
     * 显示所有业主的信息
     */
    List<HousingDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws  ServiceException;
}

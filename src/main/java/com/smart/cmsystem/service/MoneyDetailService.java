package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.dto.MoneyDetailDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ResponseEntity;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface MoneyDetailService {
    /**
     * 添加房产
     *
     */

    ResponseEntity insertMoneyDetail(MoneyDetailDto moneyDetailDto);
    /**
     * 修改单个房产的信息
     */
    ResponseEntity alterMoneyDetailDto(MoneyDetailDto moneyDetailDto);
    /**
     * 删除单个房产的信息
     */
    ResponseEntity delMoneyDetail(int mdId);
    /**
     * 批量删除房产的信息
     */
    ResponseEntity delMoneyDetails(List<Integer> mdIds) throws ServiceException;
    /**
     * 显示所有业主的信息
     */
    List<MoneyDetailDto> findAll(String keyWord, String update, String createTime, String endingTime, int limit, int offset) throws  ServiceException;
}

package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.domain.dto.MoneyDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ResponseEntity;

import java.util.List;

public interface MoneyService {
/*
  *收费项目的信息
 */
        ResponseEntity insertMoney(MoneyDto moneyDto);
        /**
         * 修改单个收费项目的信息
         */
        ResponseEntity alterMoney(MoneyDto moneyDto);
        /**
         * 删除单个收费项目的信息
         */
        ResponseEntity delMoney(int mId);
        /**
         * 批量删除收费项目的信息
         */
        ResponseEntity deleteMoneys(List<Integer> mIds) throws ServiceException;
        /**
         * 显示所有收费项目的信息
         */
        List<MoneyDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws  ServiceException;
    }



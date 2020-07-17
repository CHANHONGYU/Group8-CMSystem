package com.smart.cmsystem.service;

import com.smart.cmsystem.domain.dto.DoShuDto;
import com.smart.cmsystem.domain.dto.HousingDto;
import com.smart.cmsystem.exception.ServiceException;
import com.smart.cmsystem.utils.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

public interface DoShuService {
    /**
     * 添加栋数
     *
     */
    ResponseEntity insertDoShu(DoShuDto doShuDto);
    /**
     * 修改单个房产的信息
     */
    ResponseEntity alterDoShu(DoShuDto doShuDto);
    /**
     * 删除单个房产的信息
     */
    ResponseEntity delDoShu(int dId);
    /**
     * 批量删除房产的信息
     */
    ResponseEntity delDoShuAll(List<Integer> dIds) throws ServiceException;
    /**
     * 显示所有业主的信息
     */
    List<DoShuDto> findAll(String keyWord, String createTime, String endingTime, int limit, int offset) throws  ServiceException;
}
